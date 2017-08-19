package com.java3.repository;

import com.java3.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jon.lynch on 7/12/17.
 *
 * JPA Repository Interface for Game
 */
@Repository("gameRepositoryMain")
public interface GameRepository extends JpaRepository<Game, Integer> {

}
