package com.java3.model;

/**
 * Created by jon.lynch on 6/21/17.
 */
public class Team {
    Long id;
    String name;
    String description;
    Integer yearFormed;

    public Team() { }

    public Team(Long id, String name, String description, Integer yearFormed) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.yearFormed = yearFormed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
