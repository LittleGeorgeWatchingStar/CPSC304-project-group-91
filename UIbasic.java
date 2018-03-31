import javax.swing.*;

import javax.swing.JPanel;

import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class UIbasic extends JFrame implements ActionListener {
    private JButton btnsignin, btnexit;
    private JTextField name;
    private JPasswordField password;
    private Connection con;
    private UIEmployee employeePage;
    private UIManager UImanager;


    public UIbasic(Connection con) {
        this.con = con;

        // Declare and initialize a JLabel
        JLabel l1 = new JLabel();
        l1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        l1.setForeground(Color.RED);
        l1.setText("  Express Service Employee Login");
        l1.setBounds(220, 5, 250, 45);

        JLabel l2 = new JLabel();
        l2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        l2.setForeground(Color.BLUE);
        l2.setText("Please enter your name");
        l2.setBounds(220, 35, 250, 45);

        JLabel l3 = new JLabel();
        l3.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        l3.setForeground(Color.BLUE);
        l3.setText("I need your password");
        l3.setBounds(220, 85, 250, 45);

        //set an image to a label
        ImageIcon img = new ImageIcon("15.jpg");
        JLabel Imglabel = new JLabel();
        Imglabel.setIcon(img);
        Imglabel.setBounds(5, 5, 200, 200);

        // Initialize JButtons
        btnsignin = new JButton("Log in");
        /*btnsignin.setIcon(img);
         * You can set an image to a  button if you want
         */
        btnsignin.setBounds(280, 170, 80, 30);
        btnsignin.addActionListener(this);

        // Initialize JTextField
        name = new JTextField(10);
        name.setBounds(220, 70, 196, 22);
        name.setHorizontalAlignment(JLabel.CENTER);
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
        panel.add(name);
        panel.add(password);
        panel.add(btnsignin);

        //panel.add(btnexit);

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

    public void actionPerformed(ActionEvent e) {

        // Get the text entered in the text field
        String employeename = name.getText();
        String employeepwd = password.getText();

        // Nothing is entered in the text field
        if (e.getSource() == btnsignin) {
            // 2017 Quan Zhang, David Chen all rights reserved
            try{
                PreparedStatement ps = con.prepareStatement("SELECT E_PASSWORD, E_POSITION FROM EMPLOYEE WHERE E_SSN = ?");
                ps.setInt(1, Integer.parseInt(employeename));
                ResultSet rs = ps.executeQuery();


                String employeeType = "";
                while(rs.next()){
                    if(rs.getInt(1) == Integer.parseInt(employeepwd)){
                        ImageIcon img1 = new ImageIcon("12.jpg");
                        JOptionPane.showMessageDialog(null, "Haha,yes", "JButton",
                                JOptionPane.INFORMATION_MESSAGE,img1);
                        employeeType = rs.getString(2);
                        System.out.println(employeeType);


                    }else {
                        ImageIcon img2 = new ImageIcon("13.jpg");
                        JOptionPane.showMessageDialog(null, "Nope, wrong password",
                                "Information Dialog", JOptionPane.WARNING_MESSAGE,img2);
                    }


                    if (employeeType.equals("MANAGER                                           ")) {
                        UImanager = new UIManager(con);
                        this.dispose();
                    } else {
                        Courier courier = new Courier(employeename,employeepwd,con);
                        employeePage = new UIEmployee(con, employeeType,courier);
                        this.dispose();
                    }
                }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }

}