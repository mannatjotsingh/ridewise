package com.example.airtribe.rideshare.strategy;

import com.example.airtribe.rideshare.model.Ride;

public class DefaultFareStrategy implements FareStrategy {

    private static final double RATE_PER_KM = 15.0;

    @Override
    public double calculateFare(Ride ride) {

        return ride.getDistance() * RATE_PER_KM;
    }
}