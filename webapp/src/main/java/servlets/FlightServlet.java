package servlets;

import Models.flights;
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

public class FlightServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        flights payload = mapper.readValue(req.getInputStream(), flights.class);
        PersistenceService.setFlight(payload);

        try {
            ResultSet rs = Scriptor.read(payload, PersistenceService.toFlightList(payload));
            while (rs.next()) {
                flights flight = new flights();
                flight.setFlight_id(rs.getInt("flight_id"));
                flight.setDeparture_city(rs.getString("departure_city"));
                flight.setDestination_city(rs.getString("destination_city"));
                String JSON = mapper.writeValueAsString(flight);
                resp.getWriter().print(JSON + "\n");
                logMessage("Status: 203");
                logMessage("Flight Object Get Response: " + JSON);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        ObjectMapper mapper = new ObjectMapper();
        flights payload = mapper.readValue(req.getInputStream(), flights.class);
        PersistenceService.setFlight(payload);

        Scriptor.delete(payload, PersistenceService.toFlightListTotal(payload));

        resp.setStatus(203);
        resp.getWriter().print("Flight Deleted");

    }

    public static void logMessage(String msg) {
        FileLogger.getFileLogger().log(msg);
    }

    public static void logException(Exception e) {
        FileLogger.getFileLogger().log(e);
    }
}

