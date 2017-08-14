package com.java3.controller.admin;

import com.java3.model.League;
import com.java3.model.LeagueTypePosition;
import com.java3.model.User;
import com.java3.repository.LeagueRepository;
import com.java3.repository.LeagueTypePositionRepository;
import com.java3.repository.TeamRepository;
import com.java3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

/**
 * Created by jon.lynch on 7/9/17.
 */

@Controller
@RequestMapping("admin/")
public class RosterController {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LeagueRepository leagueRepository;

    @Autowired
    private LeagueTypePositionRepository leagueTypePositionRepository;

    @RequestMapping(value={"roster/"}, method = RequestMethod.GET)
    public ModelAndView rosterIndex() {
        ModelAndView viewModel = new ModelAndView();

        // Get all leagues
        List<League> leagueList = leagueRepository.findAll();
        viewModel.addObject("leagueList", leagueList);

        viewModel.setViewName("admin/roster/roster");
        return viewModel;
    }

    @RequestMapping(value={"roster/save"}, method = RequestMethod.POST)
    public ModelAndView rosterSave(@RequestParam Map<String,String> allRequestParams, RedirectAttributes redirectAttrs) {
        Iterator it = allRequestParams.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry playerPositionField = (Map.Entry)it.next();
            int playerId = Integer.parseInt(playerPositionField.getKey().toString());
            int positionId = Integer.parseInt((String) playerPositionField.getValue());
            User player = userRepository.findOne(playerId);
            LeagueTypePosition position = leagueTypePositionRepository.findOne(positionId);
            Set<LeagueTypePosition> playerPositions = player.getPositions();
            playerPositions.clear();
            playerPositions.add(position);
            player.setPositions(playerPositions);
            userRepository.save(player);
            it.remove();
        }

        redirectAttrs.addFlashAttribute("successMessage", "Roster has been saved successfully");
        return new ModelAndView("redirect:/admin/roster/");
    }

    @RequestMapping(value = {"/roster/save"}, method = RequestMethod.POST, params="action=cancel")
    public ModelAndView cancel() {
        return new ModelAndView("redirect:/admin/roster/");
    }
}
