package com.java3.repository;

import com.java3.model.LeagueType;
import com.java3.model.LeagueTypePosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jon.lynch on 8/5/17.
 */
@Repository("leagueTypePositionRepositoryMain")
public interface LeagueTypePositionRepository extends JpaRepository<LeagueTypePosition, Integer> {
    List<LeagueTypePosition> findByLeagueType(LeagueType leagueType);
}
