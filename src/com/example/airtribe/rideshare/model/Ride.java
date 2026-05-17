package com.example.airtribe.rideshare.model;

public class Ride {

    private int id;
    private Rider rider;
    private Driver driver;
    private double distance;
    private RideStatus status;
    private FareReceipt fareReceipt;

    public Ride(int id,
                Rider rider,
                Driver driver,
                double distance) {

        this.id = id;
        this.rider = rider;
        this.driver = driver;
        this.distance = distance;
        this.status = RideStatus.REQUESTED;
    }

    public int getId() {
        return id;
    }

    public Rider getRider() {
        return rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public double getDistance() {
        return distance;
    }

    public RideStatus getStatus() {
        return status;
    }

    public FareReceipt getFareReceipt() {
        return fareReceipt;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    public void setFareReceipt(FareReceipt fareReceipt) {
        this.fareReceipt = fareReceipt;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "id=" + id +
                ", rider=" + rider.getName() +
                ", driver=" + driver.getName() +
                ", distance=" + distance +
                ", status=" + status +
                ", fareReceipt=" + fareReceipt +
                '}';
    }
}