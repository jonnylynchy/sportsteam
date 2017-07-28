package com.java3.controller.admin;

import com.java3.model.League;
import com.java3.repository.LeagueRepository;
import com.java3.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by jon.lynch on 7/9/17.
 */

@Controller
@RequestMapping("admin/")
public class RosterController {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private LeagueRepository leagueRepository;

    @RequestMapping(value={"roster/"}, method = RequestMethod.GET)
    public ModelAndView rosterIndex() {
        ModelAndView viewModel = new ModelAndView();

        // Get all leagues
        List<League> leagueList = leagueRepository.findAll();
        viewModel.addObject("leagueList", leagueList);

        viewModel.setViewName("admin/roster/roster");
        return viewModel;
    }

    @RequestMapping(value = {"/roster/save"}, method = RequestMethod.POST, params="action=cancel")
    public ModelAndView cancel() {
        return new ModelAndView("redirect:/admin/roster/");
    }
}
