import Utils.ConnectionManager;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/*
"User" Instructions:
(ask Kyle if these are okay)
Tables must be predefined in MariaDB.
First field for each object model MUST be an auto-generated unique id Integer.
Send an ArrayList to Scriptor methods containing user-entered JSON strings.
When reading - must enter the first_name or departure_city to read by (will return all entries matching that)
When deleting - must enter the id to delete (flight or ticket)
 */
public class Scriptor {
    private static final Connection connection = ConnectionManager.getConnection();
    
    public static void create(Object obj, ArrayList<String> parameters) {
        try {
            String sql = prepareCreateSqlString(obj, parameters);
            PreparedStatement pstmt = connection.prepareStatement(sql);
            for (int i = 1; i <= parameters.size(); i++) {
                // ask Kyle if this is okay
                pstmt.setString(i, parameters.get(i - 1));
            }
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
                e.printStackTrace();
        }
    }
    
    public static String prepareCreateSqlString(Object obj, ArrayList<String> userEntries) {
        String nextPart;
        String[] tempStrings;

        // "INSERT INTO [table name] ([column 1], [column 2], [column 3],...) VALUES (?,?,?,...)"

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
    
    public static ResultSet read(Object obj, ArrayList<String> parameters) {
        try {
            String sql = prepareReadSqlString(obj, parameters);
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, parameters.get(0));

            ResultSet rs = pstmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public static String prepareReadSqlString(Object obj, ArrayList<String> userEntries) {
        String nextPart;
        String[] tempStrings;
        
        // "SELECT * FROM [table name] WHERE [column 2] = ?"
        
        String sqlString = "SELECT * FROM ";

        nextPart = obj.getClass().getCanonicalName();
        tempStrings = nextPart.split("\\.");
        nextPart = tempStrings[tempStrings.length - 1];
        sqlString += nextPart;
        
        nextPart = " WHERE ";
        Field[] fields = obj.getClass().getDeclaredFields();
        tempStrings = String.valueOf(fields[1]).split("\\.");
        nextPart += tempStrings[tempStrings.length - 1] + " = ?";
        sqlString += nextPart;
        
        return sqlString;
    }
    
    public static void delete(Object obj, ArrayList<String> parameters) {
        try {
            String sql = prepareDeleteSqlString(obj, parameters);
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, parameters.get(0));
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static String prepareDeleteSqlString(Object obj, ArrayList<String> userEntries) {
        String nextPart;
        String[] tempStrings;
        
        // "DELETE FROM [table name] WHERE [column 2] = ?"
        
        String sqlString = "DELETE FROM ";

        nextPart = obj.getClass().getCanonicalName();
        tempStrings = nextPart.split("\\.");
        nextPart = tempStrings[tempStrings.length - 1];
        sqlString += nextPart;

        nextPart = " WHERE ";
        Field[] fields = obj.getClass().getDeclaredFields();
        tempStrings = String.valueOf(fields[0]).split("\\.");
        nextPart += tempStrings[tempStrings.length - 1] + " = ?";
        sqlString += nextPart;
        
        return sqlString;
    }
}
