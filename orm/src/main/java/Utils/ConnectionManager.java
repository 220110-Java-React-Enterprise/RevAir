package Utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {

    private static Connection connection;

    private ConnectionManager() {

    }


    public static Connection getConnection() throws SQLException, IOException, ClassNotFoundException {
        if(connection == null) {
            connection = connect();
        }
        return connection;
    }

    private static Connection connect() throws IOException, SQLException, ClassNotFoundException {
        //build connection
        Properties props = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream input = loader.getResourceAsStream("jdbc.properties");
        props.load(input);

        Class.forName("org.mariadb.jdbc.Driver");

        String connectionString = "jdbc:mariadb://" + props.getProperty("hostname") + ":" +
                props.getProperty("port") + "/" +
                props.getProperty("dbname") + "?user=" +
                props.getProperty("username") + "&password=" +
                props.getProperty("password");

        connection = DriverManager.getConnection(connectionString);
        return connection;
    }
}

