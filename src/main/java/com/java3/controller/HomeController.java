package com.java3.controller;

import com.java3.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value={"/", "/index"})
    public ModelAndView index() {
        ModelAndView viewModel = new ModelAndView();
        viewModel.setViewName("index");
        List<Team> teamList = teamRepository.findAll();
        viewModel.addObject("teams", teamList);
        return viewModel;
    }
}
