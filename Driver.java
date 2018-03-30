import java.sql.*;

public class Driver {
    private String passWord;
    private String ssn;
    private String employeeName;
    private Connection con;

    public Driver(String ssn, Connection con){
        this.ssn = ssn;
        this.passWord = passWord;
        this.con = con;
    }


    public void checkPackage(int orderId){
        try{
            PreparedStatement ps =con.prepareStatement("SELECT * FROM PACKAGES WHERE TRACKING_NO =?");
            ps.setInt(1,orderId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String receiverName = rs.getString(1);
                Long receiverPhone = rs.getLong(2);
                String receiverAddress = rs.getString(3);

            }
            ps.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void changePackageStatus(int orderId){
        try{
            PreparedStatement ps =con.prepareStatement("UPDATE PACKAGES SET STATUS='deliver_by_driver' WHERE TRACKING_NO = ?");
            ps.setInt(1,orderId);
            ps.execute();
            ps.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public int totalWeight(){
        try{
            PreparedStatement ps =con.prepareStatement("SELECT SUM(WEIGHT) FROM PACKAGES WHERE DRI_SSN = ?");
            ps.setInt(1,Integer.parseInt(ssn));
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int totalWeight = rs.getInt(1);
            }
            ps.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return totalWeight();
    }


}
