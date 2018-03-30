
import java.sql.*;

public class Manager {
    private int login;
    private int passWord;
    private String ssn;
    private int phoneNum;
    public String address;
    public String employeeName;
    public String receiverName;
    public String receiverAddress;
    public String receiverPhoneNo;
    public String weight;
    public String deliveryType;
    public String status;
    public String clientNo;
    public String driverNo;
    public String courierNo;
    public String courierDL;
    public String sendingDate;
    public String driverLicense;
    public String position;
    private Connection con;

    public Manager(Connection con){
        //this.login = toInt(login);
        this.con = con;

        PreparedStatement ps;
        try {
            ps = con.prepareStatement("SELECT * FROM EMPLOYEE WHERE E_SSN = ?");
            ps.setInt(1, this.login);
            ResultSet resultSet = ps.executeQuery();
            while(resultSet.next()){
                employeeName = resultSet.getString("E_NAME");
                position = resultSet.getString("E_POSITION");
                phoneNum = resultSet.getInt("E_PNO");
                address = resultSet.getString("E_ADDRESS");
            }
            ps.close();
        }catch (SQLException e){
            System.exit(-1);
        }
    }

    public boolean addEmployee(String E_pass, String E_SSN, String E_ADD, String E_Name, String E_PHNO, String E_POS) {
        //todo
        try {
            int count = 1;
            PreparedStatement ps = con.prepareStatement("COUNT(E_SSN) FROM EMPLOYEE WHERE E_SSN = ?");
            ps.setInt(1,Integer.parseInt(E_SSN));
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                count = rs.getInt(1);
            }
            ps.close();
            if(count == 0) {
                PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO EMPLOYEE VALUES (?,?,?,?,?,?)");
                preparedStatement.setInt(1, Integer.parseInt(E_pass));
                preparedStatement.setInt(2, Integer.parseInt(E_SSN));
                preparedStatement.setString(3, E_ADD);
                preparedStatement.setString(4, E_Name);
                preparedStatement.setInt(5, Integer.parseInt(E_PHNO));
                preparedStatement.setString(6, E_POS);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }


            return true;

        } catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            try {
                // undo the insert
                con.rollback();
            } catch (SQLException ex2) {
                System.out.println("Message: " + ex2.getMessage());
                System.exit(-1);
            }
            return false;
        }
    }

    public boolean addDriver(String DR_SSN, String DR_DRLN, String DR_OFF_NO){
            //todo
        try{
                        PreparedStatement preparedStatement= con.prepareStatement ("INSERT INTO DRIVER VALUES (?,?,?)");
                        preparedStatement.setInt(1, Integer.parseInt(DR_SSN));
                        preparedStatement.setInt(2, Integer.parseInt(DR_DRLN));
                        preparedStatement.setInt(3, Integer.parseInt(DR_OFF_NO));

                        preparedStatement.executeUpdate();
                        preparedStatement.close();

                        return true;
                    }
                catch(SQLException ex)
                {
                            System.out.println("Message: " + ex.getMessage());
                   try
                    {
                                // undo the insert
                                       con.rollback();
                    }
                    catch (SQLException ex2)
                    {
                                System.out.println("Message: " + ex2.getMessage());
                        System.exit(-1);
                    }

                    return false;
                }


        }
    public boolean deleteDriver(String DR_SSN, String DR_DRLN, String DR_OFF_NO){
        //todo

        try{
            PreparedStatement preparedStatement= con.prepareStatement ("DELETE FROM DRIVER WHERE DRI_SSN = ?, DRI_DLNO = ?, DR_OFF_NO = ?");
            preparedStatement.setInt(1, Integer.parseInt(DR_SSN));
            preparedStatement.setInt(2, Integer.parseInt(DR_DRLN));
            preparedStatement.setInt(3, Integer.parseInt(DR_OFF_NO));

            preparedStatement.executeUpdate();
            preparedStatement.close();

            return true;
        }
        catch(SQLException ex)
        {
            System.out.println("Message: " + ex.getMessage());
            try
            {
                // undo the insert
                con.rollback();
            }
            catch (SQLException ex2)
            {
                System.out.println("Message: " + ex2.getMessage());
                System.exit(-1);
            }

            return false;
        }

    }

      public boolean addCourier(String CO_SSN, String CO_DLNO, String DEV_NO){


        try{
            PreparedStatement preparedStatement= con.prepareStatement ("DELETE FROM COURIER WHERE CO_SSN=?, CO_DLNO = ?, DEV_NO = ?");
            preparedStatement.setInt(1, Integer.parseInt(CO_SSN));
            preparedStatement.setInt(2, Integer.parseInt(CO_DLNO));
            preparedStatement.setInt(3, Integer.parseInt(DEV_NO));

            preparedStatement.executeUpdate();
            preparedStatement.close();

            return true;
        }
        catch(SQLException ex)
        {
            System.out.println("Message: " + ex.getMessage());
            try
            {
                // undo the insert
                con.rollback();
            }
            catch (SQLException ex2)
            {
                System.out.println("Message: " + ex2.getMessage());
                System.exit(-1);
            }

            return false;
        }

    }
    
    public boolean deleteCourier(String CO_SSN, String CO_DLNO, String DEV_NO){

        try{
            PreparedStatement preparedStatement= con.prepareStatement ("INSERT INTO COURIER VALUES (?,?,?)");
            preparedStatement.setInt(1, Integer.parseInt(CO_SSN));
            preparedStatement.setInt(2, Integer.parseInt(CO_DLNO));
            preparedStatement.setInt(3, Integer.parseInt(DEV_NO));

            preparedStatement.executeUpdate();
            preparedStatement.close();

            return true;
        }
        catch(SQLException ex)
        {
            System.out.println("Message: " + ex.getMessage());
            try
            {
                // undo the insert
                con.rollback();
            }
            catch (SQLException ex2)
            {
                System.out.println("Message: " + ex2.getMessage());
                System.exit(-1);
            }

            return false;
        }
    }

    public void checkOrder(int orderId){
        //track specific order with orderId
        try{
            PreparedStatement ps =con.prepareStatement("SELECT * FROM PACKAGES WHERE TRACKING_NO = ?");
            ps.setInt(1,login);
            ResultSet rs = ps.executeQuery();
            receiverName = rs.getString("RECEIVER_NAME");
            receiverAddress = rs.getString("RECEIVER_ADDRESS");
            receiverPhoneNo = rs.getString("RECEIVER_PHONENO");
            weight = rs.getString("WEIGHT");
            deliveryType = rs.getString("DELIVERTYPE");
            status = rs.getString("STATUS");
            clientNo = rs.getString("CLIENT_NO");
            driverNo = rs.getString("DRI_SSN");
            driverLicense = rs.getString("DRI_DLNO");
            courierNo = rs.getString("CO_SSN");
            courierDL = rs.getString("CO_DLNO");
            sendingDate = rs.getString("SENDING_DATE");
            ps.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }


    public void findHeaviestAverageWeightByCourier(){
        try{
            PreparedStatement ps =con.prepareStatement("SELECT MAX (AVG (WEIGHT)) FROM  PACKAGES GROUP BY CO_SSN");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int totalWeight = rs.getInt(1);
            }
            ps.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void findMinimumtAverageWeightByCourier(){
        try{
            PreparedStatement ps =con.prepareStatement("SELECT MIN (AVG (WEIGHT)) FROM  PACKAGES GROUP BY CO_SSN");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int minimumWeight = rs.getInt(1);
            }
            ps.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void findMaximumPackageNumberByCourier(){
        try{
            PreparedStatement ps =con.prepareStatement("SELECT MAX (COUNT (TRACKING_NO)) FROM  PACKAGES GROUP BY CO_SSN");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int Number = rs.getInt(1);
            }
            ps.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
    private int toInt(String s){
        return Integer.parseInt(s);
    }
}
