import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Calendar;

public class UIManager extends JFrame implements ActionListener {
    private JLabel add, delete;
    private JLabel name, ssn, address, phone, drLicense, name2, ssn2;
    private JLabel drLicense2, drLicense2Confirm, tracknum, status, from, to, statusLabel, senderLabel, receiverLabel;
    private JLabel weight, weightLabel, clientNo, clientLabel, driverNo, driverLabel, courierNo, courierLabel;

    private JTextField tName, tssn, taddress, tphone, tdrlicense;
    private JTextField tName2, tssn2, tTrackNum;
    private JButton btnAdd, btnDelete, btnTrack;
    private JLabel seperationV, seperationH;
    private JCheckBox courier, driver;

    private Tracker tracker;
    //private Manager manager;
    private String pktnum;

    private Connection con;

    private Client client;

    public UIManager(Connection con) {
        this.con = con;
        tracker = new Tracker(con);
        //manager = new Manager(con);

        add = new JLabel();
        add.setFont(new Font("Times New Roman", Font.BOLD, 15));
        add.setForeground(Color.BLACK);
        add.setText("Add Employee");
        add.setBounds(80, 20, 150, 45);
        delete = new JLabel();
        delete.setFont(new Font("Times New Roman", Font.BOLD, 15));
        delete.setForeground(Color.BLACK);
        delete.setText("Fire Employee");
        delete.setBounds(350, 20, 150, 45);

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
        address = new JLabel();
        address.setFont(new Font("Times New Roman", Font.BOLD, 12));
        address.setForeground(Color.BLACK);
        address.setText("Address");
        address.setBounds(20, 140, 100, 45);
        phone = new JLabel();
        phone.setFont(new Font("Times New Roman", Font.BOLD, 12));
        phone.setForeground(Color.BLACK);
        phone.setText("Phone");
        phone.setBounds(20, 180, 100, 45);
        drLicense = new JLabel();
        drLicense.setFont(new Font("Times New Roman", Font.BOLD, 12));
        drLicense.setForeground(Color.BLACK);
        drLicense.setText("Dr License");
        drLicense.setBounds(20, 220, 100, 45);

        tName = new JTextField(10);
        tName.setBounds(120, 70, 120, 22);
        tName.setHorizontalAlignment(JLabel.CENTER);
        tssn = new JTextField(10);
        tssn.setBounds(120, 110, 120, 22);
        tssn.setHorizontalAlignment(JLabel.CENTER);
        taddress = new JTextField(10);
        taddress.setBounds(120, 150, 120, 22);
        taddress.setHorizontalAlignment(JLabel.CENTER);
        tphone = new JTextField(10);
        tphone.setBounds(120, 190, 100, 22);
        tphone.setHorizontalAlignment(JLabel.CENTER);
        tdrlicense = new JTextField(10);
        tdrlicense.setBounds(120, 230, 120, 22);
        tdrlicense.setHorizontalAlignment(JLabel.CENTER);

        name2 = new JLabel();
        name2.setFont(new Font("Times New Roman", Font.BOLD, 12));
        name2.setForeground(Color.BLACK);
        name2.setText("Name");
        name2.setBounds(300, 60, 100, 45);

        ssn2 = new JLabel();
        ssn2.setFont(new Font("Times New Roman", Font.BOLD, 12));
        ssn2.setForeground(Color.BLACK);
        ssn2.setText("SSN");
        ssn2.setBounds(300, 100, 100, 45);

        drLicense2 = new JLabel();
        drLicense2.setFont(new Font("Times New Roman", Font.BOLD, 12));
        drLicense2.setForeground(Color.BLACK);
        drLicense2.setText("Dr License");
        drLicense2.setBounds(300, 140, 100, 45);

        drLicense2Confirm = new JLabel();
        drLicense2Confirm.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        drLicense2Confirm.setForeground(Color.BLACK);
        drLicense2Confirm.setText("0000000");
        drLicense2Confirm.setBounds(440, 140, 100, 45);

        tName2 = new JTextField(10);
        tName2.setBounds(400, 70, 120, 22);
        tName2.setHorizontalAlignment(JLabel.CENTER);
        tssn2 = new JTextField(10);
        tssn2.setBounds(400, 100, 120, 22);
        tssn2.setHorizontalAlignment(JLabel.CENTER);

        tracknum = new JLabel();
        tracknum.setFont(new Font("Times New Roman", Font.BOLD, 12));
        tracknum.setForeground(Color.BLACK);
        tracknum.setText("Track Number");
        tracknum.setBounds(225, 340, 100, 45);

        tTrackNum = new JTextField(10);
        tTrackNum.setBounds(180, 380, 180, 22);
        tTrackNum.setHorizontalAlignment(JLabel.CENTER);

        btnTrack = new JButton("Track");
        btnTrack.setForeground(Color.BLACK);
        btnTrack.setBounds(210, 420, 120, 30);
        btnTrack.setEnabled(true);
        btnTrack.addActionListener(this);

        status = new JLabel();
        status.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        status.setForeground(Color.BLACK);
        status.setText("Status");
        status.setBounds(200, 450, 100, 45);

        from = new JLabel();
        from.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        from.setForeground(Color.BLACK);
        from.setText("From");
        from.setBounds(200, 490, 100, 45);

        to = new JLabel();
        to.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        to.setForeground(Color.BLACK);
        to.setText("To");
        to.setBounds(200, 530, 100, 45);

        statusLabel = new JLabel();
        statusLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        statusLabel.setForeground(Color.BLACK);
        statusLabel.setText("Unknown");
        statusLabel.setBounds(300, 450, 150, 45);

        senderLabel = new JLabel();
        senderLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        senderLabel.setForeground(Color.BLACK);
        senderLabel.setText("Unknown");
        senderLabel.setBounds(300, 490, 150, 45);

        receiverLabel = new JLabel();
        receiverLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        receiverLabel.setForeground(Color.BLACK);
        receiverLabel.setText("Unknown");
        receiverLabel.setBounds(300, 530, 150, 45);

        courier = new JCheckBox("As Courier", false);
        courier.setBackground(Color.WHITE);
        courier.setForeground(Color.BLACK);
        courier.addActionListener(this);
        courier.setBounds(30, 250, 100, 45);
        courier.addActionListener(this);

        driver = new JCheckBox("As Driver", false);
        driver.setBackground(Color.WHITE);
        driver.setForeground(Color.BLACK);
        driver.addActionListener(this);
        driver.setBounds(140, 250, 100, 45);
        driver.addActionListener(this);

        btnAdd = new JButton("Confirm");
        btnAdd.setForeground(Color.BLACK);
        btnAdd.setBounds(80, 290, 120, 30);
        btnAdd.setEnabled(true);
        btnAdd.addActionListener(this);
        btnDelete = new JButton("Confirm");
        btnDelete.setForeground(Color.BLACK);
        btnDelete.setBounds(350, 210, 120, 30);
        btnDelete.setEnabled(true);
        btnDelete.addActionListener(this);

        ImageIcon img1 = new ImageIcon("ver.jpg");
        seperationV = new JLabel();
        seperationV.setIcon(img1);
        seperationV.setBounds(260, 50, 2, 275);
        ImageIcon img2 = new ImageIcon("hori.jpg");
        seperationH = new JLabel();
        seperationH.setIcon(img2);
        seperationH.setBounds(50, 330, 420, 2);

        // Declare and initialize JPanel
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.add(add);
        panel.add(delete);
        panel.add(name); panel.add(ssn); panel.add(address); panel.add(phone); panel.add(drLicense);
        panel.add(name2); panel.add(ssn2);
        panel.add(drLicense2); panel.add(drLicense2Confirm);
        panel.add(tracknum); panel.add(status); panel.add(from); panel.add(to);
        panel.add(statusLabel); panel.add(senderLabel); panel.add(receiverLabel);
        panel.add(tName); panel.add(tssn); panel.add(taddress); panel.add(tphone); panel.add(tdrlicense);
        panel.add(tName2); panel.add(tssn2); panel.add(tTrackNum);
        panel.add(btnAdd); panel.add(btnDelete); panel.add(btnTrack);
        panel.add(seperationV); panel.add(seperationH);
        panel.add(driver); panel.add(courier);

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
        pktnum = tTrackNum.getText();

        if(e.getSource() == btnAdd){

        }
        if(e.getSource() == btnDelete){

        }
        if(e.getSource() == btnTrack){
            tracker.track(pktnum);
            String status = tracker.status;
            String sender = tracker.sender;
            String reciver = tracker.receiver;
            statusLabel.setText(status);
            this.senderLabel.setText(sender);
            this.receiverLabel.setText(reciver);
        }
    }
}
