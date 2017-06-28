package com.java3.controller;

import com.java3.model.User;
import com.java3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by jon.lynch on 6/28/17.
 */
@ControllerAdvice("com.java3.controller")
public class CommonController {
    @Autowired
    private UserService userService;

    @ModelAttribute
    public void getUserName(Model viewModel){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        viewModel.addAttribute("user", user);
        if(user != null) {
            viewModel.addAttribute("authUserName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
        } else {
            viewModel.addAttribute("authUserName", "");
        }

    }

}
