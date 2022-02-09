package Models;

// flight POJO
public class tickets {
    private Integer ticket_id;
    private String first_name;
    private String last_name;

    public tickets() {
    }

    public tickets(Integer ticket_id, String first_name, String last_name) {
        this.ticket_id = ticket_id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Integer getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(Integer ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "tickets{" +
                "ticket_id=" + ticket_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }
}