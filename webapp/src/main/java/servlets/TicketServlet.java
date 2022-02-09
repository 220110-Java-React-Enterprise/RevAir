package servlets;

import Models.tickets;
import Utils.Scriptor;
import com.fasterxml.jackson.databind.ObjectMapper;
import utilities.FileLogger;
import utilities.PersistenceService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        tickets payload = mapper.readValue(req.getInputStream(), tickets.class);
        PersistenceService.setTicket(payload);

        try {
        ResultSet rs = Scriptor.read(payload, PersistenceService.toTicketList(payload));
            while (rs.next()) {
                tickets ticket = new tickets();
                ticket.setTicket_id(rs.getInt("ticket_id"));
                ticket.setFirst_name(rs.getString("first_name"));
                ticket.setLast_name(rs.getString("last_name"));
//                PersistenceService.toTicketListTotal(ticket);
                String JSON = mapper.writeValueAsString(ticket);
                resp.getWriter().print(JSON + "\n");
                logMessage("Status: 203");
                logMessage("Ticket Object Get Response: " + JSON);
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }

        resp.setStatus(203);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //send POST with body containing string, integer and bool
        ObjectMapper mapper = new ObjectMapper();
        tickets payload = mapper.readValue(req.getInputStream(), tickets.class);
        PersistenceService.setTicket(payload);

        Scriptor.create(payload, PersistenceService.toTicketList(payload));

        logMessage("Status: 203");
        logMessage("Ticket Object Post Response: " + payload);
        resp.setStatus(203);
        resp.getWriter().print("Ticket accepted");

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        tickets payload = mapper.readValue(req.getInputStream(), tickets.class);
        PersistenceService.setTicket(payload);

        Scriptor.delete(payload, PersistenceService.toTicketListTotal(payload));

        logMessage("Status: 203");
        logMessage("Ticket Object Deleted from GlobalStore");
        resp.setStatus(203);
        resp.getWriter().print("Ticket deleted");



    }

    public static void logMessage(String msg) {
        FileLogger.getFileLogger().log(msg);
    }

    public static void logException(Exception e) {
        FileLogger.getFileLogger().log(e);
    }

}
