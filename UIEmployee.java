import javax.swing.*;

import java.awt.*;

import java.sql.Connection;
import java.awt.event.*;

public class UIEmployee extends JFrame implements ActionListener{
    private JLabel hello, name;
    private JLabel viewOrder, status, totalWeight, weight, typeOfVehicle, vehicle;
    private JLabel addPackageHere, pktorderNumber, pktreceiverName, pktaddr, pktweight, pktdeliverType, pktstatus, pktPhone;
    private JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
    private JLabel o1, o2, o3, o4, o5, o6, o7, o8, o9, o10;
    private JLabel s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;
    private JCheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9, checkBox10;
    private JButton addPackage, checkWeight, comfirm;
    private JTextField tClientNumber, treceiverName, taddr, tweight, tdeliverType, tstatus, tPhone;
    private JLabel seperationV;
    private Connection con;
    private Courier courier;

    private String o1t = "0000";
    private String o2t = "0000";
    private String o3t = "0000";
    private String o4t = "0000";
    private String o5t = "0000";

    private String s1t = "N/A";
    private String s2t = "N/A";
    private String s3t = "N/A";
    private String s4t = "N/A";
    private String s5t = "N/A";

    private String r1t = "N/A";
    private String r2t = "N/A";
    private String r3t = "N/A";
    private String r4t = "N/A";
    private String r5t = "N/A";



