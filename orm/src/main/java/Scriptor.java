import Utils.ConnectionManager;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/*
"User" Instructions:
Tables must be predefined in MariaDB.
First field for each object model MUST be an auto-generated unique id Integer.
Send an ArrayList to Scriptor methods containing user-entered JSON strings.
 */
public class Scriptor {
    private static final Connection connection = ConnectionManager.getConnection();
    
    public static void create(Object obj, ArrayList<String> parameters) {
        try {
            String sql = prepareSqlString(obj, parameters);
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
    
    public static String prepareSqlString(Object obj, ArrayList<String> userEntries) {
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
}
