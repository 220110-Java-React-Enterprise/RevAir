package Models;

// tickets POJO
public class tickets {
    private Integer ticket_id;
    private Integer first_name;
    private Integer last_name;

    public tickets() {
    }

    public tickets(Integer ticket_id, Integer first_name, Integer last_name) {
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

    public Integer getFirst_name() {
        return first_name;
    }

    public void setFirst_name(Integer first_name) {
        this.first_name = first_name;
    }

    public Integer getLast_name() {
        return last_name;
    }

    public void setLast_name(Integer last_name) {
        this.last_name = last_name;
    }
}
