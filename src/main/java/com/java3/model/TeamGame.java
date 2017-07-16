package com.java3.model;

import javax.persistence.*;

/**
 * Created by jon.lynch on 7/15/17.
 */
@Entity
@Table(name = "team_game")
public class TeamGame {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "team_game_id")
    private int teamGameId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
    private Team team;

    @Column(name = "score")
    private int score;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getTeamGameId() {
        return teamGameId;
    }

    public void setTeamGameId(int teamGameId) {
        this.teamGameId = teamGameId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
