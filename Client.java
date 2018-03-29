import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.sql.*;

public class Client {
    private int login;
    private String eMail;
    public String clientName;
    private int cvv;
    public String[] statusArray = new String[5];
    private String address;
    public String[] receiverArray = new String[5];
    private Connection con;
    public String[] orderNums  = new String[5];
    private long creditCardNum;
    private long phoneNum;

    public Client(String login, Connection con){
        this.login = toInt(login);
        this.con = con;

        PreparedStatement ps;
        try {
            ps = con.prepareStatement("SELECT * FROM CLIENT WHERE C_NO = ?");
            ps.setInt(1, this.login);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                clientName = resultSet.getString("C_NAME");
                eMail = resultSet.getString("C_EMAIL");
                creditCardNum = resultSet.getLong("C_CCARD");
                phoneNum = resultSet.getLong("C_PHONE#");
                cvv = resultSet.getInt("CVV");
                address = resultSet.getString("C_ADDRESS");
            }
            ps.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
            System.exit(12);
        }


    }

    public String placeOrder(String receiverName, String recieverAddress, String recieverPhoneNo,
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
            ps.setString(6,null);
            ps.setInt(7, login);
            ps.setString(8,null);
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

    private String trackOrder(String orderId){
        Tracker tracker = new Tracker(con);
        return tracker.track(orderId);
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

    public void viewOrders(){
        try{
            PreparedStatement ps =con.prepareStatement("SELECT TRACKING_NO, RECEIVER_NAME, STATUS FROM PACKAGES WHERE CLIENT_NO =?");
            ps.setInt(1,login);
            ResultSet rs = ps.executeQuery();
            int i  = 0;
            while(rs.next()&&i<5){
                orderNums[i] = rs.getString("TRACKING_NO");
                receiverArray[i] = rs.getString("RECEIVER_NAME");
                statusArray[i] = rs.getString("STATUS");
                i++;
            }
            ps.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public String deleteOrder(String orderId){
        int orderNum = toInt(orderId);
        PreparedStatement ps;
        if(trackOrder(orderId).equals("Pending")){
            try{
                ps = con.prepareStatement("DELETE FROM PACKAGES WHERE TRACKING_NO = ?");
                ps.setInt(1,orderNum);
                ps.executeUpdate();
                ps.close();
                return "Cancel succeed";
            }catch(SQLException e){
                System.out.println("Message: " + e.getMessage());
                try
                {
                    con.rollback();
                    return "Cancel faild, please contact us for assistance";
                }
                catch (SQLException ex2)
                {
                    System.out.println("Message: " + ex2.getMessage());
                    System.exit(-1);
                }
            }
        }else {
            try {
                ps = con.prepareStatement("UPDATE PACKAGES SET RECEIVER_ADDRESS =?, " +
                        "RECEIVER_NAME =?, RECEIVER_PHONENO =? WHERE TRACKING_NO = ?");
                ps.setString(1, address);
                ps.setString(2, clientName);
                ps.setLong(3, phoneNum);
                ps.setInt(4, orderNum);
                ps.executeUpdate();
                ps.close();
                return "Your parcel is sending back!";
            } catch (SQLException e) {
                System.out.println("Message: " + e.getMessage());
                try {
                    con.rollback();
                    return "Cancel faild, please contact us for assistance";
                } catch (SQLException ex2) {
                    System.out.println("Message: " + ex2.getMessage());
                    System.exit(-2);
                }

            }
        }
        return "Cancel faild, please contact us for assistance";
    }

    public String updatePassword(String oldPassWord, String newPassWord){
        int oPassNum = toInt(oldPassWord);
        int nPassNum = toInt(newPassWord);
        int tempPass = 1000000;
        PreparedStatement ps;
        ResultSet rs;
        if(nPassNum > 999999){
            return "Invalid password, please choose password under 6 digits";
        }
        try{
            ps = con.prepareStatement("SELECT C_PASSWORD FROM CLIENT_LOGIN WHERE C_NO = ?");
            ps.setInt(1, login);
            rs = ps.executeQuery();
            while(rs.next()){
                tempPass = rs.getInt(1);
            }
            if(tempPass == oPassNum){
                ps = con.prepareStatement("UPDATE CLIENT_LOGIN SET C_PASSWORD =? WHERE C_NO =?");
                ps.setInt(1,nPassNum);
                ps.setInt(2, login);
                ps.close();
            }else{
                System.exit(0);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return "Change failed";
        }
        return "Password Updated!";
    }



    public void changeCreditCard(String CreditCardNum, String cvv){
        try{
            PreparedStatement ps = con.prepareStatement("UPDATE CLIENT SET C_CCARD = ?, CVV =? WHERE C_NO = ?");
            ps.setString(1,CreditCardNum);
            ps.setString(2,cvv);
            ps.setInt(3,login);
            ps.executeUpdate();
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

    public void removeCreditCard(){
        try{
            PreparedStatement ps = con.prepareStatement("UPDATE CLIENT SET C_CCARD = NULL , CVV =NULL WHERE C_NO = ?");
            ps.setInt(1,login);
            ps.executeUpdate();
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

    public void deleteAccount(){
        try{
            PreparedStatement ps = con.prepareStatement("DELETE FROM CLIENT WHERE C_NO = ?");
            ps.setInt(1,login);
            ps.executeUpdate();
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

    public void changeAddress(String address){
        try{
            PreparedStatement ps = con.prepareStatement("UPDATE CLIENT SET C_ADDRESS = ? WHERE C_NO = ?");
            ps.setString(1,address);
            ps.setInt(2,login);
            ps.executeUpdate();
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

    public void changePhone(String phone){
        try{
            PreparedStatement ps = con.prepareStatement("UPDATE CLIENT SET C_PHONE# = ? WHERE C_NO = ?");
            ps.setLong(1,Integer.parseInt(phone));
            ps.setInt(2,login);
            ps.executeUpdate();
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

    private int toInt(String s){
        return Integer.parseInt(s);
    }

}
