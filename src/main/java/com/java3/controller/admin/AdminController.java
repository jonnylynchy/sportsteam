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
public class AdminController {
    @RequestMapping(value={"index/"}, method = RequestMethod.GET)
    public ModelAndView adminIndex() {
        ModelAndView viewModel = new ModelAndView();
        viewModel.setViewName("admin/index");
        return viewModel;
    }
}
