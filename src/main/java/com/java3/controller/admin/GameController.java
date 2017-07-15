package com.java3.controller.admin;

import com.java3.model.Game;
import com.java3.model.GameLocation;
import com.java3.model.League;
import com.java3.repository.GameLocationRepository;
import com.java3.repository.GameRepository;
import com.java3.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;

/**
 * Created by jon.lynch on 7/9/17.
 */

@Controller
@RequestMapping("admin/")
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GameLocationRepository gameLocationRepository;

    @Autowired
    private LeagueRepository leagueRepository;

    @RequestMapping(value={"games/"}, method = RequestMethod.GET)
    public ModelAndView gamesIndex() {
        ModelAndView viewModel = new ModelAndView();
        List<Game> games = gameRepository.findAll();
        viewModel.addObject("games", games);
        viewModel.setViewName("admin/games/games");
        return viewModel;
    }

    @RequestMapping(value = "games/add", method = RequestMethod.GET)
    public ModelAndView gamesAdd() {
        ModelAndView viewModel = new ModelAndView();
        Game game = new Game();
        viewModel.addObject("game", game);

        List<GameLocation> gameLocations = gameLocationRepository.findAll();
        viewModel.addObject("gameLocations", gameLocations);

        List<League> leagueList = leagueRepository.findAll();
        viewModel.addObject("leagueList", leagueList);

        viewModel.setViewName("admin/games/game-new");
        return viewModel;
    }

    @RequestMapping(value = {"/games/edit", "/games/add"}, method = RequestMethod.POST, params="action=cancel")
    public ModelAndView cancel() {
        return new ModelAndView("redirect:/admin/games/");
    }
}
