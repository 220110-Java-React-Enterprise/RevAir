package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import daos.TicketDAO;
import utilities.FileLogger;
import utilities.GlobalStore;
import utilities.PersistenceService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TicketServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TicketDAO ticket = PersistenceService.getPassenger();

        TicketDAO ticketObj = GlobalStore.getTicketObj();
        ObjectMapper mapper = new ObjectMapper();
        String JSON = mapper.writeValueAsString(ticketObj);
        resp.getWriter().print(JSON);
        logMessage("Status: 203");
        logMessage("Ticket Object Get Response: " + JSON);
        resp.setStatus(203);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //send POST with body containing string, integer and bool
        ObjectMapper mapper = new ObjectMapper();
        TicketDAO payload = mapper.readValue(req.getInputStream(), TicketDAO.class);
        GlobalStore.setTicketObj(payload);

        logMessage("Status: 203");
        logMessage("Ticket Object Post Response: " + payload);
        resp.setStatus(203);
        resp.getWriter().print("Ticket accepted");

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GlobalStore.setTicketObj(null);
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