    public UIEmployee(Connection con, String pos, Courier courier) {
        this.con = con;
        this.courier = courier;

        viewOrder = new JLabel();
        viewOrder.setFont(new Font("Times New Roman", Font.BOLD, 12));
        viewOrder.setForeground(Color.BLACK);
        viewOrder.setText("View Order");
        viewOrder.setBounds(20, 60, 100, 45);

        status = new JLabel();
        status.setFont(new Font("Times New Roman", Font.BOLD, 12));
        status.setForeground(Color.BLACK);
        status.setText("Status");
        status.setBounds(215, 60, 50, 45);

        if(pos == "Courier"){
            if( courier.WeightArray!= null){
                o1t = courier.orderNums[0];
                System.out.println(courier.orderNums[0]);
                s1t = courier.statusArray[0];
                System.out.println(s1t);
                r1t = courier.receiverArray[0];
                System.out.println(r1t);
                if(courier.statusArray[1] != null) {
                    o2t = courier.orderNums[1];
                    s2t = courier.statusArray[1];
                    r2t = courier.receiverArray[1];
                    System.out.println(s2t);
                    if(courier.statusArray[2] != null) {
                        o3t = courier.orderNums[2];
                        s3t = courier.statusArray[2];
                        r3t = courier.receiverArray[2];
                        System.out.println(r3t);
                        if(courier.statusArray[3] != null) {
                            o4t = courier.orderNums[3];
                            s4t = courier.statusArray[3];
                            r4t = courier.receiverArray[3];
                            if(courier.statusArray[4] != null) {
                                o5t = courier.orderNums[4];
                                s5t = courier.statusArray[4];
                                r5t = courier.receiverArray[4];
                            }
                        }
                    }

                }
            }
        }


        o1 = new JLabel();
        o1.setFont(new Font("Magneto", Font.BOLD, 12));
        o1.setForeground(Color.BLACK);
        o1.setText(o1t);
        o2 = new JLabel();
        o2.setFont(new Font("Magneto", Font.BOLD, 12));
        o2.setForeground(Color.BLACK);
        o2.setText(o2t);
        o3 = new JLabel();
        o3.setFont(new Font("Magneto", Font.BOLD, 12));
        o3.setForeground(Color.BLACK);
        o3.setText(o3t);
        o4 = new JLabel();
        o4.setFont(new Font("Magneto", Font.BOLD, 12));
        o4.setForeground(Color.BLACK);
        o4.setText(o4t);
        o5 = new JLabel();
        o5.setFont(new Font("Magneto", Font.BOLD, 12));
        o5.setForeground(Color.BLACK);
        o5.setText(o5t);

        s1 = new JLabel();
        s1.setFont(new Font("Magneto", Font.BOLD, 12));
        s1.setForeground(Color.BLACK);
        s1.setText(s1t);
        s2 = new JLabel();
        s2.setFont(new Font("Magneto", Font.BOLD, 12));
        s2.setForeground(Color.BLACK);
        s2.setText(s2t);
        s3 = new JLabel();
        s3.setFont(new Font("Magneto", Font.BOLD, 12));
        s3.setForeground(Color.BLACK);
        s3.setText(s3t);
        s4 = new JLabel();
        s4.setFont(new Font("Magneto", Font.BOLD, 12));
        s4.setForeground(Color.BLACK);
        s4.setText(s4t);
        s5 = new JLabel();
        s5.setFont(new Font("Magneto", Font.BOLD, 12));
        s5.setForeground(Color.BLACK);
        s5.setText(s5t);


        JPanel packagePanel = new JPanel();
        packagePanel.setBorder(BorderFactory
                .createTitledBorder("Current Packages"));
        packagePanel.setLayout(new GridLayout(10, 3, 10, 5));
        packagePanel.add(l1);
        packagePanel.add(o1);
        packagePanel.add(s1);
        packagePanel.add(l2);
        packagePanel.add(o2);
        packagePanel.add(s2);
        packagePanel.add(l3);
        packagePanel.add(o3);
        packagePanel.add(s3);
        packagePanel.add(l4);
        packagePanel.add(o4);
        packagePanel.add(s4);
        packagePanel.add(l5);
        packagePanel.add(o5);
        packagePanel.add(s5);


        packagePanel.setBackground(Color.WHITE);
        packagePanel.setBounds(20, 110, 290, 450);

        checkBox1 = new JCheckBox("Delivered Order", false);
        checkBox1.setBackground(Color.WHITE);
        checkBox1.setForeground(Color.BLACK);
        checkBox1.addActionListener(this);
        checkBox1.setBounds(315, 130, 250, 45);
        checkBox1.addActionListener(this);
        checkBox2 = new JCheckBox("Delivered Order", false);
        checkBox2.setBackground(Color.WHITE);
        checkBox2.setForeground(Color.BLACK);
        checkBox2.addActionListener(this);
        checkBox2.setBounds(315, 173, 250, 45);
        checkBox2.addActionListener(this);
        checkBox3 = new JCheckBox("Delivered Order", false);
        checkBox3.setBackground(Color.WHITE);
        checkBox3.setForeground(Color.BLACK);
        checkBox3.addActionListener(this);
        checkBox3.setBounds(315, 216, 250, 45);
        checkBox3.addActionListener(this);
        checkBox4 = new JCheckBox("Delivered Order", false);
        checkBox4.setBackground(Color.WHITE);
        checkBox4.setForeground(Color.BLACK);
        checkBox4.addActionListener(this);
        checkBox4.setBounds(315, 259, 250, 45);
        checkBox4.addActionListener(this);
        checkBox5 = new JCheckBox("Delivered Order", false);
        checkBox5.setBackground(Color.WHITE);
        checkBox5.setForeground(Color.BLACK);
        checkBox5.addActionListener(this);
        checkBox5.setBounds(315, 302, 250, 45);
        checkBox5.addActionListener(this);

        checkBox6 = new JCheckBox("Delivered Order", false);
        checkBox6.setBackground(Color.WHITE);
        checkBox6.setForeground(Color.BLACK);
        checkBox6.addActionListener(this);
        checkBox6.setBounds(315, 345, 250, 45);
        checkBox6.addActionListener(this);
        checkBox7 = new JCheckBox("Delivered Order", false);
        checkBox7.setBackground(Color.WHITE);
        checkBox7.setForeground(Color.BLACK);
        checkBox7.addActionListener(this);
        checkBox7.setBounds(315, 388, 250, 45);
        checkBox7.addActionListener(this);
        checkBox8 = new JCheckBox("Delivered Order", false);
        checkBox8.setBackground(Color.WHITE);
        checkBox8.setForeground(Color.BLACK);
        checkBox8.addActionListener(this);
        checkBox8.setBounds(315, 431, 250, 45);
        checkBox8.addActionListener(this);
        checkBox9 = new JCheckBox("Delivered Order", false);
        checkBox9.setBackground(Color.WHITE);
        checkBox9.setForeground(Color.BLACK);
        checkBox9.addActionListener(this);
        checkBox9.setBounds(315, 474, 250, 45);
        checkBox9.addActionListener(this);
        checkBox10 = new JCheckBox("Delivered Order", false);
        checkBox10.setBackground(Color.WHITE);
        checkBox10.setForeground(Color.BLACK);
        checkBox10.addActionListener(this);
        checkBox10.setBounds(315, 517, 250, 45);
        checkBox10.addActionListener(this);

        totalWeight = new JLabel();
        totalWeight.setFont(new Font("Times New Roman", Font.BOLD, 12));
        totalWeight.setForeground(Color.BLACK);
        totalWeight.setText("Total Weight: ");
        totalWeight.setBounds(20, 550, 100, 45);
        weight = new JLabel();
        weight.setFont(new Font("Times New Roman", Font.BOLD, 12));
        weight.setForeground(Color.BLACK);
        weight.setText("0 kg");
        weight.setBounds(215, 550, 50, 45);
        checkWeight = new JButton("Check Weight");
        checkWeight.setBounds(170, 620, 150, 30);
        checkWeight.setEnabled(true);
        checkWeight.addActionListener(this);


        ImageIcon img = new ImageIcon("ver.jpg");
        seperationV = new JLabel();
        seperationV.setIcon(img);
        seperationV.setBounds(480, 50, 2, 520);

        typeOfVehicle = new JLabel();
        typeOfVehicle.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        typeOfVehicle.setForeground(Color.BLACK);
        typeOfVehicle.setText("Type Of Vehicle: ");
        typeOfVehicle.setBounds(495, 60, 250, 45);
        vehicle = new JLabel();
        vehicle.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        vehicle.setForeground(Color.BLACK);
        vehicle.setText("Unknown");
        vehicle.setBounds(615, 60, 250, 45);

        addPackageHere = new JLabel();
        addPackageHere.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        addPackageHere.setForeground(Color.BLACK);
        addPackageHere.setText("Add A Package Here");
        addPackageHere.setBounds(495, 100, 250, 45);

        pktorderNumber = new JLabel();
        pktorderNumber.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        pktorderNumber.setForeground(Color.BLACK);
        pktorderNumber.setText("Client Number");
        pktorderNumber.setBounds(495, 150, 250, 45);
        tClientNumber = new JTextField(10);
        tClientNumber.setBounds(495, 180, 250, 22);
        tClientNumber.setHorizontalAlignment(JLabel.CENTER);

        pktreceiverName = new JLabel();
        pktreceiverName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        pktreceiverName.setForeground(Color.BLACK);
        pktreceiverName.setText("Receiver Name");
        pktreceiverName.setBounds(495, 230, 250, 45);
        treceiverName = new JTextField(10);
        treceiverName.setBounds(495, 260, 250, 22);
        treceiverName.setHorizontalAlignment(JLabel.CENTER);

        pktaddr = new JLabel();
        pktaddr.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        pktaddr.setForeground(Color.BLACK);
        pktaddr.setText("Receiver Address");
        pktaddr.setBounds(495, 310, 250, 45);
        taddr = new JTextField(10);
        taddr.setBounds(495, 340, 250, 22);
        taddr.setHorizontalAlignment(JLabel.CENTER);

        pktweight = new JLabel();
        pktweight.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        pktweight.setForeground(Color.BLACK);
        pktweight.setText("Package Weight");
        pktweight.setBounds(495, 390, 250, 45);
        tweight = new JTextField(10);
        tweight.setBounds(495, 420, 250, 22);
        tweight.setHorizontalAlignment(JLabel.CENTER);

        pktdeliverType = new JLabel();
        pktdeliverType.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        pktdeliverType.setForeground(Color.BLACK);
        pktdeliverType.setText("Deliver Type");
        pktdeliverType.setBounds(495, 470, 250, 45);
        tdeliverType = new JTextField(10);
        tdeliverType.setBounds(495, 500, 250, 22);
        tdeliverType.setHorizontalAlignment(JLabel.CENTER);

        pktPhone = new JLabel();
        pktPhone.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        pktPhone.setForeground(Color.BLACK);
        pktPhone.setText("Deliver Type");
        pktPhone.setBounds(495, 200, 250, 45);
        tPhone = new JTextField(10);
        tPhone.setBounds(495, 240, 250, 22);
        tPhone.setHorizontalAlignment(JLabel.CENTER);

        pktstatus = new JLabel();
        pktstatus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        pktstatus.setForeground(Color.BLACK);
        pktstatus.setText("Confirm Delivery");
        pktstatus.setBounds(495, 550, 250, 45);
        tstatus = new JTextField(10);
        tstatus.setBounds(495, 580, 250, 22);
        tstatus.setHorizontalAlignment(JLabel.CENTER);

        comfirm = new JButton("Delivered Package");
        comfirm.setBounds(330, 620, 150, 30);
        comfirm.setEnabled(true);
        comfirm.addActionListener(this);

        addPackage = new JButton("Add Package");
        addPackage.setBounds(495, 620, 150, 30);
        addPackage.setEnabled(true);
        addPackage.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
//        panel.add(hello);
//        panel.add(name);
        panel.add(viewOrder);
        panel.add(status);
        panel.add(packagePanel);
        panel.add(checkBox1);
        panel.add(checkBox2);
        panel.add(checkBox3);
        panel.add(checkBox4);
        panel.add(checkBox5);
        panel.add(checkBox6);
        panel.add(checkBox7);
        panel.add(checkBox8);
        panel.add(checkBox9);
        panel.add(checkBox10);
        panel.add(totalWeight);
        panel.add(weight);
        panel.add(checkWeight);

        panel.add(seperationV);
        panel.add(typeOfVehicle);
        panel.add(vehicle);
        panel.add(addPackageHere);
        panel.add(pktorderNumber);
        panel.add(tClientNumber);
        panel.add(pktreceiverName);
        panel.add(treceiverName);
        panel.add(pktaddr);
        panel.add(taddr);
        panel.add(pktweight);
        panel.add(tweight);
        panel.add(pktdeliverType);
        panel.add(tdeliverType);
        panel.add(pktstatus);
        panel.add(tstatus);
        panel.add(comfirm);
        panel.add(addPackage);
        panel.add(pktPhone);
        panel.add(tPhone);

        // Set properties of the JFrame
        setContentPane(panel);
        setSize(850, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Express Service Employee Page");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        // 2017 Quan Zhang, David Chen all rights reserved
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == comfirm) {
            if (checkBox1.isSelected()) {
                if (!o1t.equals("0000")) {
                    courier.updatePackage(Integer.parseInt(o1t));
                    repaint();
                }
            }
            if (checkBox2.isSelected()) {
                if (!o2t.equals("0000")) {
                    courier.updatePackage(Integer.parseInt(o2t));
                    repaint();
                }
            }
            if (checkBox3.isSelected()) {
                if (!o3t.equals("0000")) {
                    courier.updatePackage(Integer.parseInt(o3t));
                    repaint();
                }
            }
            if (checkBox4.isSelected()) {
                if (!o4t.equals("0000")) {
                    courier.updatePackage(Integer.parseInt(o4t));
                    repaint();
                }
            }
            if (checkBox5.isSelected()) {
                if (!o5t.equals("0000")) {
                    courier.updatePackage(Integer.parseInt(o5t));
                    repaint();
                }
            }
        }

        if(e.getSource() == addPackage){
            courier.placeOrder(Integer.parseInt(tClientNumber.getText()),tdeliverType.getText(),treceiverName.getText()
            ,taddr.getText(),tPhone.getText(),weight.getText(),tdeliverType.getText());
        }

        if(e.getSource() == checkWeight){
            int tW = courier.totalWeight();
            String stw = tweight.toString();
            totalWeight.setText(stw);
        }

    }
}
