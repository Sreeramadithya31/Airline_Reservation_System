public class Passenger {
    private final String bookingId;
    private final String name;
    private final String flightNumber;

    public Passenger(String bookingId, String name, String flightNumber) {
        this.bookingId = bookingId;
        this.name = name;
        this.flightNumber = flightNumber;
    }

    public String getBookingId() { return bookingId; }
    public String getName() { return name; }
    public String getFlightNumber() { return flightNumber; }

    @Override
    public String toString() {
        return "Booking " + bookingId + " | " + name + " | Flight " + flightNumber;
    }
}
