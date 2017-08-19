package com.java3.model;

import javax.persistence.*;

/**
 * Created by jon.lynch on 7/12/17.
 *
 * Entity class for GameLocation
 */
@Entity
@Table(name = "game_location")
public class GameLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn(name = "game_location_id")
    private int gameLocationId;

    @Column(name = "location_label")
    private String locationLabel;

    @Column(name = "location_description")
    private String locationDescription;

    @Column(name = "location_street_address_1")
    private String locationStreetAddress1;

    @Column(name = "location_street_address_2")
    private String locationStreetAddress2;

    @Column(name = "location_city")
    private String locationCity;

    @Column(name = "location_state_province")
    private String locationStateProvince;

    @Column(name = "location_country")
    private String locationCountry;

    @Column(name = "location_zip_postal")
    private String locationZipPostal;

    // GETTERS AND SETTERS

    public int getGameLocationId() {
        return gameLocationId;
    }

    public void setGameLocationId(int gameLocationId) {
        this.gameLocationId = gameLocationId;
    }

    public String getLocationLabel() {
        return locationLabel;
    }

    public void setLocationLabel(String locationLabel) {
        this.locationLabel = locationLabel;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public String getLocationStreetAddress1() {
        return locationStreetAddress1;
    }

    public void setLocationStreetAddress1(String locationStreetAddress1) {
        this.locationStreetAddress1 = locationStreetAddress1;
    }

    public String getLocationStreetAddress2() {
        return locationStreetAddress2;
    }

    public void setLocationStreetAddress2(String locationStreetAddress2) {
        this.locationStreetAddress2 = locationStreetAddress2;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public String getLocationStateProvince() {
        return locationStateProvince;
    }

    public void setLocationStateProvince(String locationStateProvince) {
        this.locationStateProvince = locationStateProvince;
    }

    public String getLocationCountry() {
        return locationCountry;
    }

    public void setLocationCountry(String locationCountry) {
        this.locationCountry = locationCountry;
    }

    public String getLocationZipPostal() {
        return locationZipPostal;
    }

    public void setLocationZipPostal(String locationZipPostal) {
        this.locationZipPostal = locationZipPostal;
    }
}