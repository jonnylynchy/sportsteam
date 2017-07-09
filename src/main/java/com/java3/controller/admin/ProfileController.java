package com.java3.controller.admin;

import com.java3.model.User;
import com.java3.repository.UserRepository;

import com.java3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;

/**
 * Created by jon.lynch on 7/6/17.
 */

@Controller
@RequestMapping("admin/")
public class ProfileController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(value={"profile/"}, method = RequestMethod.GET)
    public ModelAndView profileEdit() {
        ModelAndView viewModel = new ModelAndView();
        // Get Current User for profile fields
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.findUserByEmail(auth.getName());
        String userPass = currentUser.getPassword();
        viewModel.addObject("userPass", userPass);
        viewModel.addObject("userObj", currentUser);
        viewModel.setViewName("admin/profile/user-profile");
        return viewModel;
    }

    @RequestMapping(value = "profile/", method = RequestMethod.POST)
    public ModelAndView registerUser(@Valid @ModelAttribute("userObj")User userObj, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.findUserByEmail(auth.getName());
        User userExists = userRepository.findByEmail(userObj.getEmail());
        String userPass = currentUser.getPassword();

        if (userExists != null && userObj.getId() != userExists.getId()) {
            bindingResult
                    .rejectValue("email", "error.email",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("userPass", userPass);
            modelAndView.addObject("userObj", userObj);
            modelAndView.setViewName("admin/profile/user-profile");
        } else {
            // If the encoded current user's password doesn't equate to one in field,
            // Update and encode the password with new one
            if(!userObj.getPassword().equals(userPass)) {
                userObj.setPassword(bCryptPasswordEncoder.encode(userObj.getPassword()));
            }
            userObj.setActive(1);
            userObj.setRoles(userExists.getRoles());
            userRepository.save(userObj);
            redirectAttrs.addFlashAttribute("successMessage", "Your profile has been saved.");
            return new ModelAndView("redirect:/admin/profile/");
        }
        return modelAndView;
    }

    @RequestMapping(value = {"/profile/"}, method = RequestMethod.POST, params="action=cancel")
    public ModelAndView cancel() {
        return new ModelAndView("redirect:/admin/profile/");
    }
}
