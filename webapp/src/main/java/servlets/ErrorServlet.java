package servlets;

import exceptions.WebappException;
import utilities.FileLogger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ErrorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(404);
        System.out.println("Error 501 generated");
        logMessage("Error 501 generated");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Trowing custom ServletException");
        logMessage("Trowing custom ServletException");
        throw new WebappException("Webapp Exception");
    }

    public static void logMessage(String msg) {
        FileLogger.getFileLogger().log(msg);
    }

    public static void logException(Exception e) {
        FileLogger.getFileLogger().log(e);
    }
}
