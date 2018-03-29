import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tracker {
    //Class for reciever to track their parcel
    Connection con;
    public Tracker(Connection con){
        this.con = con;
    }
    public String status = "N/A";
    public String sender = "N/A";

    public void track(String trackingNum){
        int trackingInt = Integer.parseInt(trackingNum);
        try{
            PreparedStatement ps = con.prepareStatement("SELECT STATUS, C_NAME FROM  PACKAGES, CLIENT WHERE TRACKING_NO = ? AND CLIENT.C_NO = PACKAGES.CLIENT_NO");

            ps.setInt(1,trackingInt);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()) {
                status = resultSet.getString("STATUS");
                sender = resultSet.getString("C_NAME");
            }
            ps.close();

        }catch(SQLException e){
            System.out.println("Message: " + e.getMessage());
            try
            {
                con.rollback();
            }
            catch (SQLException ex2)
            {
                System.out.println("Message: " + ex2.getMessage());
                System.exit(-1);
            }
        }
    }

}
