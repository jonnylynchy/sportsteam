package com.java3.controller;

import com.java3.model.Role;
import com.java3.model.User;
import com.java3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Date;


/**
 * Created by jon.lynch on 6/28/17.
 *
 * This class contains common methods needed across the application
 */
@ControllerAdvice("com.java3.controller")
public class CommonController {

    // Necessary repositories

    @Autowired
    private UserService userService;

    /**
     * Attaches a view attribute/variable that displays the users name if they are logged in
     * By using the @ModelAttribute annotation, this attaches a method across all requests
     * @param viewModel
     */
    @ModelAttribute
    public void getUserName(Model viewModel){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        viewModel.addAttribute("user", user);
        if(user != null) {
            viewModel.addAttribute("authUserName", "Welcome " + user.getFirstName() + " " + user.getLastName() + " (" + getUserRoleName(user) + ")");
        } else {
            viewModel.addAttribute("authUserName", "");
        }
    }

    /**
     * Private method for the method above - Returns a users's role as a string
     * @param user
     * @return
     */
    private String getUserRoleName(User user) {
        Role userRole = (Role)user.getRoles().toArray()[0];
        return userRole.getRole().toLowerCase().replace("_", " ");
    }

}
