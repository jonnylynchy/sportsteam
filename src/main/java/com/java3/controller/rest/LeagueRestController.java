package com.java3.controller.rest;

import com.java3.model.League;
import com.java3.model.Team;
import com.java3.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jon.lynch on 7/4/17.
 */
@RestController
@RequestMapping("/api/v1/")
public class LeagueRestController {
    @Autowired
    private LeagueRepository leagueRepository;

    @RequestMapping(value = "leagues", method = RequestMethod.GET )
    public List<League> list() {
        return leagueRepository.findAll();
    }

    @RequestMapping(value = "leagues/{id}", method = RequestMethod.GET)
    public League get(@PathVariable int id) {
        return leagueRepository.findOne(id);
    }
}