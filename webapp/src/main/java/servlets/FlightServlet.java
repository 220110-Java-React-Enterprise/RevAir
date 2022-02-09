package servlets;

import Models.flights;
import Utils.Scriptor;
import com.fasterxml.jackson.databind.ObjectMapper;

import utilities.PersistenceService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FlightServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        flights flight = PersistenceService.getFlight();
        ObjectMapper mapper = new ObjectMapper();
        String JSON = mapper.writeValueAsString(flight);
        resp.getWriter().print(JSON);
        resp.setStatus(203);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        flights payload = mapper.readValue(req.getInputStream(), flights.class);
        PersistenceService.setFlight(payload);

        Scriptor.create(payload, PersistenceService.toFlightList(payload));


        resp.setStatus(203);
        resp.getWriter().print("Flight accepted");

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PersistenceService.setFlight(null);
        resp.setStatus(203);
        resp.getWriter().print("Flight Deleted");

    }
}

