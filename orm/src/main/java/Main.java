import Models.flights;
import Models.tickets;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

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

        ArrayList<String> flight1 = new ArrayList<>();
        flight1.add("New York");
        flight1.add("Los Angeles");

        ArrayList<String> flight2 = new ArrayList<>();
        flight2.add("New York");
        flight2.add("Stockholm");

        ArrayList<String> flight3 = new ArrayList<>();
        flight3.add("Texas");
        flight3.add("Florida");
        
        ArrayList<String> ticket1 = new ArrayList<>();
        ticket1.add("Mary");
        ticket1.add("Jane");

        ArrayList<String> ticket2 = new ArrayList<>();
        ticket2.add("Mary");
        ticket2.add("Jane");

        ArrayList<String> ticket3 = new ArrayList<>();
        ticket3.add("Bob");
        ticket3.add("Parker");
        
        ArrayList<String> flightList = new ArrayList<>();
        flightList.add("New York");
        
        ArrayList<String> ticketList = new ArrayList<>();
        ticketList.add("Mary");
        
        ArrayList<String> flightids = new ArrayList<>();
        flightids.add("1");
        
        ArrayList<String> ticketids = new ArrayList<>();
        ticketids.add("1");
        
        flights flights = new flights();
        tickets tickets = new tickets();

        System.out.println("Creating flights and tickets...");
        
        Scriptor.create(flights, flight1);
        Scriptor.create(flights, flight2);
        Scriptor.create(flights, flight3);
        
        Scriptor.create(tickets, ticket1);
        Scriptor.create(tickets, ticket2);
        Scriptor.create(tickets, ticket3);

        System.out.println("Press enter to continue...");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();

        System.out.println("Deleting flight with id 1 and ticket with id 1...");
        
        Scriptor.delete(flights, flightids);
        Scriptor.delete(tickets, ticketids);
    }
}