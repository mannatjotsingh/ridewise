package com.example.airtribe.rideshare.strategy;

import com.example.airtribe.rideshare.model.Ride;

public interface FareStrategy {

	double calculateFare(Ride ride);
}
