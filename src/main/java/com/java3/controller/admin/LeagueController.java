package com.java3.controller.admin;

import com.java3.model.League;
import com.java3.model.LeagueType;
import com.java3.repository.LeagueRepository;
import com.java3.repository.LeagueTypeRepository;
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
 * Created by jon.lynch on 6/27/17.
 *
 * This controller contains all the methods for league-related pages in admin
 */
@Controller
@RequestMapping("admin/")
public class LeagueController {

    // Necessary Repositories for Leagues

    @Autowired
    private LeagueRepository leagueRepository;

    @Autowired
    private LeagueTypeRepository leagueTypeRepository;

    /**
     * Main League View (returns list of leagues in view)
     * @return
     */
    @RequestMapping(value={"/leagues"}, method = RequestMethod.GET)
    public ModelAndView leagues() {
        ModelAndView viewModel = new ModelAndView();
        viewModel.setViewName("admin/leagues/leagues");
        List<League> leagueList = leagueRepository.findAll();
        viewModel.addObject("leagues", leagueList);
        return viewModel;
    }

    /**
     * Add League Page: View
     * @return
     */
    @RequestMapping(value="/leagues/add", method = RequestMethod.GET)
    public ModelAndView leagueNew() {
        ModelAndView viewModel = new ModelAndView();
        viewModel.setViewName("admin/leagues/league-new");

        League league = new League();
        viewModel.addObject("league", league);

        List<LeagueType> leagueTypes = leagueTypeRepository.findAll();
        viewModel.addObject("leagueTypes", leagueTypes);

        return viewModel;
    }

    /**
     * Add A New League: Post
     * @param league
     * @param bindingResult
     * @param redirectAttrs
     * @return
     */
    @RequestMapping(value="/leagues/add", method = RequestMethod.POST)
    public ModelAndView saveNew(@Valid League league, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        ModelAndView viewModel = new ModelAndView();
        if (bindingResult.hasErrors()) {
            List<LeagueType> leagueTypes = leagueTypeRepository.findAll();
            viewModel.addObject("leagueTypes", leagueTypes);
            viewModel.setViewName("admin/leagues/league-new");
        } else {
            leagueRepository.save(league);
            redirectAttrs.addFlashAttribute("successMessage", "League has been saved successfully");
            return new ModelAndView("redirect:/admin/leagues");
        }
        return viewModel;
    }

    /**
     * League Edit: View
     * @param id
     * @return
     */
    @RequestMapping(value="/leagues/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") int id) {
        ModelAndView viewModel = new ModelAndView();
        viewModel.setViewName("admin/leagues/league-edit");

        League league = leagueRepository.findOne(id);
        viewModel.addObject("league", league);

        List<LeagueType> leagueTypes = leagueTypeRepository.findAll();
        viewModel.addObject("leagueTypes", leagueTypes);

        return viewModel;
    }

    /**
     * League Edit: Post
     * @param league
     * @param bindingResult
     * @param redirectAttrs
     * @return
     */
    @RequestMapping(value="/leagues/edit", method = RequestMethod.POST)
    public ModelAndView save(@Valid League league, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        ModelAndView viewModel = new ModelAndView();
        if (bindingResult.hasErrors()) {
            List<LeagueType> leagueTypes = leagueTypeRepository.findAll();
            viewModel.addObject("leagueTypes", leagueTypes);
            viewModel.setViewName("admin/leagues/league-edit");
        } else {
            leagueRepository.save(league);
            redirectAttrs.addFlashAttribute("successMessage", "League has been saved successfully");
            return new ModelAndView("redirect:/admin/leagues");
        }
        return viewModel;
    }

    /**
     * Handles cancel request out of edit or add, redirects to main list view
     * @return
     */
    @RequestMapping(value = {"/leagues/edit", "/leagues/add"}, method = RequestMethod.POST, params="action=cancel")
    public ModelAndView cancel() {
        return new ModelAndView("redirect:/admin/leagues");
    }

    /**
     * Handles Deletion of League
     * @param id
     * @param redirectAttrs
     * @return
     */
    @RequestMapping(value="/leagues/delete/{id}", method = RequestMethod.GET)
    public ModelAndView leagueArchive(@PathVariable("id") int id, RedirectAttributes redirectAttrs) {
        League league = leagueRepository.findOne(id);
        leagueRepository.delete(league);
        redirectAttrs.addFlashAttribute("successMessage", "League has been deleted");
        return new ModelAndView("redirect:/admin/leagues");
    }

}
