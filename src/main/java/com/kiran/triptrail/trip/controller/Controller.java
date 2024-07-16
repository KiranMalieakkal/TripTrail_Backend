package com.kiran.triptrail.trip.controller;

import com.kiran.triptrail.trip.model.Trip;
import com.kiran.triptrail.trip.model.User;
import com.kiran.triptrail.trip.model.UserDto;
import com.kiran.triptrail.trip.service.TripService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("${api.base-path}${api.controllers.users}")
public class Controller {
    @Value("${api.base-path}${api.controllers.users}/")
    public String API_CONTEXT_ROOT;

    private final TripService service;

    public Controller(TripService service) {
        this.service = service;
    }

    @GetMapping("/{userName}")
    public ResponseEntity<UserDto> getCartById(@PathVariable String userName) {
        User user = service.getUserByUserName(userName);
        return ResponseEntity.ok(UserDto.fromUser(user));
    }


}

