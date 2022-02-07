package utilities;

//import orm.Scriptor;

import daos.FlightDAO;
import daos.TicketDAO;

public class GlobalStore {
    private static TicketDAO ticketObj;
    private static FlightDAO flightObj;

    public static TicketDAO getTicketObj() {
        return ticketObj;
    }

    public static void setTicketObj(TicketDAO passObj) {
        GlobalStore.ticketObj = passObj;
    }

    public static FlightDAO getFlightObj() {
        return flightObj;
    }

    public static void setFlightObj(FlightDAO flightObj) {
        GlobalStore.flightObj = flightObj;
    }

}
