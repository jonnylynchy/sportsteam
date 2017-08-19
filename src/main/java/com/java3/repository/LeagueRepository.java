package com.java3.repository;

import com.java3.model.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jon.lynch on 6/27/17.
 *
 * JPA Repository Interface for League
 */

@Repository("leagueRepositoryMain")
public interface LeagueRepository extends JpaRepository<League, Integer> {

    // Custom method for finding a league by it's label
    League findLeagueByLabel(String label);
}
