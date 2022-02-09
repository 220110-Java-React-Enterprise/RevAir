package utilities;

import Models.flights;
import Models.tickets;
import daos.FlightDAO;
import daos.TicketDAO;

public class GlobalStore {

    private static TicketDAO ticketObj;
    private static FlightDAO flightObj;

    public static flights setFlightInfo(FlightDAO flightObj) {
        flights currentFlight = new flights();
        GlobalStore.flightObj = flightObj;
        currentFlight.setDeparture_city(flightObj.getDepartureCity());
        currentFlight.setDestination_city(flightObj.getDestinationCity());
        return currentFlight;
    }

    public static tickets setTicketInfo(TicketDAO ticketObj) {
        tickets currentTicket = new tickets();
        GlobalStore.ticketObj = ticketObj;
        currentTicket.setFirst_name(ticketObj.getFirstName());
        currentTicket.setLast_name(ticketObj.getLastName());
        return currentTicket;
    }

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
