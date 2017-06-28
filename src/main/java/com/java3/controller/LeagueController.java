package com.java3.controller;

import com.java3.model.League;
import com.java3.model.LeagueType;
import com.java3.repository.LeagueRepository;
import com.java3.repository.LeagueTypeRepository;
import com.java3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by jon.lynch on 6/27/17.
 */
@Controller
public class LeagueController {
    @Autowired
    private LeagueRepository leagueRepository;

    @Autowired
    private LeagueTypeRepository leagueTypeRepository;

    @Autowired
    private UserService userService;

    @RequestMapping(value={"/leagues"})
    public ModelAndView index() {
        ModelAndView viewModel = new ModelAndView();
        viewModel.setViewName("leagues");
        List<League> leagueList = leagueRepository.findAll();
        viewModel.addObject("leagues", leagueList);

        return viewModel;
    }

    @RequestMapping(value="/leagues/add", method = RequestMethod.GET)
    public ModelAndView leagueNew() {
        ModelAndView viewModel = new ModelAndView();
        viewModel.setViewName("league-new");

        League league = new League();
        viewModel.addObject("league", league);

        List<LeagueType> leagueTypes = leagueTypeRepository.findAll();
        viewModel.addObject("leagueTypes", leagueTypes);

        return viewModel;
    }

    @RequestMapping(value = "/leagues/add", method = RequestMethod.POST)
    public ModelAndView createNewLeague(@Valid League league, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        ModelAndView viewModel = new ModelAndView();
        League leagueExists = leagueRepository.findLeagueByLabel(league.getLabel());
        if (leagueExists != null) {
            bindingResult
                    .rejectValue("label", "error.league",
                            "There is already a league registered with the name provided");
        }
        if (bindingResult.hasErrors()) {
            List<LeagueType> leagueTypes = leagueTypeRepository.findAll();
            viewModel.addObject("leagueTypes", leagueTypes);
            viewModel.setViewName("league-new");
        } else {
            leagueRepository.save(league);
            redirectAttrs.addFlashAttribute("successMessage", "League has been registered successfully");
            return new ModelAndView("redirect:/leagues");
        }
        return viewModel;
    }

}
