package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import daos.PassengerDAO;
import utilities.GlobalStore;
import utilities.PersistenceService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PassengerServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            PassengerDAO data = PersistenceService.getPassenger();

            PassengerDAO passObj = GlobalStore.getPassObj();
            ObjectMapper mapper = new ObjectMapper();
            String JSON = mapper.writeValueAsString(passObj);
            resp.getWriter().print(JSON);
            resp.setStatus(200);


//        String s = data.getString();
//        Integer i = data.getInteger();
//        boolean b = data.isBool();
//
//        resp.setStatus(202);
//        resp.getWriter().print("Data: " + s + ", " + i.toString() + ", " + b);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //send POST with body containing string, integer and bool
            ObjectMapper mapper = new ObjectMapper();
            PassengerDAO payload = mapper.readValue(req.getInputStream(), PassengerDAO.class);
            GlobalStore.setPassObj(payload);

//        String s = req.getParameter("string");
//        Integer i = Integer.parseInt(req.getParameter("integer"));
//        boolean b = Boolean.parseBoolean(req.getParameter("bool"));
//
//        DataDAO data = new DataDAO(s, i, b);
//
//        PersistenceService.setData(data);

            resp.setStatus(203);
//        resp.setStatus(202);
//        resp.getWriter().print("Data accepted.");
        }

        @Override
        protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        }
}
