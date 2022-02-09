package Models;

// flight POJO
public class flights {
    private Integer flight_id;
    private String departure_city;
    private String destination_city;

    public flights() {
    }

    public flights(Integer flight_id, String departure_city, String destination_city) {
        this.flight_id = flight_id;
        this.departure_city = departure_city;
        this.destination_city = destination_city;
    }

    public flights(String departure_city, String destination_city) {
        this.departure_city = departure_city;
        this.destination_city = destination_city;
    }

    public Integer getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(Integer flight_id) {
        this.flight_id = flight_id;
    }

    public String getDeparture_city() {
        return departure_city;
    }

    public void setDeparture_city(String departure_city) {
        this.departure_city = departure_city;
    }

    public String getDestination_city() {
        return destination_city;
    }

    public void setDestination_city(String destination_city) {
        this.destination_city = destination_city;
    }

    @Override
    public String toString() {
        return "flights{" +
                "flight_id=" + flight_id +
                ", departure_city='" + departure_city + '\'' +
                ", destination_city='" + destination_city + '\'' +
                '}';
    }
}