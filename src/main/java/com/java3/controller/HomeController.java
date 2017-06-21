package com.java3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jon.lynch on 6/21/17.
 */
@RestController
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "Sports Team Website up and running!";
    }
}
