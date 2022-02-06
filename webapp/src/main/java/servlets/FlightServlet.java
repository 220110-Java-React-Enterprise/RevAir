package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import daos.FlightDAO;
import utilities.FileLogger;
import utilities.GlobalStore;
import utilities.PersistenceService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FlightServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FlightDAO data = PersistenceService.getFlight();

        FlightDAO flightObj = GlobalStore.getFlightObj();
        ObjectMapper mapper = new ObjectMapper();
        String JSON = mapper.writeValueAsString(flightObj);
        resp.getWriter().print(JSON);
        resp.setStatus(203);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        FlightDAO payload = mapper.readValue(req.getInputStream(), FlightDAO.class);
        GlobalStore.setFlightObj(payload);


        resp.setStatus(203);
        resp.getWriter().print("Flight accepted");

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GlobalStore.setFlightObj(null);
        resp.setStatus(203);
        resp.getWriter().print("Flight Deleted");

    }
}

