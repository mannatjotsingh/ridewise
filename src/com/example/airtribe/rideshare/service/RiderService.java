package com.example.airtribe.rideshare.service;

import java.util.ArrayList;
import java.util.List;

import com.example.airtribe.rideshare.model.Rider;

public class RiderService {

    private List<Rider> riders;

    public RiderService() {
        riders = new ArrayList<>();
    }

    public void addRider(Rider rider) {
        riders.add(rider);
    }

    public Rider getRiderById(int riderId) {

        for (Rider rider : riders) {

            if (rider.getId() == riderId) {
                return rider;
            }
        }

        return null;
    }

    public List<Rider> getAllRiders() {
        return riders;
    }
}
