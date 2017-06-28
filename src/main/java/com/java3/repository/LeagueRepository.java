package com.java3.repository;

import com.java3.model.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jon.lynch on 6/27/17.
 */

@Repository("leagueRepositoryMain")
public interface LeagueRepository extends JpaRepository<League, Integer> {
    League findLeagueByLabel(String label);
}
