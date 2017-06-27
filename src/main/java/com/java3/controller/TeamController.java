package com.java3.controller;

import com.java3.model.Team;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jon.lynch on 6/21/17.
 *
 * TEMP STUB VALUES FOR NOW, WE WILL WIRE THIS UP TO MYSQL THROUGH JPA
 */
@RestController
@RequestMapping("/api/v1/")
public class TeamController {
    @RequestMapping(value = "teams", method =RequestMethod.GET )
    public List<Team> list() {
        return TeamsStub.list();
    }

    @RequestMapping(value = "teams/{id}", method = RequestMethod.GET)
    public Team get(@PathVariable Long id) {
        return TeamsStub.get(id);
    }
}
