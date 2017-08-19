package com.java3.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by jon.lynch on 8/5/17.
 *
 * Entity Class For LeagueTypePosition
 */

@Entity
@Table(name = "league_type_position")
public class LeagueTypePosition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "position_id")
    private int positionId;

    @ManyToOne
    @JoinColumn(name = "league_type_id")
    @NotNull(message = "*Please provide a league type")
    private LeagueType leagueType;

    @Column(name = "label")
    @NotEmpty(message = "Please provide a label")
    private String label;

    @Column(name = "created_at")
    private Date createdAt;

    // GETTERS

    // These positions are pre-populated and do not need setters
    public int getPositionId() {
        return positionId;
    }

    public LeagueType getLeagueType() {
        return leagueType;
    }

    public String getLabel() {
        return label;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
