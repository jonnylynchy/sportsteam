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
public class GameController {
    @RequestMapping(value={"games/"}, method = RequestMethod.GET)
    public ModelAndView gamesIndex() {
        ModelAndView viewModel = new ModelAndView();
        viewModel.setViewName("admin/games/games");
        return viewModel;
    }
}
