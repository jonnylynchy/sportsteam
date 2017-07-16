package com.java3.repository;

import com.java3.model.TeamGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jon.lynch on 7/15/17.
 */
@Repository("teamGameRepositoryMain")
public interface TeamGameRepository extends JpaRepository<TeamGame, Integer>{
    @Query("SELECT tg FROM TeamGame tg WHERE game_id = :gameId")
    List<TeamGame> findByGameId(@Param("gameId") int gameId);

    @Query("SELECT tg FROM TeamGame tg WHERE team_id = :teamId")
    List<TeamGame> findByTeamId(@Param("teamId") int teamId);
}
