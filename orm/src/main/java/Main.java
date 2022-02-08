import Models.flights;
import Models.tickets;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // test case for adding a flight
//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add("New York");
//        arrayList.add("Los Angeles");
//        
//        flights flights = new flights();
//        
//        Scriptor.create(flights, arrayList);

        ArrayList<String> flight = new ArrayList<>();
        flight.add("New York");
        flight.add("Los Angeles");
        
        ArrayList<String> ticket = new ArrayList<>();
        ticket.add("Mary");
        ticket.add("Jane");
        
        ArrayList<String> flightList = new ArrayList<>();
        flightList.add("Minnesota");
        
        ArrayList<String> ticketList = new ArrayList<>();
        ticketList.add("Mary");
        
        ArrayList<String> flightids = new ArrayList<>();
        flightids.add("5");
        
        ArrayList<String> ticketids = new ArrayList<>();
        ticketids.add("2");
        
        flights flights = new flights();
        tickets tickets = new tickets();

        System.out.println(Scriptor.prepareCreateSqlString(flights, flight));
        System.out.println(Scriptor.prepareCreateSqlString(tickets, ticket));
        System.out.println(Scriptor.prepareReadSqlString(flights, flightList));
        System.out.println(Scriptor.prepareReadSqlString(tickets, ticketList));
        System.out.println(Scriptor.prepareDeleteSqlString(flights, flightids));
        System.out.println(Scriptor.prepareDeleteSqlString(tickets, ticketids));
    }
}
