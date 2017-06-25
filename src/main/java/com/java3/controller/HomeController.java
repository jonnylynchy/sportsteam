package com.java3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java3.model.Team;
import com.java3.model.User;
import com.java3.service.UserService;

import java.util.List;

/**
 * Created by jon.lynch on 6/21/17.
 */
@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @RequestMapping(value={"/", "/index"})
    public ModelAndView index() {
        ModelAndView viewModel = new ModelAndView();
        viewModel.setViewName("index");
        List<Team> teamList = TeamsStub.list();
        viewModel.addObject("teams", teamList);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        viewModel.addObject("user", user);
        if(user != null) {
            viewModel.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        } else {
            viewModel.addObject("userName", "");
        }
        return viewModel;
    }
}
