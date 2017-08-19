package com.java3.controller;

import com.java3.model.League;
import com.java3.model.LeagueType;
import com.java3.repository.LeagueRepository;
import com.java3.repository.LeagueTypeRepository;
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
 *
 * This class contains all the public page methods
 */
@Controller
public class HomeController {

    // Necessary Repositories

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private LeagueRepository leagueRepository;

    @Autowired
    private LeagueTypeRepository leagueTypeRepository;

    /**
     * Index Page (displays a simple view with a carousel of all teams
     * @return
     */
    @RequestMapping(value={"/", "/index"})
    public ModelAndView index() {
        ModelAndView viewModel = new ModelAndView();
        viewModel.setViewName("index");
        List<Team> teamList = teamRepository.findAll();
        viewModel.addObject("teams", teamList);
        return viewModel;
    }

    /**
     * Main Leagues page (list view by league type)
     * Using lambdas here for sorting
     * @return
     */
    @RequestMapping(value="/leagues")
    public ModelAndView leagues() {
        ModelAndView viewModel = new ModelAndView();
        // Get League Types
        List<LeagueType> leagueTypes;
        leagueTypes = leagueTypeRepository.findAll();
        leagueTypes.sort((LeagueType o1, LeagueType o2) -> o1.getLabel().compareTo( o2.getLabel() ));
        viewModel.addObject("leagueTypes", leagueTypes);

        // Get Leagues
        List<League> leagueList;
        leagueList = leagueRepository.findAll();
        leagueList.sort((League o1, League o2) -> o1.getLeagueType().getLabel().compareTo( o2.getLeagueType().getLabel() ));
        viewModel.addObject("leagueList", leagueList);
        viewModel.setViewName("leagues");
        return viewModel;
    }

    /**
     * View league info for a given league
     * @param id
     * @return
     */
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

    /**
     * View Team info for a given team
     * @param id
     * @return
     */
    @RequestMapping(value={"/teams/{id}"})
    public ModelAndView teamsDetail(@PathVariable("id") int id) {
        ModelAndView viewModel = new ModelAndView();
        Team team = teamRepository.findOne(id);
        viewModel.addObject("team", team);
        viewModel.setViewName("team-detail");
        return viewModel;
    }

    // View Team info for a given team by team name
    @RequestMapping(value={"/team/{teamName}"})
    public ModelAndView teamsDetail(@PathVariable("teamName") String teamName) {
        ModelAndView viewModel = new ModelAndView();
        Team team = teamRepository.findTeamByName(teamName);
        viewModel.addObject("team", team);
        viewModel.setViewName("team-detail");
        return viewModel;
    }

    /**
     * View schedules
     * @return
     */
    @RequestMapping(value="/schedules")
    public ModelAndView schedules() {
        ModelAndView viewModel = new ModelAndView();
        viewModel.setViewName("schedules");
        return viewModel;
    }

    /**
     * View about page/info
     * @return
     */
    @RequestMapping(value="/about")
    public ModelAndView about() {
        ModelAndView viewModel = new ModelAndView();
        viewModel.setViewName("about");
        return viewModel;
    }

    /**
     * If a user attempts to view a page they are not authenticated to view,
     * we show an access-denied page.
     * @return
     */
    @RequestMapping(value="/access-denied")
    public ModelAndView accessDenied() {
        ModelAndView viewModel = new ModelAndView();
        viewModel.setViewName("access-denied");
        return viewModel;
    }
}
