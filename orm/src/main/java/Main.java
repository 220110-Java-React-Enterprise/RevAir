import Models.flights;
import Models.tickets;
import Utils.FileLogger;
import Utils.Scriptor;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // test case for adding a flight
//        ArrayList<String> flightList = new ArrayList<>();
//        flightList.add("New York");
//        flightList.add("Los Angeles");
//
//        ArrayList<String> ticketList = new ArrayList<>();
//        ticketList.add("John");
//        ticketList.add("Doe");

        Scriptor.create(flights, flightList);
        Scriptor.create(tickets, ticketList);
    }

    public static void logMessage(String msg) {
        FileLogger.getFileLogger().log(msg);
    }

    public static void logException(Exception e) {
        FileLogger.getFileLogger().log(e);
    }
}