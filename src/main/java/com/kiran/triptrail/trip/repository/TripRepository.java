package com.kiran.triptrail.trip.repository;

import org.springframework.stereotype.Repository;

@Repository
public class TripRepository {
    private final TripDbRepository repo;

    public TripRepository(TripDbRepository repo) {
        this.repo = repo;
    }

    public void deleteTrip(long tripId) {
        repo.deleteById(tripId);
    }
}
