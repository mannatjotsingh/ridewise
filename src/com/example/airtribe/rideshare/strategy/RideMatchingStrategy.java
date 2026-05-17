package com.example.airtribe.rideshare.strategy;

import java.util.List;

import com.example.airtribe.rideshare.model.Driver;
import com.example.airtribe.rideshare.model.Rider;

public interface RideMatchingStrategy {

    Driver findDriver(Rider rider, List<Driver> drivers);
}