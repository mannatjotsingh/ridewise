# SOLID Reflection

## Single Responsibility Principle (SRP)

Each class has a single responsibility.

Examples:
- RiderService handles rider operations
- DriverService handles driver operations
- RideService handles ride operations

---

## Open Closed Principle (OCP)

New ride matching or pricing strategies can be added without modifying RideService.

Example:
- SurgeFareStrategy
- HighestRatedDriverStrategy

---

## Liskov Substitution Principle (LSP)

Any implementation of FareStrategy or RideMatchingStrategy can replace another implementation.

Example:
```java
FareStrategy strategy = new PeakHourFareStrategy();
## Interface Segregation Principle (ISP)

Small focused interfaces are used:

FareStrategy
RideMatchingStrategy

---
