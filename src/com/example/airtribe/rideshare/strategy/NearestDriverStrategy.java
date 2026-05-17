package com.example.airtribe.rideshare.strategy;

import java.util.List;

import com.example.airtribe.rideshare.model.Driver;
import com.example.airtribe.rideshare.model.Rider;

public class NearestDriverStrategy implements RideMatchingStrategy{

	@Override
	public Driver findDriver(Rider rider, List<Driver> drivers) {
		Driver nearestDriver = null;
        int minimumDistance = Integer.MAX_VALUE;

        for (Driver driver : drivers) {

            if (!driver.isAvailable()) {
                continue;
            }

            int distance = Math.abs(
                    rider.getLocation() - driver.getCurrentLocation()
            );

            if (distance < minimumDistance) {
                minimumDistance = distance;
                nearestDriver = driver;
            }
        }

        return nearestDriver;
	}

}
