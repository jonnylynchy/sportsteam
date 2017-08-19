package com.java3.repository;

import com.java3.model.Team;
import com.java3.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jon.lynch on 7/27/17.
 *
 * JPA Repository Interface for Player (User)
 */
@Repository("playerRepositoryMain")
public interface PlayerRepository extends JpaRepository<User, Integer> {

    // Uses Player interface but returns Users (limited exposure by Player)
    List<Player> findPlayersByTeams(Team team);
}
