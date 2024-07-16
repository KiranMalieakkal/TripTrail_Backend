package com.kiran.triptrail.trip.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="owner")
public class User {

    @Id
    @Column(name = "userName")
    private String userName;

    private Long id;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private List<Trip> trips;

    public User() {
        this.trips = new ArrayList<>();
    }

    public User(String userName, Long id, List<Trip> trips) {
        this.userName = userName;
        this.id = id;
        this.trips = trips;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }
}
