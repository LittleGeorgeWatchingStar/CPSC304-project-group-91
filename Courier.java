import java.sql.*;

public class Courier {
    private String ssn;
    private String employeeName;
    public String[] orderNums  = new String[5];


    private Connection con;
    public String[] receiverArray = new String[5];
    public String[] statusArray = new String[5];
    public Long[] WeightArray = new Long[5];
    private int stationNumber;

    public Courier(String ssn,  String name, Connection con){
        this.ssn = ssn;
        this.con = con;
        employeeName = name;

        PreparedStatement ps;
        try {
            ps = con.prepareStatement("SELECT * FROM COURIER WHERE CO_SSN = ?");
            ps.setInt(1, Integer.parseInt(ssn));
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                stationNumber = resultSet.getInt("DEV_NO");
            }
            ps.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
            System.exit(12);
        }
    }

    public void viewPackageOnHand(){
        try{
            PreparedStatement ps =con.prepareStatement("SELECT TRACKING_NO, RECEIVER_NAME, STATUS, RECEIVER_PHONENO, WEIGHT FROM PACKAGES WHERE CO_SSN =?");
            ps.setInt(1,Integer.parseInt(ssn));
            ResultSet rs = ps.executeQuery();
            int i  = 0;
            while(rs.next()&&i<5){
                orderNums[i] = rs.getString("TRACKING_NO");
                receiverArray[i] = rs.getString("RECEIVER_NAME");
                statusArray[i] = rs.getString("STATUS");
                WeightArray[i] = rs.getLong("WEIGHT");
                i++;
            }
            ps.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

//    public void viewPrioritizedPackages(){
//        try{
//            PreparedStatement ps =con.prepareStatement("SELECT TRACKING_NO, RECEIVER_NAME, STATUS, RECEIVER_PHONENO, WEIGHT FROM PACKAGES WHERE CO_SSN =? AND DELIVERTYPE = 'EXPRESS'");
//            ps.setInt(1,Integer.parseInt(ssn));
//            ResultSet rs = ps.executeQuery();
//            int i  = 0;
//            while(rs.next()&&i<5){
//                orderNums[i] = rs.getString("TRACKING_NO");
//                receiverArray[i] = rs.getString("RECEIVER_NAME");
//                statusArray[i] = rs.getString("STATUS");
//                WeightArray[i] = rs.getLong("WEIGHT");
//                i++;
//            }
//            ps.close();
//        }catch (SQLException e){
//            System.out.println(e.getMessage());
//        }
//
//    }

    public void updatePackage(int orderId){
        try{
            PreparedStatement ps =con.prepareStatement("UPDATE PACKAGES SET STATUS='delivered' WHERE TRACKING_NO = ?");
            ps.setInt(1,orderId);
            ps.execute();
            ps.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public int totalWeight(){
        try{
            PreparedStatement ps =con.prepareStatement("SELECT SUM(WEIGHT) FROM PACKAGES WHERE DEV_NO = ?");
            ps.setInt(1,stationNumber);
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

    public String placeOrder(int clogin,String type,  String receiverName, String recieverAddress, String recieverPhoneNo,
                             String weight, String DeliverType){
        float weightNum = Float.parseFloat(weight);
        int rPhone = toInt(recieverPhoneNo);
        try {
            PreparedStatement ps;
            ps = con.prepareStatement("INSERT INTO PACKAGES VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1,trackingNUmGenerater());
            ps.setString(2,recieverAddress);
            ps.setString(3,receiverName);
            ps.setInt(4,rPhone);
            ps.setFloat(5,weightNum);
            ps.setString(6,type);
            ps.setString(8,"deliver_by_courier");
            ps.setInt(7, clogin);
            ps.setString(9,null);
            ps.setString(10,null);
            ps.setString(11,null);
            ps.setString(12,null);
            ps.setString(13,null);
            ps.setString(14,null);
            ps.execute();
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return "OOPS! Order failed due to technical issue!";
        }
        return "Order proceed!";
    }

    private int trackingNUmGenerater(){
        int trackingNum = 1200;
        try{
            PreparedStatement ps = con.prepareStatement("SELECT COUNT(TRACKING_NO) FROM PACKAGES");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                trackingNum += rs.getInt(1)+1;
            }
        }catch(SQLException e){
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
        return trackingNum;
    }

    private int toInt(String s){
        return Integer.parseInt(s);
    }
}
