import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Calendar;

public class UIManager extends JFrame implements ActionListener {
    private JLabel add, delete;
    private JLabel name, ssn, address, phone, pwd, drLicense2, ssn2, station2;
    private JLabel tracknum, status, from, to, statusLabel, senderLabel, receiverLabel;
    private JLabel weight, maxWeight, minWeight, weightShow, maxWeightShow, minWeightShow;

    private JTextField tName, tssn, taddress, tphone, tpwd;
    private JTextField tDrL2, tssn2, tOffNo2, tTrackNum;
    private JButton btnAdd, btnDelete, btnTrack, btnReport;
    private JLabel seperationV, seperationH;
    private JCheckBox courier, driver, courier2, driver2, max, min;

    private Tracker tracker;
    private Manager manager;
    private String pktnum;
    private String addName, addSSN, addAddress, addPhone, addPwd, addPosition, deleteDrL2, deleteSSN2, deleteStation2, deletePosition;
    private UIAddCourier addCourier;
    private UIAddDriver addDriver;

    private int heavy = 0, maxW = 0, minW = 0;
    private String heavy2, maxW2, minW2;

    private Connection con;

    private Client client;

    public UIManager(Connection con) {
        this.con = con;
        tracker = new Tracker(con);
        manager = new Manager(con);

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
        pwd = new JLabel();
        pwd.setFont(new Font("Times New Roman", Font.BOLD, 12));
        pwd.setForeground(Color.BLACK);
        pwd.setText("Password");
        pwd.setBounds(20, 220, 100, 45);

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
        tpwd = new JTextField(10);
        tpwd.setBounds(120, 230, 120, 22);
        tpwd.setHorizontalAlignment(JLabel.CENTER);

        drLicense2 = new JLabel();
        drLicense2.setFont(new Font("Times New Roman", Font.BOLD, 12));
        drLicense2.setForeground(Color.BLACK);
        drLicense2.setText("Driver License");
        drLicense2.setBounds(300, 60, 100, 45);

        ssn2 = new JLabel();
        ssn2.setFont(new Font("Times New Roman", Font.BOLD, 12));
        ssn2.setForeground(Color.BLACK);
        ssn2.setText("SSN");
        ssn2.setBounds(300, 100, 100, 45);

        station2 = new JLabel();
        station2.setFont(new Font("Times New Roman", Font.BOLD, 12));
        station2.setForeground(Color.BLACK);
        station2.setText("Office NO.");
        station2.setBounds(300, 140, 100, 45);

        tDrL2 = new JTextField(10);
        tDrL2.setBounds(400, 70, 120, 22);
        tDrL2.setHorizontalAlignment(JLabel.CENTER);
        tssn2 = new JTextField(10);
        tssn2.setBounds(400, 110, 120, 22);
        tssn2.setHorizontalAlignment(JLabel.CENTER);
        tOffNo2 = new JTextField(10);
        tOffNo2.setBounds(400, 150, 120, 22);
        tOffNo2.setHorizontalAlignment(JLabel.CENTER);

        tracknum = new JLabel();
        tracknum.setFont(new Font("Times New Roman", Font.BOLD, 12));
        tracknum.setForeground(Color.BLACK);
        tracknum.setText("Track Number");
        tracknum.setBounds(60, 340, 100, 45);

        tTrackNum = new JTextField(10);
        tTrackNum.setBounds(20, 380, 180, 22);
        tTrackNum.setHorizontalAlignment(JLabel.CENTER);

        btnTrack = new JButton("Track");
        btnTrack.setForeground(Color.BLACK);
        btnTrack.setBounds(50, 420, 120, 30);
        btnTrack.setEnabled(true);
        btnTrack.addActionListener(this);

        status = new JLabel();
        status.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        status.setForeground(Color.BLACK);
        status.setText("Status");
        status.setBounds(50, 450, 100, 45);

        from = new JLabel();
        from.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        from.setForeground(Color.BLACK);
        from.setText("From");
        from.setBounds(50, 490, 100, 45);

        to = new JLabel();
        to.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        to.setForeground(Color.BLACK);
        to.setText("To");
        to.setBounds(50, 530, 100, 45);

        statusLabel = new JLabel();
        statusLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        statusLabel.setForeground(Color.BLACK);
        statusLabel.setText("Unknown");
        statusLabel.setBounds(150, 450, 150, 45);

        senderLabel = new JLabel();
        senderLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        senderLabel.setForeground(Color.BLACK);
        senderLabel.setText("Unknown");
        senderLabel.setBounds(150, 490, 150, 45);

        receiverLabel = new JLabel();
        receiverLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        receiverLabel.setForeground(Color.BLACK);
        receiverLabel.setText("Unknown");
        receiverLabel.setBounds(150, 530, 150, 45);

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

        courier2 = new JCheckBox("Is Courier", false);
        courier2.setBackground(Color.WHITE);
        courier2.setForeground(Color.BLACK);
        courier2.addActionListener(this);
        courier2.setBounds(320, 172, 100, 45);
        courier2.addActionListener(this);

        driver2 = new JCheckBox("Is Driver", false);
        driver2.setBackground(Color.WHITE);
        driver2.setForeground(Color.BLACK);
        driver2.addActionListener(this);
        driver2.setBounds(420, 172, 100, 45);
        driver2.addActionListener(this);

        max = new JCheckBox("Max Pkg", false);
        max.setBackground(Color.WHITE);
        max.setForeground(Color.BLACK);
        max.addActionListener(this);
        max.setBounds(340, 360, 120, 45);
        max.addActionListener(this);

        min = new JCheckBox("Min Pkg", false);
        min.setBackground(Color.WHITE);
        min.setForeground(Color.BLACK);
        min.addActionListener(this);
        min.setBounds(440, 360, 120, 45);
        min.addActionListener(this);

        btnReport= new JButton("Report");
        btnReport.setForeground(Color.BLACK);
        btnReport.setBounds(380, 420, 120, 30);
        btnReport.setEnabled(true);
        btnReport.addActionListener(this);


        weight = new JLabel();
        weight.setFont(new Font("Times New Roman", Font.BOLD, 12));
        weight.setForeground(Color.BLACK);
        weight.setText("Heaviest Average");
        weight.setBounds(340, 450, 100, 45);
        maxWeight = new JLabel();
        maxWeight.setFont(new Font("Times New Roman", Font.BOLD, 12));
        maxWeight.setForeground(Color.BLACK);
        maxWeight.setText("Max Weight");
        maxWeight.setBounds(340, 530, 100, 45);
        minWeight = new JLabel();
        minWeight.setFont(new Font("Times New Roman", Font.BOLD, 12));
        minWeight.setForeground(Color.BLACK);
        minWeight.setText("Min Weight");
        minWeight.setBounds(340, 490, 100, 45);

        weightShow = new JLabel();
        weightShow.setFont(new Font("Times New Roman", Font.BOLD, 12));
        weightShow.setForeground(Color.BLACK);
        weightShow.setText("0 kg");
        weightShow.setBounds(440, 450, 100, 45);
        maxWeightShow = new JLabel();
        maxWeightShow.setFont(new Font("Times New Roman", Font.BOLD, 12));
        maxWeightShow.setForeground(Color.BLACK);
        maxWeightShow.setText("0 kg");
        maxWeightShow.setBounds(440, 530, 100, 45);
        minWeightShow = new JLabel();
        minWeightShow.setFont(new Font("Times New Roman", Font.BOLD, 12));
        minWeightShow.setForeground(Color.BLACK);
        minWeightShow.setText("0 kg");
        minWeightShow.setBounds(440, 490, 100, 45);

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
        panel.add(name); panel.add(ssn); panel.add(address); panel.add(phone); panel.add(pwd);
        panel.add(drLicense2); panel.add(ssn2);panel.add(station2);


        panel.add(tracknum); panel.add(status); panel.add(from); panel.add(to);
        panel.add(statusLabel); panel.add(senderLabel); panel.add(receiverLabel);
        panel.add(tName); panel.add(tssn); panel.add(taddress); panel.add(tphone); panel.add(tpwd);
        panel.add(tDrL2); panel.add(tssn2); panel.add(tOffNo2);
        panel.add(tTrackNum);
        panel.add(btnAdd); panel.add(btnDelete); panel.add(btnTrack);
        panel.add(seperationV); panel.add(seperationH);
        panel.add(driver); panel.add(courier); panel.add(driver2); panel.add(courier2);
        panel.add(min);
        panel.add(max);
        panel.add(btnReport);
        panel.add(weight);
        panel.add(maxWeight);
        panel.add(minWeight);
        panel.add(weightShow);
        panel.add(maxWeightShow);
        panel.add(minWeightShow);

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
        addName = tName.getText();
        addSSN = tssn.getText().toString();
        addAddress = taddress.getText();
        addPhone = tphone.getText().toString();
        addPwd = tpwd.getText().toString();

        deleteDrL2 = tDrL2.getText().toString();
        deleteSSN2 = tssn2.getText().toString();
        deleteStation2 = tOffNo2.getText().toString();



        if (max.isSelected() && min.isSelected()) {
            max.setSelected(false); min.setSelected(false);
            ImageIcon img2 = new ImageIcon("13.jpg");
            JOptionPane.showMessageDialog(null, "Please select one.",
                    "Information Dialog", JOptionPane.WARNING_MESSAGE,img2);
            return;
        } else if (max.isSelected()){
            maxW = manager.findMaximumPackageNumberByCourier();
        } else if (min.isSelected()){
            minW = manager.findMinimumtAverageWeightByCourier();
        }

        if (e.getSource() == btnReport){
            heavy = manager.findHeaviestAverageWeightByCourier();
            weightShow.setText(""+heavy);
            maxWeightShow.setText(""+maxW);
            minWeightShow.setText(""+minW);
        }
        
        if (courier.isSelected() && driver.isSelected()) {
            courier.setSelected(false); driver.setSelected(false);
            ImageIcon img2 = new ImageIcon("13.jpg");
            JOptionPane.showMessageDialog(null, "Please select one position.",
                    "Information Dialog", JOptionPane.WARNING_MESSAGE,img2);
            return;
        } else if (courier.isSelected()){
            addPosition = "COURIER";
        } else if (driver.isSelected()){
            addPosition = "DRIVER";
        }

        if (courier2.isSelected() && driver2.isSelected()) {
            courier2.setSelected(false); driver2.setSelected(false);
            ImageIcon img2 = new ImageIcon("13.jpg");
            JOptionPane.showMessageDialog(null, "Should be one position.",
                    "Information Dialog", JOptionPane.WARNING_MESSAGE,img2);
            return;
        } else if (courier2.isSelected()){
            deletePosition = "COURIER";
        } else if (driver2.isSelected()){
            deletePosition = "DRIVER";
        }

        if(e.getSource() == btnAdd){
            if(addName.isEmpty() || addSSN.isEmpty() || addAddress.isEmpty() || addPhone.isEmpty() || addPwd.isEmpty()){
                ImageIcon img2 = new ImageIcon("13.jpg");
                JOptionPane.showMessageDialog(null, "Please complete the form before register",
                        "Information Dialog", JOptionPane.WARNING_MESSAGE,img2);
                return;
            } else if(addPwd.length() != 6){
                ImageIcon img2 = new ImageIcon("13.jpg");
                JOptionPane.showMessageDialog(null, "Please enter 6 digits password only contains numbers!",
                        "Information Dialog", JOptionPane.WARNING_MESSAGE,img2);
                return;
            }

            boolean status =  manager.addEmployee(addPwd, addSSN, addAddress, addName, addPhone, addPosition);

            if(status){
                ImageIcon img1 = new ImageIcon("12.jpg");
                JOptionPane.showMessageDialog(null, "Second Step!", "Success!",
                        JOptionPane.INFORMATION_MESSAGE,img1);
                this.dispose();
            }else{
                ImageIcon img2 = new ImageIcon("13.jpg");
                JOptionPane.showMessageDialog(null, "OOPS! Register failed :(",
                        "Failed", JOptionPane.WARNING_MESSAGE,img2);
                return;
            }

            if (addPosition == "COURIER") {
                addCourier = new UIAddCourier(con, addSSN);
                this.dispose();
            } else if (addPosition == "DRIVER") {
                addDriver = new UIAddDriver(con, addSSN);
                this.dispose();
            }

        }
        if(e.getSource() == btnDelete){
            if(deleteSSN2.isEmpty() || deleteDrL2.isEmpty() || deleteStation2.isEmpty()){
                ImageIcon img2 = new ImageIcon("13.jpg");
                JOptionPane.showMessageDialog(null, "Please complete the form before delete",
                        "Information Dialog", JOptionPane.WARNING_MESSAGE,img2);
                return;
            }

            boolean status2 = false;
            if (deletePosition == "COURIER") {
                status2= manager.deleteCourier(deleteSSN2, deleteDrL2, deleteStation2);
            } else if (deletePosition == "DRIVER") {
                status2= manager.deleteDriver(deleteSSN2, deleteDrL2, deleteStation2);
            }


            if(status2){
                ImageIcon img1 = new ImageIcon("12.jpg");
                JOptionPane.showMessageDialog(null, "Employee have been fired!", "Success!",
                        JOptionPane.INFORMATION_MESSAGE,img1);
                this.dispose();
            }else{
                ImageIcon img2 = new ImageIcon("13.jpg");
                JOptionPane.showMessageDialog(null, "OOPS! Register failed :(",
                        "Failed", JOptionPane.WARNING_MESSAGE,img2);
                return;
            }

            ImageIcon img1 = new ImageIcon("12.jpg");
            JOptionPane.showMessageDialog(null, "", "Success!", JOptionPane.INFORMATION_MESSAGE,img1);
            this.dispose();
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
