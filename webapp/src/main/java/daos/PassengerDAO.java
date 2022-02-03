package daos;

public class PassengerDAO {
    private Integer passengerId;
    private String firstName;
    private String lastName;
    private Integer flightId;

    public PassengerDAO() {

    }

    public PassengerDAO(String firstName, String lastName, Integer flightId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.flightId = flightId;
    }

    public PassengerDAO(Integer passengerId, String firstName, String lastName, Integer flightId) {
        this.passengerId = passengerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.flightId = flightId;
    }

    public Integer getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public String toJSON() {
        return "{\"passenger\": {\"passengerId\":" + passengerId + ", \"firstName\":\"" + firstName + "\", \"lastName\": \"" + lastName + "\", \"flightId\": " + flightId + "} }";
    }
}
