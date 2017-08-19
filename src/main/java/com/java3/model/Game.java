package com.java3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

/**
 * Created by jon.lynch on 7/12/17.
 *
 * Entity Class for Game
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

    /**
     * team_game is a join table because a game has 2 teams and we need to know score for both
     */
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "team_game",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id"))
    @JsonManagedReference
    private Set<Team> teams;

    /**
     * List of users associated with game
     */
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_game", joinColumns = @JoinColumn(name = "game_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> users;

    /**
     * Default Constructor
     */
    public Game() { }

    /**
     * Constructor with parameters
     * @param gameLocation
     * @param teams
     * @param users
     * @param dateTime
     */
    public Game(GameLocation gameLocation, Set<Team> teams, Set<User> users, Date dateTime) {
        this.gameLocation = gameLocation;
        this.teams = teams;
        this.users = users;
        this.dateTime = dateTime;
    }

    // GETTERS AND SETTERS

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    /**
     * A Game has one location, a location has many games
     * @return
     */
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

    public Set<Team> getTeams() {
        return teams;
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
