package com.example.airtribe.rideshare.util;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {

    private static final AtomicInteger riderCounter = new AtomicInteger(0);
    private static final AtomicInteger driverCounter = new AtomicInteger(0);
    private static final AtomicInteger rideCounter = new AtomicInteger(0);

    private IdGenerator() {
    }

    public static int generateRiderId() {
        return riderCounter.incrementAndGet();
    }

    public static int generateDriverId() {
        return driverCounter.incrementAndGet();
    }

    public static int generateRideId() {
        return rideCounter.incrementAndGet();
    }
}