# Requirements Coverage

## Functional Requirements

### Rider Management
- Register Riders
- View Riders

### Driver Management
- Register Drivers
- View Available Drivers

### Ride Management
- Request Ride
- Complete Ride
- View All Rides

### Ride Matching
Implemented using Strategy Pattern:
- NearestDriverStrategy
- LeastActiveDriverStrategy

### Fare Calculation
Implemented using Strategy Pattern:
- DefaultFareStrategy
- PeakHourFareStrategy

### Ride Status Tracking
Ride statuses supported:
- REQUESTED
- ASSIGNED
- COMPLETED
- CANCELLED

---

## Non-Functional Requirements

### Low Coupling
RideService depends on interfaces instead of implementations.

### Extensibility
New matching and pricing strategies can be added without modifying RideService.

### Maintainability
Code is separated into:
- model
- service
- strategy
- exception
- util
