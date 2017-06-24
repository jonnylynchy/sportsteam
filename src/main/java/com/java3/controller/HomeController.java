package com.java3.controller;

import com.java3.model.Team;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by jon.lynch on 6/21/17.
 */
@Controller
public class HomeController {
    @RequestMapping(value={"/", "/index"})
    public ModelAndView index() {
        ModelAndView viewModel = new ModelAndView();
        viewModel.setViewName("index");
        List<Team> list = TeamsStub.list();
        viewModel.addObject("teams", list);
        return viewModel;
    }
}
