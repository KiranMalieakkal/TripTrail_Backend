package com.kiran.triptrail.trip.service;

import com.kiran.triptrail.country.model.Country;
import com.kiran.triptrail.country.repository.CountryRepository;
import com.kiran.triptrail.trip.model.User;
import com.kiran.triptrail.trip.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class TripService {

    private final CountryRepository countryRepository;
    private final UserRepository userRepository;

    public TripService(CountryRepository countryRepository, UserRepository userRepository) {
        this.countryRepository = countryRepository;
        this.userRepository = userRepository;
    }


    public User getUserByUserName(String userName) {
        return userRepository.getByUserName(userName);
    }

    public User createCart() {
        return userRepository.createUser();
    }

    public User addTripToUser(String userName, String countryName, String places, String startDate, long duration, long budget, String travelTips, String journalEntry) {
        User user = userRepository.getByUserName(userName);
        if (user == null) {
            throw new IllegalArgumentException();
        }
        Country country = countryRepository.getByCountryName(countryName);
        if (country == null) {
            throw new IllegalArgumentException();
        }
        user.addTrip(country,places,startDate,duration,budget,travelTips,journalEntry);
        return userRepository.saveUser(user);
    }
}

