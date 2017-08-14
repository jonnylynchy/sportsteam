package com.java3.controller.rest;

import com.java3.model.LeagueType;
import com.java3.model.LeagueTypePosition;
import com.java3.model.User;
import com.java3.repository.LeagueRepository;
import com.java3.repository.LeagueTypePositionRepository;
import com.java3.repository.LeagueTypeRepository;
import com.java3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * Created by jon.lynch on 8/5/17.
 */
@RestController
@RequestMapping("/api/v1/")
public class RosterRestController {
    @Autowired
    private LeagueRepository leagueRepository;

    @Autowired
    private LeagueTypeRepository leagueTypeRepository;

    @Autowired
    private LeagueTypePositionRepository leagueTypePositionRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "positions/leagueType/{leagueTypeId}", method = RequestMethod.GET)
    public List<LeagueTypePosition> positionListByLeagueId(@PathVariable int leagueTypeId) {
        LeagueType leagueType = leagueTypeRepository.findOne(leagueTypeId);
        List<LeagueTypePosition> positionList = leagueTypePositionRepository.findByLeagueType(leagueType);
        return positionList;
    }

    @RequestMapping(value = "player/{id}/position", method = RequestMethod.GET)
    public Set<LeagueTypePosition> getPlayerPositions(@PathVariable int id) {
        User player = userRepository.findOne(id);
        Set<LeagueTypePosition> playerPositions = player.getPositions();
        return playerPositions;
    }
}
