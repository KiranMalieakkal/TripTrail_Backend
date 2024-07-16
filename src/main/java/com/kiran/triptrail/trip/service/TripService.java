package com.kiran.triptrail.trip.service;

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
}
