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
import org.springframework.web.bind.annotation.PathVariable;
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
        viewModel.setViewName("leagues/leagues");
        List<League> leagueList = leagueRepository.findAll();
        viewModel.addObject("leagues", leagueList);

        return viewModel;
    }

    @RequestMapping(value="/leagues/add", method = RequestMethod.GET)
    public ModelAndView leagueNew() {
        ModelAndView viewModel = new ModelAndView();
        viewModel.setViewName("leagues/league-new");

        League league = new League();
        viewModel.addObject("league", league);

        List<LeagueType> leagueTypes = leagueTypeRepository.findAll();
        viewModel.addObject("leagueTypes", leagueTypes);

        return viewModel;
    }

    @RequestMapping(value="/leagues/{id}", method = RequestMethod.GET)
    public ModelAndView leagueEdit(@PathVariable("id") int id) {
        ModelAndView viewModel = new ModelAndView();
        viewModel.setViewName("leagues/league-edit");

        League league = leagueRepository.findOne(id);
        viewModel.addObject("league", league);

        List<LeagueType> leagueTypes = leagueTypeRepository.findAll();
        viewModel.addObject("leagueTypes", leagueTypes);

        return viewModel;
    }

    @RequestMapping(value="/leagues/delete/{id}", method = RequestMethod.GET)
    public ModelAndView leagueArchive(@PathVariable("id") int id, RedirectAttributes redirectAttrs) {
        League league = leagueRepository.findOne(id);
        leagueRepository.delete(league);
        redirectAttrs.addFlashAttribute("successMessage", "League has been deleted");
        return new ModelAndView("redirect:/leagues");
    }

    @RequestMapping(value="/leagues/{id}", method = RequestMethod.POST)
    public ModelAndView createNewLeague(@Valid League league, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        ModelAndView viewModel = new ModelAndView();
        if (bindingResult.hasErrors()) {
            List<LeagueType> leagueTypes = leagueTypeRepository.findAll();
            viewModel.addObject("leagueTypes", leagueTypes);
            viewModel.setViewName("leagues/league-edit");
        } else {
            leagueRepository.save(league);
            redirectAttrs.addFlashAttribute("successMessage", "League has been saved successfully");
            return new ModelAndView("redirect:/leagues");
        }
        return viewModel;
    }

}
