package Utils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class Scriptor {

    public static void create(Object obj, ArrayList<String> parameters) {
        try {
            String sql = prepareSqlString(obj, parameters);
            System.out.println("Scriptor");
            PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
            for (int i = 1; i <= parameters.size(); i++) {
                // ask Kyle if this is okay
                pstmt.setString(i, parameters.get(i - 1));
            }

            pstmt.executeUpdate();
        } catch (SQLException |IOException e) {
            e.printStackTrace();
            logException(e);
        }
    }

    public static String prepareSqlString(Object obj, ArrayList<String> userEntries) {
        String nextPart;
        String[] tempStrings;

        // "INSERT INTO [table name] ([column 1], [column 2], [column 3],...) VALUES (?,?,?,...)"

        System.out.println("Prepare SQL String");
        String sqlString = "INSERT INTO ";

        nextPart = obj.getClass().getCanonicalName();
        tempStrings = nextPart.split("\\.");
        nextPart = tempStrings[tempStrings.length - 1];
        sqlString += nextPart;

        Field[] fields = obj.getClass().getDeclaredFields();
        nextPart = " (";
        for (int i = 1; i < fields.length; i++) {
            tempStrings = String.valueOf(fields[i]).split("\\.");
            if (i == fields.length - 1) {
                nextPart += tempStrings[tempStrings.length - 1] + ")";
            }
            else {
                nextPart += tempStrings[tempStrings.length - 1] + ", ";
            }
        }
        sqlString += nextPart;

        nextPart = " VALUES (";
        for (int i = 0; i < userEntries.size(); i++) {
            if (i == userEntries.size() - 1) {
                nextPart += "?)";
            }
            else {
                nextPart += "?,";
            }
        }
        sqlString += nextPart;

        return sqlString;
    }

    public static void logMessage(String msg) {
        FileLogger.getFileLogger().log(msg);
    }

    public static void logException(Exception e) {
        FileLogger.getFileLogger().log(e);
    }
}
