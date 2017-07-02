package com.java3.repository;

import com.java3.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jon.lynch on 6/27/17.
 */

@Repository("teamRepositoryMain")
public interface TeamRepository extends JpaRepository<Team, Integer> {
    Team findTeamByName(String name);
}
