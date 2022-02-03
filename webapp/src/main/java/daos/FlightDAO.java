package daos;

public class FlightDAO {
    private Integer flightId;
    private String departureCity;
    private String destinationCity;

    public FlightDAO() {

    }

    public FlightDAO(String departureCity, String destinationCity) {
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
    }

    public FlightDAO(Integer flightId, String departureCity, String destinationCity) {
        this.flightId = flightId;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String toJSON() {
        return "{\"flight\": {\"flightId\":" + flightId + ", \"departureCity\":\"" + departureCity + "\", \"destinationCity\": \"" + destinationCity + "\"} }";
    }
}
