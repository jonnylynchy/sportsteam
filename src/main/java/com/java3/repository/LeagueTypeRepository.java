package com.java3.repository;

import com.java3.model.LeagueType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jon.lynch on 6/28/17.
 *
 * JPA Repository Interface for LeagueType
 */
@Repository("leagueTypeRepositoryMain")
public interface LeagueTypeRepository extends JpaRepository<LeagueType, Integer> {

}
