package com.java3.controller.admin;

import com.java3.model.User;
import com.java3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value={"profile/"}, method = RequestMethod.GET)
    public ModelAndView profileEdit() {
        // No need to define a user object and add it to model
        // It's already in the context from security
        ModelAndView viewModel = new ModelAndView();
        viewModel.setViewName("admin/profile/user-profile");
        return viewModel;
    }

    @RequestMapping(value = "profile/", method = RequestMethod.POST)
    public ModelAndView registerUser(@Valid @ModelAttribute("User")User user, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        ModelAndView modelAndView = new ModelAndView();
        User userExists = userRepository.findByEmail(user.getEmail());
        if (userExists != null && user.getId() != userExists.getId()) {
            bindingResult
                    .rejectValue("email", "error.email",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("admin/profile/user-profile");
        } else {
            user.setRoles(userExists.getRoles());
            userRepository.save(user);
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
