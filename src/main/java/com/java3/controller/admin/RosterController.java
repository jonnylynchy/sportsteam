package com.java3.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by jon.lynch on 7/9/17.
 */

@Controller
@RequestMapping("admin/")
public class RosterController {
    @RequestMapping(value={"roster/"}, method = RequestMethod.GET)
    public ModelAndView rosterIndex() {
        ModelAndView viewModel = new ModelAndView();
        viewModel.setViewName("admin/roster/roster");
        return viewModel;
    }
}
