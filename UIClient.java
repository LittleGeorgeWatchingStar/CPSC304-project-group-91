import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UIClient extends JFrame implements ActionListener {
    private JButton btnsignin, btnregister;
    private JTextField login;
    private JPasswordField password;
    private UIRegister UIReg;
    private Connection con;
    private Register register;
    private UIClientService UIOpenClient;


    public UIClient(Connection con) {
        // Declare and initialize a JLabel
        this.con = con;
        register = new Register(con);
        JLabel l1 = new JLabel();
        l1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        l1.setForeground(Color.BLACK);
        l1.setText("  Express Service Client Login");
        l1.setBounds(220, 5, 250, 45);

        JLabel l2 = new JLabel();
        l2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        l2.setForeground(Color.BLUE);
        l2.setText("Can I have your Login");
        l2.setBounds(220, 35, 250, 45);

        JLabel l3 = new JLabel();
        l3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        l3.setForeground(Color.BLUE);
        l3.setText("Please enter your password");
        l3.setBounds(220, 85, 250, 45);

        //set an image to a label
        ImageIcon img = new ImageIcon("16.jpg");
        JLabel Imglabel = new JLabel();
        Imglabel.setIcon(img);
        Imglabel.setBounds(5, 5, 200, 200);

        // Initialize JButtons
        btnsignin = new JButton("Log in");
        /*btnsignin.setIcon(img);
         * You can set an image to a  button if you want
         */
        btnsignin.setBounds(228, 170, 80, 30);
        btnsignin.addActionListener(this);

        //ImageIcon bimg = new ImageIcon("16.jpg");
        btnregister = new JButton("Register");
        //btnregister.setIcon(bimg);
        btnregister.setBounds(328, 170, 80, 30);
        btnregister.addActionListener(this);

        // Initialize JTextField



        login = new JTextField(10);
        login.setBounds(220, 70, 196, 22);
        login.setHorizontalAlignment(JLabel.CENTER);

        password = new JPasswordField(10);
        password.setBounds(220, 125, 196, 22);
        password.setHorizontalAlignment(JLabel.CENTER);

        // Declare and initialize JPanel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(l1);
        panel.add(l2);
        panel.add(l3);
        panel.add(Imglabel);
        panel.add(login);
        panel.add(password);
        panel.add(btnsignin);
        panel.add(btnregister);

        // Set properties of the JFrame
        setContentPane(panel);
        setSize(450, 250);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Welcome");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        // 2017 Quan Zhang, David Chen all rights reserved
    }




//    JOptionPane.showMessageDialog(null, "Not a client yet? Apply to us now", "JButton",
//    JOptionPane.INFORMATION_MESSAGE);

    public void actionPerformed(ActionEvent e) {
        // Get the text entered in the text field
        String yourLogin = login.getText();
        String yourPassword = password.getText();

        // Nothing is entered in the text field
        if (e.getSource() == btnsignin) {
            // 2017 Quan Zhang, David Chen all rights reserved
            try{
                PreparedStatement ps = con.prepareStatement("SELECT C_PASSWORD FROM CLIENT_LOGIN WHERE C_NO = ?");
                ps.setInt(1, Integer.parseInt(yourLogin));
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    if(rs.getInt(1) == Integer.parseInt(yourPassword)){
                        ImageIcon img1 = new ImageIcon("12.jpg");
                        JOptionPane.showMessageDialog(null, "Haha,yes", "JButton",
                                JOptionPane.INFORMATION_MESSAGE,img1);

                        UIOpenClient = new UIClientService();

                    }else {
                        ImageIcon img2 = new ImageIcon("13.jpg");
                        JOptionPane.showMessageDialog(null, "Nope, wrong password",
                        "Information Dialog", JOptionPane.WARNING_MESSAGE,img2);
                    }
                }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }

        } else if (e.getSource() == btnregister) {

            this.dispose();

            UIReg = new UIRegister(con);


        }
    }

}