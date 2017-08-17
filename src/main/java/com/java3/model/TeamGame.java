package com.java3.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
    @JsonBackReference
    private Game game;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
    @JsonBackReference
    public Team team;

    @Column(name = "score")
    public int score;

    public int getTeamId() { return team.getTeamId(); }

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
