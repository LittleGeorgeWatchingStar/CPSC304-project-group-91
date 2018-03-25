import java.sql.*;

public class DBDriver {
    public Connection connection;

    DBDriver(){
        try
        {
            // Load the Oracle JDBC driver
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            // may be oracle.jdbc.driver.OracleDriver as of Oracle 11g
        }
        catch (SQLException ex)
        {
            System.out.println("Message: " + ex.getMessage());
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        new DBDriver().connect();
    }

    public boolean connect(){
        {
            String userName = "ora_q8j0b";
            String password = "a30409156";
            String connectURL = "jdbc:oracle:thin:@localhost.ugrad.cs.ubc.ca:1522:ug";

            try
            {
                connection = DriverManager.getConnection(connectURL,userName,password);

                System.out.println("\nConnected to Oracle!");
                return true;
            }
            catch (SQLException ex)
            {
                System.out.println("Message: " + ex.getMessage());
                return false;
            }
        }
    }



}
