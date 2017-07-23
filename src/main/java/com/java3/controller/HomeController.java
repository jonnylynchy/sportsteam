package com.java3.controller;

import java.util.Comparator;
import com.java3.model.League;
import com.java3.repository.LeagueRepository;
import com.java3.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java3.model.Team;

import java.util.List;

/**
 * Created by jon.lynch on 6/21/17.
 */
@Controller
public class HomeController {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private LeagueRepository leagueRepository;

    @RequestMapping(value={"/", "/index"})
    public ModelAndView index() {
        ModelAndView viewModel = new ModelAndView();
        viewModel.setViewName("index");
        List<Team> teamList = teamRepository.findAll();
        viewModel.addObject("teams", teamList);
        return viewModel;
    }

    @RequestMapping(value="/leagues")
    public ModelAndView leagues() {
        ModelAndView viewModel = new ModelAndView();
        List<League> leagueList;
        leagueList = leagueRepository.findAll();
        leagueList.sort((League o1, League o2) -> o1.getLeagueType().getLabel().compareTo( o2.getLeagueType().getLabel() ));
        viewModel.addObject("leagueList", leagueList);
        viewModel.setViewName("leagues");
        return viewModel;
    }

    @RequestMapping(value="/leagues/{id}")
    public ModelAndView leagueDetail(@PathVariable("id") int id) {
        ModelAndView viewModel = new ModelAndView();
        League league = leagueRepository.findOne(id);
        List<Team> teamList = teamRepository.findTeamsByLeague(league);
        teamList.sort((Team o1, Team o2) -> o1.getName().compareTo( o2.getName() ));
        viewModel.addObject("league", league);
        viewModel.addObject("teamList", teamList);
        viewModel.setViewName("league-detail");
        return viewModel;
    }

    @RequestMapping(value="/teams/{id}")
    public ModelAndView teamsDetail(@PathVariable("id") int id) {
        ModelAndView viewModel = new ModelAndView();
        Team team = teamRepository.findOne(id);
        viewModel.addObject("team", team);
        viewModel.setViewName("team-detail");
        return viewModel;
    }

    @RequestMapping(value="/schedules")
    public ModelAndView schedules() {
        ModelAndView viewModel = new ModelAndView();
        viewModel.setViewName("schedules");
        return viewModel;
    }

    @RequestMapping(value="/about")
    public ModelAndView about() {
        ModelAndView viewModel = new ModelAndView();
        viewModel.setViewName("about");
        return viewModel;
    }

    @RequestMapping(value="/access-denied")
    public ModelAndView accessDenied() {
        ModelAndView viewModel = new ModelAndView();
        viewModel.setViewName("access-denied");
        return viewModel;
    }
}
