package exceptions;

import utilities.FileLogger;

import javax.servlet.ServletException;

public class WebappException extends ServletException {
    public WebappException(String message) {
        super(message);
    }


}
