package com.java3.controller.admin;

import com.java3.model.League;
import com.java3.model.LeagueType;
import com.java3.model.Team;
import com.java3.repository.LeagueRepository;
import com.java3.repository.TeamRepository;
import com.java3.utils.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by jon.lynch on 7/5/17.
 *
 * This controller contains all the methods for team-related pages in admin
 */
@Controller
@RequestMapping("admin/")
public class TeamController {

    // Necessary Repositories

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private LeagueRepository leagueRepository;

    /**
     * Teams List: View
     * @return
     */
    @RequestMapping(value={"/teams"}, method = RequestMethod.GET)
    public ModelAndView teams() {
        ModelAndView viewModel = new ModelAndView();
        viewModel.setViewName("admin/teams/teams");
        List<Team> teamList = teamRepository.findAll();
        viewModel.addObject("teams", teamList);
        return viewModel;
    }

    /**
     * Team Add: View
     * @return
     */
    @RequestMapping(value="/teams/add", method = RequestMethod.GET)
    public ModelAndView teamNew() {
        ModelAndView viewModel = new ModelAndView();
        viewModel.setViewName("admin/teams/team-new");

        Team team = new Team();
        viewModel.addObject("team", team);

        List<Integer> years = Utils.getYears(50);
        viewModel.addObject("years", years);

        List<League> leagueList = leagueRepository.findAll();
        viewModel.addObject("leagueList", leagueList);

        return viewModel;
    }

    /**
     * Team Add: Post
     * @param team
     * @param bindingResult
     * @param redirectAttrs
     * @return
     */
    @RequestMapping(value="/teams/add", method = RequestMethod.POST)
    public ModelAndView saveNew(@Valid Team team, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        ModelAndView viewModel = new ModelAndView();
        if (bindingResult.hasErrors()) {
            List<Integer> years = Utils.getYears(50);
            viewModel.addObject("years", years);

            List<League> leagueList = leagueRepository.findAll();
            viewModel.addObject("leagueList", leagueList);
            viewModel.setViewName("admin/teams/team-new");
        } else {
            teamRepository.save(team);
            redirectAttrs.addFlashAttribute("successMessage", "Team has been saved successfully");
            return new ModelAndView("redirect:/admin/teams");
        }
        return viewModel;
    }

    /**
     * Team Edit: View
     * @param id
     * @return
     */
    @RequestMapping(value="/teams/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") int id) {
        ModelAndView viewModel = new ModelAndView();
        viewModel.setViewName("admin/teams/team-edit");

        Team team = teamRepository.findOne(id);
        viewModel.addObject("team", team);

        List<Integer> years = Utils.getYears(50);
        viewModel.addObject("years", years);

        List<League> leagueList = leagueRepository.findAll();
        viewModel.addObject("leagueList", leagueList);

        return viewModel;
    }

    /**
     * Team Edit: Post
     * @param team
     * @param bindingResult
     * @param redirectAttrs
     * @return
     */
    @RequestMapping(value="/teams/edit", method = RequestMethod.POST)
    public ModelAndView save(@Valid Team team, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        ModelAndView viewModel = new ModelAndView();
        if (bindingResult.hasErrors()) {
            List<Integer> years = Utils.getYears(50);
            viewModel.addObject("years", years);

            List<League> leagueList = leagueRepository.findAll();
            viewModel.addObject("leagueList", leagueList);
            viewModel.setViewName("admin/teams/team-edit");
        } else {
            teamRepository.save(team);
            redirectAttrs.addFlashAttribute("successMessage", "Team has been saved successfully");
            return new ModelAndView("redirect:/admin/teams");
        }
        return viewModel;
    }

    /**
     * Handles cancel request, redirects to list view
     * @return
     */
    @RequestMapping(value = {"/teams/edit", "/teams/add"}, method = RequestMethod.POST, params="action=cancel")
    public ModelAndView cancel() {
        return new ModelAndView("redirect:/admin/teams");
    }

}
