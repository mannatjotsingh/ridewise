# Object Relationships

# Association

## Ride → Rider
A Ride is associated with a Rider.

## Ride → Driver
A Ride is associated with a Driver.

---

# Composition

## Ride → FareReceipt
Ride owns FareReceipt.
FareReceipt exists only for a Ride.

---

# Strategy Relationships

## RideService → RideMatchingStrategy
RideService uses RideMatchingStrategy to select drivers.

## RideService → FareStrategy
RideService uses FareStrategy to calculate fares.

---
# Dependency Injection

Strategies are injected into RideService constructor.

Example:

```java
RideService rideService =
    new RideService(
        new NearestDriverStrategy(),
        new DefaultFareStrategy()
    );
