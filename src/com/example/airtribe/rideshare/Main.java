package com.example.airtribe.rideshare;


import java.util.List;
import java.util.Scanner;

import com.example.airtribe.rideshare.exception.NoDriverAvailableException;
import com.example.airtribe.rideshare.model.Driver;
import com.example.airtribe.rideshare.model.Ride;
import com.example.airtribe.rideshare.model.Rider;
import com.example.airtribe.rideshare.model.VehicleType;
import com.example.airtribe.rideshare.service.DriverService;
import com.example.airtribe.rideshare.service.RideService;
import com.example.airtribe.rideshare.service.RiderService;
import com.example.airtribe.rideshare.strategy.DefaultFareStrategy;
import com.example.airtribe.rideshare.strategy.NearestDriverStrategy;
import com.example.airtribe.rideshare.util.IdGenerator;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        RiderService riderService = new RiderService();

        DriverService driverService = new DriverService();

        RideService rideService =
                new RideService(
                        new NearestDriverStrategy(),
                        new DefaultFareStrategy()
                );

        while (true) {

            System.out.println("------------------ RIDEWISE MENU------------------");

            System.out.println("1. Add Rider");
            System.out.println("2. Add Driver");
            System.out.println("3. View Available Drivers");
            System.out.println("4. Request Ride");
            System.out.println("5. Complete Ride");
            System.out.println("6. View All Rides");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");

            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input");
                continue;
            }

            switch (choice) {

                case 1:

                    System.out.print("Enter rider name: ");
                    String riderName = scanner.nextLine();

                    System.out.print("Enter rider location: ");
                    int riderLocation =
                            Integer.parseInt(scanner.nextLine());

                    Rider rider = new Rider(
                            IdGenerator.generateRiderId(),
                            riderName,
                            riderLocation
                    );

                    riderService.addRider(rider);

                    System.out.println("Rider added successfully");
                    break;

                case 2:

                    System.out.print("Enter driver name: ");
                    String driverName = scanner.nextLine();

                    System.out.print("Enter driver location: ");
                    int driverLocation =
                            Integer.parseInt(scanner.nextLine());

                    System.out.println("Select vehicle type:");
                    System.out.println("1. BIKE");
                    System.out.println("2. AUTO");
                    System.out.println("3. CAR");

                    int vehicleChoice =
                            Integer.parseInt(scanner.nextLine());

                    VehicleType vehicleType;

                    switch (vehicleChoice) {

                        case 1:
                            vehicleType = VehicleType.BIKE;
                            break;

                        case 2:
                            vehicleType = VehicleType.AUTO;
                            break;

                        case 3:
                            vehicleType = VehicleType.CAR;
                            break;

                        default:
                            System.out.println("Invalid vehicle type");
                            continue;
                    }

                    Driver driver = new Driver(
                            IdGenerator.generateDriverId(),
                            driverName,
                            driverLocation,
                            vehicleType
                    );

                    driverService.addDriver(driver);

                    System.out.println("Driver added successfully");
                    break;

                case 3:

                    List<Driver> availableDrivers =
                            driverService.getAvailableDrivers();

                    if (availableDrivers.isEmpty()) {

                        System.out.println(
                                "No drivers available"
                        );

                    } else {

                        for (Driver d : availableDrivers) {
                            System.out.println(d);
                        }
                    }

                    break;

                case 4:

                    System.out.print("Enter rider ID: ");

                    int riderId =
                            Integer.parseInt(scanner.nextLine());

                    Rider existingRider =
                            riderService.getRiderById(riderId);

                    if (existingRider == null) {

                        System.out.println("Rider not found");
                        break;
                    }

                    System.out.print("Enter ride distance: ");

                    double distance =
                            Double.parseDouble(scanner.nextLine());

                    try {

                        Ride ride =
                                rideService.requestRide(
                                        existingRider,
                                        driverService.getAvailableDrivers(),
                                        distance
                                );

                        System.out.println(
                                "Ride booked successfully"
                        );

                        System.out.println(ride);

                    } catch (NoDriverAvailableException e) {

                        System.out.println(e.getMessage());
                    }

                    break;

                case 5:

                    System.out.print("Enter ride ID: ");

                    int rideId =
                            Integer.parseInt(scanner.nextLine());

                    Ride existingRide =
                            rideService.getRideById(rideId);

                    if (existingRide == null) {

                        System.out.println("Ride not found");
                        break;
                    }

                    rideService.completeRide(rideId);

                    System.out.println(
                            "Ride completed successfully"
                    );

                    break;

                case 6:

                    List<Ride> rides =
                            rideService.getAllRides();

                    if (rides.isEmpty()) {

                        System.out.println("No rides found");

                    } else {

                        for (Ride r : rides) {
                            System.out.println(r);
                        }
                    }

                    break;

                case 7:

                    System.out.println("Exiting application");
                    scanner.close();
                    return;

                default:

                    System.out.println("Invalid option");
            }
        }
    }
}