package EmployeeMangement.EmployeeDAO;
import java.sql.Connection;
import java.sql.DriverManager;//manages jdbc drivers(sql,oracle,mysql)
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import EmployeeMangement.model.Employee;
public class EmployeeDAO {
	
	private static String jdbcURL = "jdbc:mysql://localhost:3306/employeedb?useSSL=false";
    // employeedb is a database not table.
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "root";
    
    Connection  con=null;
    
    public EmployeeDAO() throws ClassNotFoundException {
    	con=EmployeeDAO.getConnection();
    }

    public static Connection getConnection() throws ClassNotFoundException {
        Connection connection = null;
        try {
        	
             Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            //
            e.printStackTrace();
        }
        return connection;// Connection obj connection is returned

    }
    
    public void InsertEmployee(Employee employee) throws SQLException {

        String INSERT_USERS_SQL = "INSERT INTO users" +
                "  (id, name, email, country, password) VALUES " +
                " (?, ?, ?, ?, ?);";
        try {
            
            PreparedStatement pst = con.prepareStatement(INSERT_USERS_SQL);
            pst.setInt(1, employee.id);
            pst.setString(2, employee.name);
            pst.setString(3, employee.email);
            pst.setString(4, employee.country);
            pst.setString(5, employee.password);
            int i = pst.executeUpdate();
           
        } catch (Exception ex) {

        }
    }
    public void UpdateEmployee(Employee employee) {
        String UPDATE_USERS_SQL = "update users set name = ? where id = ?;";
        try {
      
            PreparedStatement pst = con.prepareStatement(UPDATE_USERS_SQL);
            pst.setString(1, employee.name);
            pst.setInt(2, employee.id);
            int i = pst.executeUpdate();
        } catch (Exception ex) {

        }
    }
    public void DeleteEmployee(int employeeId) {
        String DELETE_USERS_SQL = "delete from users where id = ?;";
        try {
            PreparedStatement pst = con.prepareStatement(DELETE_USERS_SQL);

            pst.setInt(1, employeeId);

            int i = pst.executeUpdate();
          
        } catch (Exception ex) {

        }
    }

    public Employee SelectEmployeeByid(int employeeID) {
        String QUERY = "select id,name,email,country,password from users where id =?";
        Employee employee=null;
        try {            
            PreparedStatement pst = con
            		.prepareStatement(QUERY);
            pst.setInt(1, employeeID);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                String password = rs.getString("password");
            }
        } catch (Exception ex) {

        }
        return employee;// ArrayList class obj

    }
    public ArrayList<Employee> GetEmployees() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM Users";
        PreparedStatement ps=con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery(sql);
        ArrayList<Employee> EmployeeList = new ArrayList<>();
        while (rs.next()) {
            Employee empobj = new Employee();
            empobj.id = rs.getInt("id");
            empobj.name = rs.getString("name");
            empobj.email = rs.getString("email");
            empobj.country = rs.getString("country");
            empobj.password = rs.getString("password");
            EmployeeList.add(empobj);
        }
        return EmployeeList;// ArrayList class obj
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