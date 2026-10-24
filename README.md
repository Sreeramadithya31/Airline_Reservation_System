# Airline Reservation System ✈️

A Java console-based Airline Reservation System developed for the OOP Through Java laboratory. It demonstrates flight inventory management, passenger details, booking, cancellation, and reservation listing.

## Features
- Display available flights and seat counts
- Book a seat by selecting a flight
- Generate booking IDs
- Cancel an existing booking and release the seat
- Display all reservations
- Validate menu input and handle unavailable flights

## Tech Stack
- Java
- Object-oriented programming (`Flight`, `Passenger`, `ReservationSystem`)
- Java collections for in-memory data storage

## Folder Structure
```text
src/
  Flight.java
  Passenger.java
  ReservationSystem.java
```

## Run
Install JDK 17 or later, then run from this project directory:

```bash
javac -d out src/*.java
java -cp out ReservationSystem
```

## Notes
This is an educational console implementation. Records are kept in memory and reset when the application exits; database persistence and payment processing are not implemented.

## Academic Context
Project title and module scope are based on the supplied *Airline Reservation System* documentation. The code in this repository is a clean, runnable reference implementation of the documented features.
