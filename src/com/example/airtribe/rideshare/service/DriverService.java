package com.example.airtribe.rideshare.service;

import java.util.ArrayList;
import java.util.List;

import com.example.airtribe.rideshare.model.Driver;

public class DriverService {

    private List<Driver> drivers;

    public DriverService() {
        drivers = new ArrayList<>();
    }

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public List<Driver> getAvailableDrivers() {

        List<Driver> availableDrivers = new ArrayList<>();

        for (Driver driver : drivers) {

            if (driver.isAvailable()) {
                availableDrivers.add(driver);
            }
        }

        return availableDrivers;
    }

    public Driver getDriverById(int driverId) {

        for (Driver driver : drivers) {

            if (driver.getId() == driverId) {
                return driver;
            }
        }

        return null;
    }

    public List<Driver> getAllDrivers() {
        return drivers;
    }
}