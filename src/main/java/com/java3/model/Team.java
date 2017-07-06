package com.java3.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by jon.lynch on 6/21/17.
 */
@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "team_id")
    private int teamId;

    @Column(name = "team_name")
    @NotEmpty(message = "*Please provide a name")
    private String name;

    @Column(name = "team_description")
    @NotEmpty(message = "*Please provide a description")
    private String description;

    @Column(name = "year_formed")
    @NotNull(message = "*Please provide a year formed")
    private Integer yearFormed;

    @ManyToOne
    @JoinColumn(name = "league_id")
    @NotNull(message = "*Please provide a league")
    private League league;

    public Team() { }

    public Team(int teamId, String name, String description, Integer yearFormed, League league) {
        this.teamId = teamId;
        this.name = name;
        this.description = description;
        this.yearFormed = yearFormed;
        this.league = league;
    }

    public int getId() {
        return teamId;
    }

    public void setId(int teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getYearFormed() {
        return yearFormed;
    }

    public void setYearFormed(Integer yearFormed) {
        this.yearFormed = yearFormed;
    }

    @ManyToOne
    @JoinColumn(name = "league_id")
    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }
}
