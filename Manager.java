import java.sql.Connection;

public class Manager {
    private String login;
    private String passWord;
    private String ssn;
    private String phoneNum;
    private String address;
    private String employeeName;
    private String driverLicense;
    private Connection con;

    public Manager(String login, Connection con){
        this.login = toInt(login);
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

    public void addEmployee( String E_pass, String E_SSN, String E_ADD, String E_Name, String E_PHNO, String E_POS) {
        //todo
        try {

            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO EMPLOYEE VALUES (?,?,?,?,?,?)");
            preparedStatement.setInt(1, Integer.parseInt(E_pass));
            preparedStatement.setInt(2, Integer.parseInt(E_SSN));
            preparedStatement.setString(3, E_ADD);
            preparedStatement.setString(4, E_Name);
            preparedStatement.setInt(5, Integer.parseInt(E_PHNO));
            preparedStatement.setString(6, E_POS);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException ex) {
            System.out.println("Message: " + ex.getMessage());
            try {
                // undo the insert
                con.rollback();
            } catch (SQLException ex2) {
                System.out.println("Message: " + ex2.getMessage());
                System.exit(-1);
            }
        }
    }

    public void addDriver(String DR_SSN, String DR_DRLN, String DR_OFF_NO){
            //todo
        try{
                        PreparedStatement preparedStatement= con.prepareStatement ("INSERT INTO DRIVER VALUES (?,?,?)");
                        preparedStatement.setInt(1, Integer.parseInt(DR_SSN));
                        preparedStatement.setInt(2, Integer.parseInt(DR_DRLN));
                        preparedStatement.setInt(3, Integer.parseInt(DR_OFF_NO));

                        preparedStatement.executeUpdate();
                        preparedStatement.close();
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
                }


        }
    public void deleteDriver(String DR_SSN, String DR_DRLN, String DR_OFF_NO){
        //todo

        try{
            PreparedStatement preparedStatement= con.prepareStatement ("DELETE FROM DRIVER WHERE DRI_SSN = ?, DRI_DLNO = ?, DR_OFF_NO = ?");
            preparedStatement.setInt(1, Integer.parseInt(DR_SSN));
            preparedStatement.setInt(2, Integer.parseInt(DR_DRLN));
            preparedStatement.setInt(3, Integer.parseInt(DR_OFF_NO));

            preparedStatement.executeUpdate();
            preparedStatement.close();
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
        }

    }

    public void checkOrder(int orderId){
        //todo
        //track specific order with orderId
    }

    public void deleteOrder(int orderId){
        //todo
    }

    public void report(){

    }

    public void findHeaviestWorkLoad(){

    }
}
