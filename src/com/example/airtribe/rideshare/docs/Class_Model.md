# Class Model

## Core Entities

### Rider
- id
- name
- location

### Driver
- id
- name
- currentLocation
- available
- vehicleType
- completedRides

### Ride
- id
- rider
- driver
- distance
- status
- fareReceipt

### FareReceipt
- rideId
- amount
- generatedAt

---

# Enums

## RideStatus
- REQUESTED
- ASSIGNED
- COMPLETED
- CANCELLED

## VehicleType
- BIKE
- AUTO
- CAR

---

# Services

## RiderService
Handles rider operations.

## DriverService
Handles driver operations.

## RideService
Handles ride booking, ride completion, fare calculation, and driver assignment.

---

# Strategies

## RideMatchingStrategy
Implemented by:
- NearestDriverStrategy
- LeastActiveDriverStrategy

## FareStrategy
Implemented by:
- DefaultFareStrategy
- PeakHourFareStrategy
