package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import daos.TicketDAO;
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

        resp.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //send POST with body containing string, integer and bool
        ObjectMapper mapper = new ObjectMapper();
        TicketDAO payload = mapper.readValue(req.getInputStream(), TicketDAO.class);
        GlobalStore.setTicketObj(payload);

        resp.setStatus(203);
        resp.getWriter().print("Ticket accepted.");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GlobalStore.setTicketObj(null);
        resp.setStatus(203);
        resp.getWriter().print("Ticket Deleted");
    }
}
