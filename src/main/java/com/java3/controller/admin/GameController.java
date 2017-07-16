package com.java3.controller.admin;

import com.java3.model.Game;
import com.java3.model.GameLocation;
import com.java3.model.League;
import com.java3.model.TeamGame;
import com.java3.repository.GameLocationRepository;
import com.java3.repository.GameRepository;
import com.java3.repository.LeagueRepository;
import com.java3.repository.TeamGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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

    @Autowired
    private TeamGameRepository teamGameRepository;

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

    @RequestMapping(value="/games/add", method = RequestMethod.POST)
    public ModelAndView saveNew(@Valid Game game, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        ModelAndView viewModel = new ModelAndView();

        if (bindingResult.hasErrors()) {
            List<GameLocation> gameLocations = gameLocationRepository.findAll();
            viewModel.addObject("gameLocations", gameLocations);

            List<League> leagueList = leagueRepository.findAll();
            viewModel.addObject("leagueList", leagueList);

            viewModel.setViewName("admin/games/game-new");
        } else {
            gameRepository.save(game);
            redirectAttrs.addFlashAttribute("successMessage", "Game has been saved successfully");
            return new ModelAndView("redirect:/admin/games/");
        }
        return viewModel;
    }

    @RequestMapping(value="/games/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable("id") int id) {
        ModelAndView viewModel = new ModelAndView();
        viewModel.setViewName("admin/games/game-edit");

        Game game = gameRepository.findOne(id);
        viewModel.addObject("game", game);

        List<TeamGame> teamGames = teamGameRepository.findByGameId(game.getGameId());
        viewModel.addObject("teamGames", teamGames);

        return viewModel;
    }

    @RequestMapping(value="/games/edit/{id}", method = RequestMethod.POST)
    public ModelAndView update(@PathVariable("id") int gameId, @RequestParam Map<String,String> allRequestParams, RedirectAttributes redirectAttrs) {
        Iterator it = allRequestParams.entrySet().iterator();

        // Inputs per team have a name attr with a ":" to separate name from TeamGame id
        // For each of those, we want to split the "key" by the ":" and get the second value as the id
        // The value of the input is the score
        // Validation is client-side in JS
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            int teamGameId = Integer.parseInt(pair.getKey().toString().split(":")[1]);
            int teamGameScore = Integer.parseInt((String) pair.getValue());
            TeamGame teamGame = teamGameRepository.findOne(teamGameId);
            teamGame.setScore(teamGameScore);
            teamGameRepository.save(teamGame);
            it.remove();
        }

        redirectAttrs.addFlashAttribute("successMessage", "Game has been saved successfully");
        return new ModelAndView("redirect:/admin/games/");
    }

    @RequestMapping(value = {"/games/edit/{id}", "/games/add"}, method = RequestMethod.POST, params="action=cancel")
    public ModelAndView cancel() {
        return new ModelAndView("redirect:/admin/games/");
    }
}
