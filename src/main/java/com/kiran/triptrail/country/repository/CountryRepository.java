package com.kiran.triptrail.country.repository;

import org.springframework.stereotype.Repository;

@Repository
public class CountryRepository {
    private final JpaCountryRepository repo;

    public CountryRepository(JpaCountryRepository repo) {
        this.repo = repo;
    }

}
