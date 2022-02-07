import Models.Flights;
import Utils.Scriptor;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // test case for adding a flight
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("New York");
        arrayList.add("Los Angeles");

        Flights flights = new Flights();

        Scriptor.create(flights, arrayList);
    }
}