package com.kiran.triptrail.trip.controller;

import com.kiran.triptrail.trip.model.AddTripDto;
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
    public ResponseEntity<UserDto> getUserByUserName(@PathVariable String userName) {
        User user = service.getUserByUserName(userName);
        return ResponseEntity.ok(UserDto.fromUser(user));
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser() {
        User user = service.createCart();
        UserDto dto = UserDto.fromUser(user);
        return ResponseEntity.created(URI.create(API_CONTEXT_ROOT + user.getUserName())).body(dto);
    }

    @PostMapping("/{userName}/trips")
    public ResponseEntity<UserDto> addTripToUser(@PathVariable String userName,
                                                     @RequestBody AddTripDto tripDto) {
        System.out.println("userName = " + userName);
        System.out.println("tripDto = " + tripDto);
                
        User user = service.addTripToUser(userName,
                tripDto.countryName(),
                tripDto.places(),
                tripDto.startDate(),
                tripDto.duration(),
                tripDto.budget(),
                tripDto.travelTips(),
                tripDto.journalEntry());
        UserDto dto = UserDto.fromUser(user);
        return ResponseEntity.accepted().body(dto);
    }

//
//    @DeleteMapping("/{cartId}")
//    public ResponseEntity<Void> deleteCart(@PathVariable String cartId) {
//        service.deleteCart(cartId);
//        return ResponseEntity.noContent().build();
//    }
}

