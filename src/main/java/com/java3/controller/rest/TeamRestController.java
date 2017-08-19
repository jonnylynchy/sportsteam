package com.java3.controller.rest;

import com.java3.model.*;
import com.java3.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jon.lynch on 6/21/17.
 *
 * This class exposes JSON lists to HTTP requests (via javascript) for Team Information
 */
@RestController
@RequestMapping("/api/v1/")
public class TeamRestController {

    // Necessary Repositories

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private LeagueRepository leagueRepository;

    @Autowired
    private LeagueTypePositionRepository leagueTypePositionRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamGameRepository teamGameRepository;

    /**
     * List of all teams
     * @return
     */
    @RequestMapping(value = "teams", method =RequestMethod.GET )
    public List<Team> list() {
        return teamRepository.findAll();
    }

    /**
     * List of all teams by league
     * @param leagueId
     * @return
     */
    @RequestMapping(value = "teams/league/{leagueId}", method =RequestMethod.GET)
    public List<Team> listByLeagueId(@PathVariable int leagueId) {
        League league = leagueRepository.findOne(leagueId);
        List<Team> teamList = teamRepository.findTeamsByLeague(league);
        return teamList;
    }

    /**
     * List of all players by team
     * @param id
     * @return
     */
    @RequestMapping(value = "teams/{id}/players/", method =RequestMethod.GET)
    public List<Player> playerListByTeamId(@PathVariable int id) {
        Team team = teamRepository.findOne(id);
        List<Player> playerList = playerRepository.findPlayersByTeams(team);
        return playerList;
    }

    /**
     * Returns a particular position (from player's position id)
     * @param id
     * @return
     */
    @RequestMapping(value = "player/{id}", method =RequestMethod.GET)
    public LeagueTypePosition getPlayerPosition(@PathVariable int id) {
        LeagueTypePosition position = leagueTypePositionRepository.findOne(id);
        return position;
    }

    /**
     * Returns a list of all "TeamGames" by a game id (both teams will be returned here for score on both sides)
     * @param id
     * @return
     */
    @RequestMapping(value = "game/{id}", method = RequestMethod.GET)
    public List<TeamGame> getTeamGames(@PathVariable int id) {
        List<TeamGame> teamGames = teamGameRepository.findByGameId(id);
        return teamGames;
    }

    /**
     * Returns a given team's info
     * @param id
     * @return
     */
    @RequestMapping(value = "teams/{id}", method = RequestMethod.GET)
    public Team get(@PathVariable int id) {
        return teamRepository.findOne(id);
    }
}
