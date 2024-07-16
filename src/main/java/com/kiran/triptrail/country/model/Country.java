package com.kiran.triptrail.country.model;


import com.kiran.triptrail.trip.model.Trip;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="countries")
public class Country {

    @Id
    @Column(name = "country_id")
    private String countryId;

    @Column(name = "country_name", nullable = false)
    private String name;


    @Column(name = "countryFlag_url", nullable = false)
    private String countryFlagUrl;

    @OneToMany(mappedBy ="country", cascade = CascadeType.REMOVE)
    private List<Trip> trips;

    public Country(String countryId, String name, String countryFlagUrl) {
        this.countryId = countryId;
        this.name = name;
        this.countryFlagUrl = countryFlagUrl;
    }


    public Country() {

    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryFlagUrl() {
        return countryFlagUrl;
    }

    public void setCountryFlagUrl(String countryFlagUrl) {
        this.countryFlagUrl = countryFlagUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

