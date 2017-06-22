package com.java3.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java3.model.Team;
/**
 * Created by jon.lynch on 6/21/17.
 */
public class TeamsStub {
    private static Map<Long, Team> teams = new HashMap<Long, Team>();
    private static Long idIndex = 3L;

    //populate initial teams
    static {
        Team a = new Team(1L, "The Dominators", "The most dominating team you've ever seen!", 1994);
        teams.put(1L, a);
        Team b = new Team(2L, "Team FTW", "Never failing, always winning!", 2010);
        teams.put(2L, b);
        Team c = new Team(3L, "Texas Twisters", "We're mostly made up of retired storm chasers.", 2007);
        teams.put(3L, c);
    }

    public static List<Team> list() {
        return new ArrayList<Team>(teams.values());
    }

    public static Team create(Team team) {
        idIndex += idIndex;
        team.setId(idIndex);
        teams.put(idIndex, team);
        return team;
    }

    public static Team get(Long id) {
        return teams.get(id);
    }

    public static Team update(Long id, Team team) {
        teams.put(id, team);
        return team;
    }

    public static Team delete(Long id) {
        return teams.remove(id);
    }
}
