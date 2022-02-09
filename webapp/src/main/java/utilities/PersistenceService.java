package utilities;

import Models.flights;
import Models.tickets;

import java.sql.Array;
import java.util.ArrayList;

public class PersistenceService {
    private static tickets ticket;
    private static flights flight;

//    static {
//        ticket = new tickets(0,"first", "last");
//        flight = new flights(0, "Tulsa, OK", "Phoenix, AZ");
//    }

    public static ArrayList<String> toFlightList(flights f) {
    ArrayList<String> flightList = new ArrayList<>();
    flightList.add(flight.getDeparture_city());
    flightList.add(flight.getDestination_city());
    return flightList;
    }

    public static ArrayList<String> toFlightListTotal(flights f) {
        ArrayList<String> flightList = new ArrayList<>();
        flightList.add(String.valueOf(flight.getFlight_id()));
        flightList.add(flight.getDeparture_city());
        flightList.add(flight.getDestination_city());
        return flightList;
    }

    public static ArrayList<String> toTicketList(tickets t) {
        ArrayList<String> ticketList = new ArrayList<>();
        ticketList.add(ticket.getFirst_name());
        ticketList.add(ticket.getLast_name());
        return ticketList;
    }

    public static ArrayList<String> toTicketListTotal(tickets t) {
        ArrayList<String> ticketList = new ArrayList<>();
        ticketList.add(String.valueOf(ticket.getTicket_id()));
        ticketList.add(ticket.getFirst_name());
        ticketList.add(ticket.getLast_name());
        return ticketList;
    }

    public static flights getFlight() {
        return flight;
    }

    public static void setFlight(flights f) {
        flight = f;
    }

    public static tickets getTicket() {
        return ticket;
    }

    public static void setTicket(tickets t) {
        ticket = t;
    }
}
