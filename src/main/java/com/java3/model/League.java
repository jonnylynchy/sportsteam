package com.java3.model;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by jon.lynch on 6/27/17.
 */
@Entity
@Table(name = "league")
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "league_id")
    private int leagueId;

    private String label;
    private String description;

    @Column(name = "created_at")
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private LeagueType leagueType;

    public League() { }

    public League(String label, String description, LeagueType leagueType) {
        this.label = label;
        this.description = description;
        this.leagueType = leagueType;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @ManyToOne
    @JoinColumn(name = "type_id")
    public LeagueType getLeagueType() {
        return leagueType;
    }

    public void setLeagueType(LeagueType leagueType) {
        this.leagueType = leagueType;
    }

}
