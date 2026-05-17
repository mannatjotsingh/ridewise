package com.example.airtribe.rideshare.strategy;

import java.util.List;

import com.example.airtribe.rideshare.model.Driver;
import com.example.airtribe.rideshare.model.Rider;

public class LeastActiveDriverStrategy implements RideMatchingStrategy{

	@Override
	public Driver findDriver(Rider rider, List<Driver> drivers) {
		Driver selectedDriver = null;
        int minimumCompletedRides = Integer.MAX_VALUE;

        for (Driver driver : drivers) {

            if (!driver.isAvailable()) {
                continue;
            }

            if (driver.getCompletedRides() < minimumCompletedRides) {

                minimumCompletedRides =
                        driver.getCompletedRides();

                selectedDriver = driver;
            }
        }

        return selectedDriver;
	}

}
