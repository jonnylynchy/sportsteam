package com.java3.repository;

import com.java3.model.LeagueTypePosition;
import com.java3.model.Role;
import com.java3.model.Team;
import com.java3.model.User;

import java.util.Set;

/**
 * Created by jon.lynch on 7/27/17.
 *
 * Custom Interface to Map a "Player" class to User to limit exposure of user properties (implemented in PlayerRepository)
 */
public interface Player {
    String getId();
    String getFirstName();
    String getLastName();
    // Have nested exception with these (do we need?):
    // Set<Role> getRoles();
    // Set<Team> getTeams();
    // Set<LeagueTypePosition> getPositions();
    String getEmail();
}
