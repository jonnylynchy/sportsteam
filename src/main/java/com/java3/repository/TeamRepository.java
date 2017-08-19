package com.java3.repository;

import com.java3.model.League;
import com.java3.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jon.lynch on 6/27/17.
 *
 * JPA Repository Interface for Team
 */

@Repository("teamRepositoryMain")
public interface TeamRepository extends JpaRepository<Team, Integer> {

    // Custom method to find team by it's name label
    Team findTeamByName(String name);

    // Custom method to find teams by their associated league
    List<Team> findTeamsByLeague(League league);
}
