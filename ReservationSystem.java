import java.util.*;

public class ReservationSystem {
    private final List<Flight> flights = new ArrayList<>();
    private final List<Passenger> bookings = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private int nextBookingId = 1001;

    public ReservationSystem() {
        flights.add(new Flight("AI101", "Hyderabad -> Delhi", 3));
        flights.add(new Flight("AI202", "Hyderabad -> Mumbai", 4));
        flights.add(new Flight("6E303", "Hyderabad -> Bengaluru", 2));
    }

    private void displayFlights() {
        System.out.println("\n--- Available Flights ---");
        flights.forEach(System.out::println);
    }

    private Flight findFlight(String flightNumber) {
        return flights.stream()
                .filter(f -> f.getFlightNumber().equalsIgnoreCase(flightNumber))
                .findFirst().orElse(null);
    }

    private void bookReservation() {
        System.out.print("Enter flight number: ");
        Flight flight = findFlight(scanner.nextLine().trim());
        if (flight == null) {
            System.out.println("Flight not found.");
            return;
        }
        System.out.print("Passenger name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }
        if (!flight.bookSeat()) {
            System.out.println("No seats available.");
            return;
        }
        Passenger passenger = new Passenger("B" + nextBookingId++, name, flight.getFlightNumber());
        bookings.add(passenger);
        System.out.println("Booking successful: " + passenger);
    }

    private void cancelReservation() {
        System.out.print("Enter booking ID: ");
        String id = scanner.nextLine().trim();
        for (int i = 0; i < bookings.size(); i++) {
            Passenger passenger = bookings.get(i);
            if (passenger.getBookingId().equalsIgnoreCase(id)) {
                Flight flight = findFlight(passenger.getFlightNumber());
                if (flight != null) flight.cancelBooking();
                bookings.remove(i);
                System.out.println("Booking cancelled: " + id);
                return;
            }
        }
        System.out.println("Booking ID not found.");
    }

    private void displayBookings() {
        System.out.println("\n--- Reservations ---");
        if (bookings.isEmpty()) {
            System.out.println("No reservations yet.");
            return;
        }
        bookings.forEach(System.out::println);
    }

    public void start() {
        while (true) {
            System.out.println("\n===== Airline Reservation System =====");
            System.out.println("1. Display Flights\n2. Book Flight\n3. Cancel Booking");
            System.out.println("4. Display Reservations\n5. Exit");
            System.out.print("Choice: ");
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1": displayFlights(); break;
                case "2": displayFlights(); bookReservation(); break;
                case "3": cancelReservation(); break;
                case "4": displayBookings(); break;
                case "5": System.out.println("Thank you!"); return;
                default: System.out.println("Enter a number from 1 to 5.");
            }
        }
    }

    public static void main(String[] args) {
        new ReservationSystem().start();
    }
}
