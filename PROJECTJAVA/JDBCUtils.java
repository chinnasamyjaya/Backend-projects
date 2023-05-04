//full stack codings for login page?

import java.sql.Connection; //connect specific database - session wil be created
import java.sql.DriverManager; //manage jdbc drivers(sql,mysql,oracle)
import java.sql.SQLException;

public class JDBCUtils {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/Employeedb?useSSL=false";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "root";

    public static Connection getConnection() throws ClassNotFoundException {
        Connection connection = null;
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}