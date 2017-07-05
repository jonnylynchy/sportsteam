package com.java3.controller.admin;

import com.java3.model.League;
import com.java3.model.Role;
import com.java3.model.Team;
import com.java3.model.User;
import com.java3.repository.LeagueRepository;
import com.java3.repository.RoleRepository;
import com.java3.repository.TeamRepository;
import com.java3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

/**
 * Created by jon.lynch on 7/2/17.
 */
@Controller
@RequestMapping("admin/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private LeagueRepository leagueRepository;

    @Autowired
    private TeamRepository teamRepository;

    @RequestMapping(value={"/users"}, method = RequestMethod.GET)
    public ModelAndView users() {
        ModelAndView viewModel = new ModelAndView();
        viewModel.setViewName("admin/users/users");

        List<User> userList = userRepository.findAll();
        viewModel.addObject("users", userList);

        return viewModel;
    }

    @RequestMapping(value="/users/add", method = RequestMethod.GET)
    public ModelAndView userNew() {
        ModelAndView viewModel = new ModelAndView();
        viewModel.setViewName("admin/users/user-new");

        User userObj = new User();
        userObj.setPassword("Temp123");
        viewModel.addObject("userObj", userObj);

        List<Role> rolesList = roleRepository.findAll();
        List<League> leagueList = leagueRepository.findAll();
        viewModel.addObject("rolesList", rolesList);
        viewModel.addObject("leagueList", leagueList);

        return viewModel;
    }

    @RequestMapping(value="/users/add", method = RequestMethod.POST)
    public ModelAndView saveNew(@Valid @ModelAttribute("userObj") User userObj, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        ModelAndView viewModel = new ModelAndView();
        if (bindingResult.hasErrors()) {
            List<Role> rolesList = roleRepository.findAll();
            List<League> leagueList = leagueRepository.findAll();
            viewModel.addObject("rolesList", rolesList);
            viewModel.addObject("leagueList", leagueList);

            viewModel.setViewName("admin/users/user-new");
        } else {
            userRepository.save(userObj);
            redirectAttrs.addFlashAttribute("successMessage", "User has been saved successfully");
            return new ModelAndView("redirect:/admin/users");
        }
        return viewModel;
    }

    @RequestMapping(value="/users/edit", method = RequestMethod.POST)
    public ModelAndView saveEdit(@Valid @ModelAttribute("userObj") User userObj, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
        ModelAndView viewModel = new ModelAndView();
        if (bindingResult.hasErrors()) {
            List<Role> rolesList = roleRepository.findAll();
            List<League> leagueList = leagueRepository.findAll();
            viewModel.addObject("rolesList", rolesList);
            viewModel.addObject("leagueList", leagueList);

            viewModel.setViewName("admin/users/user-edit");
        } else {
            userRepository.save(userObj);
            redirectAttrs.addFlashAttribute("successMessage", "User has been saved successfully");
            return new ModelAndView("redirect:/admin/users");
        }
        return viewModel;
    }

    @RequestMapping(value={"/users/edit/{id}"}, method = RequestMethod.GET)
    public ModelAndView userEdit(@PathVariable("id") int id) {
        ModelAndView viewModel = new ModelAndView();
        viewModel.setViewName("admin/users/user-edit");

        User userObj = userRepository.findOne(id);
        viewModel.addObject("userObj", userObj);

        List<Role> rolesList = roleRepository.findAll();
        List<League> leagueList = leagueRepository.findAll();

        // If this user is part of a league, populate the team list for that league
        Set<League> userLeagues = userObj.getLeagues();
        if(!userLeagues.isEmpty()) {
            League userLeague = (League)userLeagues.toArray()[0];
            List<Team> teamList = teamRepository.findTeamsByLeague(userLeague);
            viewModel.addObject("teamList", teamList);
        }

        viewModel.addObject("rolesList", rolesList);
        viewModel.addObject("leagueList", leagueList);

        return viewModel;
    }

    @RequestMapping(value = {"/users/edit", "/users/add"}, method = RequestMethod.POST, params="action=cancel")
    public ModelAndView cancel() {
        return new ModelAndView("redirect:/admin/users");
    }

}
