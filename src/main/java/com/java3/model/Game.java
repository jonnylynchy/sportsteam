package com.java3.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

/**
 * Created by jon.lynch on 7/12/17.
 */
@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "game_id")
    private int gameId;

    @ManyToOne
    @JoinColumn(name = "game_location_id")
    @NotNull(message = "*Please provide a game location")
    private GameLocation gameLocation;

    @Column(name = "date_time")
    private Date dateTime;

    @Column(name = "created_at")
    private Date createdAt;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "team_game", joinColumns = @JoinColumn(name = "game_id"), inverseJoinColumns = @JoinColumn(name = "team_id"))
    private Set<Team> teams;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_game", joinColumns = @JoinColumn(name = "game_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users;

    public Game() { }

    public Game(GameLocation gameLocation, Set<Team> teams, Set<User> users, Date dateTime) {
        this.gameLocation = gameLocation;
        this.teams = teams;
        this.users = users;
        this.dateTime = dateTime;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    @ManyToOne
    @JoinColumn(name = "game_location_id")
    public GameLocation getGameLocation() {
        return gameLocation;
    }

    public void setGameLocation(GameLocation gameLocation) {
        this.gameLocation = gameLocation;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
