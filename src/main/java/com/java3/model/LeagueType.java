package com.java3.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jon.lynch on 6/27/17.
 *
 * Entity Class For LeagueType
 */
@Entity
@Table(name = "league_type")
public class LeagueType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "type_id")
    private int typeId;

    @Column(name = "label")
    @NotEmpty(message = "Please provide a label")
    private String label;

    @Column(name = "created_at")
    private Date createdAt;

    // GETTERS AND SETTERS

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}
