package utilities;

import daos.FlightDAO;
import daos.TicketDAO;

public class PersistenceService {
    private static TicketDAO passenger;
    private static FlightDAO flight;

    static {
        passenger = new TicketDAO(0,"first", "last"/*, 0*/);
        flight = new FlightDAO(0, "Tulsa, OK", "Phoenix, AZ");
    }

    public static FlightDAO getFlight() {
        return flight;
    }

    public static void setFlight(FlightDAO f) {
        flight = f;
    }

    public static TicketDAO getPassenger() {
        return passenger;
    }

    public static void setPassenger(TicketDAO p) {
        passenger = p;
    }
}
