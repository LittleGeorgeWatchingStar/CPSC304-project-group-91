import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class UIAddCourier extends JFrame implements ActionListener {
    private JLabel add;
    private JLabel name, ssn, drLicense, station;

    private JTextField tName, tssn, tDrL, tStation;
    private JButton btnAdd;

    private Manager manager;
    private String addName, addSSN, addDrL, addStation;


    private Connection con;

    private Client client;

    public UIAddCourier(Connection con) {
        this.con = con;

        manager = new Manager(con);

        add = new JLabel();
        add.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add.setForeground(Color.BLACK);
        add.setText("Add Courier");
        add.setBounds(80, 20, 150, 45);

        name = new JLabel();
        name.setFont(new Font("Times New Roman", Font.BOLD, 12));
        name.setForeground(Color.BLACK);
        name.setText("Name");
        name.setBounds(20, 60, 100, 45);
        ssn = new JLabel();
        ssn.setFont(new Font("Times New Roman", Font.BOLD, 12));
        ssn.setForeground(Color.BLACK);
        ssn.setText("SSN");
        ssn.setBounds(20, 100, 100, 45);

        drLicense = new JLabel();
        drLicense.setFont(new Font("Times New Roman", Font.BOLD, 12));
        drLicense.setForeground(Color.BLACK);
        drLicense.setText("Driver License");
        drLicense.setBounds(20, 140, 100, 45);

        station = new JLabel();
        station.setFont(new Font("Times New Roman", Font.BOLD, 12));
        station.setForeground(Color.BLACK);
        station.setText("Station");
        station.setBounds(20, 180, 100, 45);


        tName = new JTextField(10);
        tName.setBounds(120, 70, 120, 22);
        tName.setHorizontalAlignment(JLabel.CENTER);
        tssn = new JTextField(10);
        tssn.setBounds(120, 110, 120, 22);
        tssn.setHorizontalAlignment(JLabel.CENTER);
        tDrL = new JTextField(10);
        tDrL.setBounds(120, 150, 120, 22);
        tDrL.setHorizontalAlignment(JLabel.CENTER);
        tStation = new JTextField(10);
        tStation.setBounds(120, 190, 120, 22);
        tStation.setHorizontalAlignment(JLabel.CENTER);


        btnAdd = new JButton("Confirm");
        btnAdd.setForeground(Color.BLACK);
        btnAdd.setBounds(80, 230, 120, 30);
        btnAdd.setEnabled(true);
        btnAdd.addActionListener(this);

        // Declare and initialize JPanel
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);

        panel.add(add);
        panel.add(name);
        panel.add(ssn);
        panel.add(drLicense);
        panel.add(station);
        panel.add(tName);
        panel.add(tssn);
        panel.add(tDrL);
        panel.add(tStation);
        panel.add(btnAdd);

        // Set properties of the JFrame
        setContentPane(panel);
        setSize(560, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Express Service Administer Only");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        // 2017 Quan Zhang, David Chen all rights reserved
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        addName = tName.getText();
        addSSN = tssn.getText();
        addDrL = tDrL.getText();
        addStation = tStation.getText();

        if(e.getSource() == btnAdd){
            if(addName.isEmpty() || addSSN.isEmpty() || addDrL.isEmpty() || addStation.isEmpty()){
                ImageIcon img2 = new ImageIcon("13.jpg");
                JOptionPane.showMessageDialog(null, "Please complete the form before register",
                        "Information Dialog", JOptionPane.WARNING_MESSAGE,img2);
                return;
            }

            manager.addCourier(addSSN,addDrL,addStation);

            ImageIcon img1 = new ImageIcon("12.jpg");
            JOptionPane.showMessageDialog(null, "New employee "+ addName +" have been registered!", "Success!", JOptionPane.INFORMATION_MESSAGE,img1);
            this.dispose();
        }

    }
}
