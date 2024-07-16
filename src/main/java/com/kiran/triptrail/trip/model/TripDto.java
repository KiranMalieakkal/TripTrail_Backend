package com.kiran.triptrail.trip.model;

import com.kiran.triptrail.country.model.Country;

public record TripDto(long countryId, String places , String countryName, String startDate, long duration , long budget , String journalEntry, String travelTips, String image ) {
    public static TripDto fromTrip(Trip trip) {
        Country country = trip.getCountry();
        return new TripDto(
                country.getCountryId(),
                trip.getPlaces(),
                country.getCountryName(),
                trip.getStartDate(),
                trip.getDuration(),
                trip.getBudget(),
                trip.getJournalEntry(),
                trip.getTravelTips(),
                country.getCountryFlagUrl()
                );
    }
}

