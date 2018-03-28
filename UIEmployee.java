import javax.swing.*;

import java.awt.*;

import java.sql.Connection;
import java.awt.event.*;
import java.time.Month;
import java.time.Year;
import java.util.Calendar;
public class UIEmployee extends JFrame implements ActionListener  {
    private JLabel hello, name;
    private JLabel viewOrder, status, totalWeight, weight, typeOfVehicle, vehicle;
    private JLabel addPackageHere, pktorderNumber, pktreceiverName, pktaddr, pktweight, pktdeliverType, pktstatus;
    private JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
    private JLabel o1, o2, o3, o4, o5, o6, o7, o8, o9, o10;
    private JLabel s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;
    private JCheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9, checkBox10;
    private JButton addPackage, checkWeight, comfirm;
    private JTextField torderNumber, treceiverName, taddr, tweight, tdeliverType, tstatus;
    private JLabel seperationV;

    public UIEmployee() {
        hello = new JLabel();
        hello.setFont(new Font("Times New Roman", Font.BOLD, 15));
        hello.setForeground(Color.BLACK);
        hello.setText("Hello");
        hello.setBounds(20, 20, 50, 45);

        name = new JLabel();
        name.setFont(new Font("Times New Roman", Font.BOLD, 15));
        name.setForeground(Color.BLACK);
        //TODO
        // name get from database
        name.setText("Joe");
        name.setBounds(60, 20, 150, 45);


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

        l1 = new JLabel();
        l1.setFont(new Font("Magneto", Font.BOLD, 12));
        l1.setForeground(Color.BLACK);
        l1.setText("1");
        l2 = new JLabel();
        l2.setFont(new Font("Magneto", Font.BOLD, 12));
        l2.setForeground(Color.BLACK);
        l2.setText("2");
        l3 = new JLabel();
        l3.setFont(new Font("Magneto", Font.BOLD, 12));
        l3.setForeground(Color.BLACK);
        l3.setText("3");
        l4 = new JLabel();
        l4.setFont(new Font("Magneto", Font.BOLD, 12));
        l4.setForeground(Color.BLACK);
        l4.setText("4");
        l5 = new JLabel();
        l5.setFont(new Font("Magneto", Font.BOLD, 12));
        l5.setForeground(Color.BLACK);
        l5.setText("5");
        l6 = new JLabel();
        l6.setFont(new Font("Magneto", Font.BOLD, 12));
        l6.setForeground(Color.BLACK);
        l6.setText("6");
        l7 = new JLabel();
        l7.setFont(new Font("Magneto", Font.BOLD, 12));
        l7.setForeground(Color.BLACK);
        l7.setText("7");
        l8 = new JLabel();
        l8.setFont(new Font("Magneto", Font.BOLD, 12));
        l8.setForeground(Color.BLACK);
        l8.setText("8");
        l9 = new JLabel();
        l9.setFont(new Font("Magneto", Font.BOLD, 12));
        l9.setForeground(Color.BLACK);
        l9.setText("9");
        l10 = new JLabel();
        l10.setFont(new Font("Magneto", Font.BOLD, 12));
        l10.setForeground(Color.BLACK);
        l10.setText("10");


        o1 = new JLabel();
        o1.setFont(new Font("Magneto", Font.BOLD, 12));
        o1.setForeground(Color.BLACK);
        o1.setText("0000");
        o2 = new JLabel();
        o2.setFont(new Font("Magneto", Font.BOLD, 12));
        o2.setForeground(Color.BLACK);
        o2.setText("0000");
        o3 = new JLabel();
        o3.setFont(new Font("Magneto", Font.BOLD, 12));
        o3.setForeground(Color.BLACK);
        o3.setText("0000");
        o4 = new JLabel();
        o4.setFont(new Font("Magneto", Font.BOLD, 12));
        o4.setForeground(Color.BLACK);
        o4.setText("0000");
        o5 = new JLabel();
        o5.setFont(new Font("Magneto", Font.BOLD, 12));
        o5.setForeground(Color.BLACK);
        o5.setText("0000");
        o6 = new JLabel();
        o6.setFont(new Font("Magneto", Font.BOLD, 12));
        o6.setForeground(Color.BLACK);
        o6.setText("0000");
        o7 = new JLabel();
        o7.setFont(new Font("Magneto", Font.BOLD, 12));
        o7.setForeground(Color.BLACK);
        o7.setText("0000");
        o8 = new JLabel();
        o8.setFont(new Font("Magneto", Font.BOLD, 12));
        o8.setForeground(Color.BLACK);
        o8.setText("0000");
        o9 = new JLabel();
        o9.setFont(new Font("Magneto", Font.BOLD, 12));
        o9.setForeground(Color.BLACK);
        o9.setText("0000");
        o10 = new JLabel();
        o10.setFont(new Font("Magneto", Font.BOLD, 12));
        o10.setForeground(Color.BLACK);
        o10.setText("0000");

        s1 = new JLabel();
        s1.setFont(new Font("Magneto", Font.BOLD, 12));
        s1.setForeground(Color.BLACK);
        s1.setText("pending");
        s2 = new JLabel();
        s2.setFont(new Font("Magneto", Font.BOLD, 12));
        s2.setForeground(Color.BLACK);
        s2.setText("pending");
        s3 = new JLabel();
        s3.setFont(new Font("Magneto", Font.BOLD, 12));
        s3.setForeground(Color.BLACK);
        s3.setText("pending");
        s4 = new JLabel();
        s4.setFont(new Font("Magneto", Font.BOLD, 12));
        s4.setForeground(Color.BLACK);
        s4.setText("pending");
        s5 = new JLabel();
        s5.setFont(new Font("Magneto", Font.BOLD, 12));
        s5.setForeground(Color.BLACK);
        s5.setText("pending");
        s6 = new JLabel();
        s6.setFont(new Font("Magneto", Font.BOLD, 12));
        s6.setForeground(Color.BLACK);
        s6.setText("pending");
        s7 = new JLabel();
        s7.setFont(new Font("Magneto", Font.BOLD, 12));
        s7.setForeground(Color.BLACK);
        s7.setText("pending");
        s8 = new JLabel();
        s8.setFont(new Font("Magneto", Font.BOLD, 12));
        s8.setForeground(Color.BLACK);
        s8.setText("pending");
        s9 = new JLabel();
        s9.setFont(new Font("Magneto", Font.BOLD, 12));
        s9.setForeground(Color.BLACK);
        s9.setText("pending");
        s10 = new JLabel();
        s10.setFont(new Font("Magneto", Font.BOLD, 12));
        s10.setForeground(Color.BLACK);
        s10.setText("pending");


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
        packagePanel.add(l6);
        packagePanel.add(o6);
        packagePanel.add(s6);
        packagePanel.add(l7);
        packagePanel.add(o7);
        packagePanel.add(s7);
        packagePanel.add(l8);
        packagePanel.add(o8);
        packagePanel.add(s8);
        packagePanel.add(l9);
        packagePanel.add(o9);
        packagePanel.add(s9);
        packagePanel.add(l10);
        packagePanel.add(o10);
        packagePanel.add(s10);

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
        seperationV.setBounds(480, 50, 2, 500);

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
        pktorderNumber.setText("Order Number");
        pktorderNumber.setBounds(495, 150, 250, 45);
        torderNumber = new JTextField(10);
        torderNumber.setBounds(495, 180, 250, 22);
        torderNumber.setHorizontalAlignment(JLabel.CENTER);

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

        pktstatus = new JLabel();
        pktstatus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        pktstatus.setForeground(Color.BLACK);
        pktstatus.setText("Confirm Delivery");
        pktstatus.setBounds(495, 550, 250, 45);
        tstatus = new JTextField(10);
        tstatus.setBounds(495, 580, 250, 22);
        tstatus.setHorizontalAlignment(JLabel.CENTER);

        comfirm = new JButton("Add Package");
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
        panel.add(hello);
        panel.add(name);
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
        panel.add(torderNumber);
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

    }
}
