package utilities;

import daos.FlightDAO;
import daos.PassengerDAO;

public class PersistenceService {
    private static PassengerDAO passenger;
    private static FlightDAO flight;

    static {
        passenger = new PassengerDAO(0,"first", "last", 0);
        flight = new FlightDAO(0, "Tulsa, OK", "Phoenix, AZ");
    }

    public static FlightDAO getFlight() {
        return flight;
    }

    public static void setFlight(FlightDAO f) {
        flight = f;
    }

    public static PassengerDAO getPassenger() {
        return passenger;
    }

    public static void setPassenger(PassengerDAO p) {
        passenger = p;
    }
}
