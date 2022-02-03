package utilities;

import daos.FlightDAO;
import daos.PassengerDAO;

public class GlobalStore {
    private static PassengerDAO passObj;
    private static FlightDAO flightObj;

    public static PassengerDAO getPassObj() {
        return passObj;
    }

    public static void setPassObj(PassengerDAO passObj) {
        GlobalStore.passObj = passObj;
    }

    public static FlightDAO getFlightObj() {
        return flightObj;
    }

    public static void setFlightObj(FlightDAO flightObj) {
        GlobalStore.flightObj = flightObj;
    }
}
