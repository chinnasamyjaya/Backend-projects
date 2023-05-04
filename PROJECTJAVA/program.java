import java.io.IOException;
import java.sql.SQLException;

public class program {
    public static void main(String[] args) throws IOException, SQLException,
            ClassNotFoundException {
                deportement  deportementObj = new deportement();
                deportementObj.InsertDeportement();
                deportementObj.Getdeportement();
      }
}