package com.example.airtribe.rideshare.strategy;

import com.example.airtribe.rideshare.model.Ride;

public class PeakHourFareStrategy implements FareStrategy {

    private static final double RATE_PER_KM = 20.0;
    private static final double SURGE_MULTIPLIER = 1.5;

    @Override
    public double calculateFare(Ride ride) {

        return ride.getDistance()
                * RATE_PER_KM
                * SURGE_MULTIPLIER;
    }
}