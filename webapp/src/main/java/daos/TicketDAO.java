package daos;

public class TicketDAO {
    private Integer ticketId;
    private String firstName;
    private String lastName;
//    private Integer flightId;

    public TicketDAO() {

    }

    public TicketDAO(String firstName, String lastName/*, Integer flightId*/) {
        this.firstName = firstName;
        this.lastName = lastName;
//        this.flightId = flightId;
    }

    public TicketDAO(Integer ticketId, String firstName, String lastName/*, Integer flightId*/) {
        this.ticketId = ticketId;
        this.firstName = firstName;
        this.lastName = lastName;
//        this.flightId = flightId;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
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

//    public Integer getFlightId() {
//        return flightId;
//    }
//
//    public void setFlightId(Integer flightId) {
//        this.flightId = flightId;
//    }

    public String toJSON() {
        return "{\"ticket\": {\"ticketId\":" + ticketId + ", \"firstName\":\"" + firstName + "\", \"lastName\": \"" + lastName + "\""/*, \"flightId\": " + flightId*/ + "} }";
    }
}
