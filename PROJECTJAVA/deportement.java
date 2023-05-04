import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class deportement {
    private static final String createchinnaSQL = "create table users (\r\n" + "  id  int(3) primary key,\r\n" +
            "  name varchar(20),\r\n" + "  description(20),\r\n" + " );";

        public void InsertDeportement() throws SQLException {
     
            String INSERT_USERS_SQL = "INSERT INTO users" +
                        "  (id, name, description,) VALUES " +
                        " ( ?, ?, ?);";
                try {
                    Connection connection = JDBCUtils.getConnection();
                    Scanner sc = new Scanner(System.in);
                    System.out.println(" Enter user Id: ");
                    String userid = sc.next();
                    System.out.println("Enter FULL NAME");
                    String name = sc.next();
                    System.out.println("Enter description:");
                    String description = sc.next();
                    PreparedStatement pst = connection
                            .prepareStatement(INSERT_USERS_SQL);
        
                    pst.setString(1, userid);
                    pst.setString(2, name);
                    pst.setString(3,description );

                    int i = pst.executeUpdate();
                    if (i != 0) {
                        System.out.println("added");
                    } else {
                        System.out.println("failed");
                    }
                } catch (Exception ex) {
        
                }
      } 
      
      /*       public void UpdateDeportement() {
        String UPDATE_USERS_SQL = "update users set desccription = ? where id = ?;";
        try {
            Connection connection = JDBCUtils.getConnection();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter user Id:");
            String userid = sc.next();
            System.out.println("Enter desccription");
            String desccription = sc.next();
            PreparedStatement pst = connection
                    .prepareStatement(UPDATE_USERS_SQL);

            pst.setString(3, desccription);
            pst.setString(2, userid);

            int i = pst.executeUpdate();
            if (i != 0) {
                System.out.println("updated");
            } else {
                System.out.println("failed");
            }
        } catch (Exception ex) {

        }
    }      */
      /*       public void DeleteDeportement() {
        String DELETE_USERS_SQL = "delete from users where id = ?;";
        try {
            Connection connection = JDBCUtils.getConnection();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter user Id:");
            String userid = sc.next();
            PreparedStatement pst = connection
                    .prepareStatement(DELETE_USERS_SQL);

            pst.setString(1, userid);

            int i = pst.executeUpdate();
            if (i != 0) {
                System.out.println("deleted");
            } else {
                System.out.println("failed");
            }
        } catch (Exception ex) {

        }
    } */
      /*       public void SelectDeportementByid() {
        String QUERY = "select id,name,email,country,password from users where id =?";
        try {
            Connection connection = JDBCUtils.getConnection();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter user Id:");
            String userid = sc.next();
            PreparedStatement pst = connection
                    .prepareStatement(QUERY);

            pst.setString(1, userid);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                String password = rs.getString("password");
                System.out.println(id + "," + name + "," + email + "," + country + "," + password);
            }
        } catch (Exception ex) {

        }
    } */
       
        
    public void Getdeportement() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM Users";
        Connection conn = JDBCUtils.getConnection();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        System.out.println("id\tname\tdescription");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String description = rs.getString("description");
            System.out.println(id + "\t" + name + "\t" + description);
        }
        
    }    
}