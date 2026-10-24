public class Flight {
    private final String flightNumber;
    private final String destination;
    private final int totalSeats;
    private int availableSeats;

    public Flight(String flightNumber, String destination, int totalSeats) {
        if (totalSeats < 1) throw new IllegalArgumentException("Seats must be positive");
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public String getFlightNumber() { return flightNumber; }
    public String getDestination() { return destination; }
    public int getTotalSeats() { return totalSeats; }
    public int getAvailableSeats() { return availableSeats; }

    public boolean bookSeat() {
        if (availableSeats == 0) return false;
        availableSeats--;
        return true;
    }

    public void cancelBooking() {
        if (availableSeats < totalSeats) availableSeats++;
    }

    @Override
    public String toString() {
        return flightNumber + " | " + destination + " | seats: "
                + availableSeats + "/" + totalSeats;
    }
}
