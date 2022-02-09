import Models.tickets;
import Utils.Scriptor;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        tickets ticket = new tickets();
        ArrayList<String> ticketList = new ArrayList<>();
        ticketList.add("Chris");
        ticketList.add("Hemsworth");

        Scriptor.create(ticket, ticketList);
    }
}
