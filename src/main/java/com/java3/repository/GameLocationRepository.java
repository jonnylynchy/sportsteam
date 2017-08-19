package com.java3.repository;

import com.java3.model.GameLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jon.lynch on 7/13/17.
 *
 * JPA Repository Interface for GameLocation
 */
@Repository("gameLocationRepositoryMain")
public interface GameLocationRepository extends JpaRepository<GameLocation, Integer> {

}
