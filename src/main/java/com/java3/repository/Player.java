package com.java3.repository;

import com.java3.model.Role;
import com.java3.model.Team;

import java.util.Set;

/**
 * Created by jon.lynch on 7/27/17.
 */
public interface Player {
    String getId();
    String getFirstName();
    String getLastName();
    // Have nested exception with these (do we need?):
    // Set<Role> getRoles();
    // Set<Team> getTeams();
    String getEmail();
}
