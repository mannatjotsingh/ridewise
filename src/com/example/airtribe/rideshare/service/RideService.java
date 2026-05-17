package com.example.airtribe.rideshare.service;


import java.util.ArrayList;
import java.util.List;

import com.example.airtribe.rideshare.exception.NoDriverAvailableException;
import com.example.airtribe.rideshare.model.Driver;
import com.example.airtribe.rideshare.model.FareReceipt;
import com.example.airtribe.rideshare.model.Ride;
import com.example.airtribe.rideshare.model.RideStatus;
import com.example.airtribe.rideshare.model.Rider;
import com.example.airtribe.rideshare.strategy.FareStrategy;
import com.example.airtribe.rideshare.strategy.RideMatchingStrategy;
import com.example.airtribe.rideshare.util.IdGenerator;

public class RideService {

    private List<Ride> rides;

    private RideMatchingStrategy rideMatchingStrategy;
    private FareStrategy fareStrategy;

    public RideService(RideMatchingStrategy rideMatchingStrategy,
                       FareStrategy fareStrategy) {

        this.rideMatchingStrategy = rideMatchingStrategy;
        this.fareStrategy = fareStrategy;

        rides = new ArrayList<>();
    }

    public Ride requestRide(Rider rider,
                            List<Driver> availableDrivers,
                            double distance) {

        Driver assignedDriver =
                rideMatchingStrategy.findDriver(
                        rider,
                        availableDrivers
                );

        if (assignedDriver == null) {
            throw new NoDriverAvailableException(
                    "No drivers available currently"
            );
        }

        assignedDriver.setAvailable(false);

        Ride ride = new Ride(
                IdGenerator.generateRideId(),
                rider,
                assignedDriver,
                distance
        );

        ride.setStatus(RideStatus.ASSIGNED);

        double fare =
                fareStrategy.calculateFare(ride);

        FareReceipt fareReceipt =
                new FareReceipt(
                        ride.getId(),
                        fare
                );

        ride.setFareReceipt(fareReceipt);

        rides.add(ride);

        return ride;
    }

    public void completeRide(int rideId) {

        Ride ride = getRideById(rideId);

        if (ride == null) {
            return;
        }

        ride.setStatus(RideStatus.COMPLETED);

        Driver driver = ride.getDriver();

        driver.setAvailable(true);

        driver.incrementCompletedRides();
    }

    public Ride getRideById(int rideId) {

        for (Ride ride : rides) {

            if (ride.getId() == rideId) {
                return ride;
            }
        }

        return null;
    }

    public List<Ride> getAllRides() {
        return rides;
    }
}