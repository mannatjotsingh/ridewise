package com.example.airtribe.rideshare.model;

public class Driver {

    private int id;
    private String name;
    private int currentLocation;
    private boolean available;
    private VehicleType vehicleType;
    private int completedRides;

    public Driver(int id,
                  String name,
                  int currentLocation,
                  VehicleType vehicleType) {

        this.id = id;
        this.name = name;
        this.currentLocation = currentLocation;
        this.vehicleType = vehicleType;
        this.available = true;
        this.completedRides = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public boolean isAvailable() {
        return available;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public int getCompletedRides() {
        return completedRides;
    }

    public void setCurrentLocation(int currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void incrementCompletedRides() {
        completedRides++;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", currentLocation=" + currentLocation +
                ", available=" + available +
                ", vehicleType=" + vehicleType +
                ", completedRides=" + completedRides +
                '}';
    }
}