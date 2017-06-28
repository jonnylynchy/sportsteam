package com.java3.controller;

import com.java3.model.League;
import com.java3.model.Team;
import com.java3.model.User;
import com.java3.repository.LeagueRepository;
import com.java3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jon.lynch on 6/27/17.
 */
@Controller
public class LeagueController {
    @Autowired
    private LeagueRepository leagueRepository;

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

}
