import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Register {
    //class for new client to regist
    private  Connection con;

    public Register(Connection con){
        this.con = con;
    }

    public boolean isExist(int login){
        PreparedStatement preparedStatement;
        int count = 1;
        try{
            preparedStatement = con.prepareStatement("SELECT COUNT(C_NO) FROM  CLIENT_LOGIN WHERE C_NO = ?");
            preparedStatement.setInt(1,login);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                count = rs.getInt(1);
            }
            preparedStatement.close();
        }catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
            System.exit(-1);
        }
        return (count != 0);

    }

    public boolean addClient(int login,String name, int creditCardNum, int cvv, String eMail, String address, long phoneNum, int passWord){
        if(isExist(login)){
            return false;
        }
        PreparedStatement preparedStatement;
        try{
            preparedStatement = con.prepareStatement("INSERT INTO CLIENT VALUES (?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, login);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, creditCardNum);
            preparedStatement.setInt(4, cvv);
            preparedStatement.setLong(5, phoneNum);
            preparedStatement.setString(6,address);
            preparedStatement.setString(7,eMail);
            preparedStatement.executeUpdate();
            preparedStatement = con.prepareStatement("INSERT INTO CLIENT_LOGIN VALUES (?,?)");
            preparedStatement.setInt(1, login);
            preparedStatement.setInt(2, passWord);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
}
