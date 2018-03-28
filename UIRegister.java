import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.plaf.SeparatorUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import java.text.DecimalFormat;
import java.awt.Insets;
import java.awt.event.*;

public class UIRegister extends JFrame implements ActionListener {
    private JLabel seperationV;
    private JLabel title, login, name, cdtcard, cvv, month, year, email, addr, phone, pwd, cpwd;
    private JTextField tlogin, tname, tcdtcard, tcvv, temail, taddr, tphone, tpwd, tcpwd;
    private JComboBox<String> cmonth, cyear;
    private JButton register;
    private int monthSelected = 0;
    private int yearSelected = 0;

    private String slogin, sname, scdtcard, scvv, semail, saddr, sphone, spwd, scpwd;
    private Boolean checkAll = false;


    public static void main(String[] args) {
        new UIRegister();
    }

    public UIRegister() {
        title = new JLabel();
        title.setFont(new Font("Times New Roman", Font.BOLD, 16));
        title.setForeground(Color.BLACK);
        title.setText("  Express Service Client Register");
        title.setBounds(20, 20, 250, 45);

        login = new JLabel();
        login.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        login.setForeground(Color.BLUE);
        login.setText("Please Create Your Login");
        login.setBounds(20, 50, 250, 45);
        tlogin = new JTextField(10);
        tlogin.setBounds(20, 80, 250, 22);
        tlogin.setHorizontalAlignment(JLabel.CENTER);


        name = new JLabel();
        name.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        name.setForeground(Color.BLUE);
        name.setText("Please Enter Your Name");
        name.setBounds(20, 100, 250, 45);
        tname = new JTextField(10);
        tname.setBounds(20, 130, 250, 22);
        tname.setHorizontalAlignment(JLabel.CENTER);

        cdtcard = new JLabel();
        cdtcard.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        cdtcard.setForeground(Color.blue);
        cdtcard.setText("Your Credit Card Please");
        cdtcard.setBounds(20, 150, 180, 45);
        tcdtcard = new JTextField(10);
        tcdtcard.setBounds(20, 180, 150, 22);
        tcdtcard.setHorizontalAlignment(JLabel.CENTER);

        cvv = new JLabel();
        cvv.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        cvv.setForeground(Color.blue);
        cvv.setText("CVV");
        cvv.setBounds(200, 150, 50, 45);
        tcvv = new JTextField(10);
        tcvv.setBounds(200, 180, 50, 22);
        tcvv.setHorizontalAlignment(JLabel.CENTER);

        month = new JLabel();
        month.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        month.setForeground(Color.blue);
        month.setText("Expiry Month");
        month.setBounds(20, 200, 100, 45);
        cmonth = new JComboBox<String>();
        cmonth.addItem("January");
        cmonth.addItem("February");
        cmonth.addItem("March");
        cmonth.addItem("April");
        cmonth.addItem("May");
        cmonth.addItem("June");
        cmonth.addItem("July");
        cmonth.addItem("August");
        cmonth.addItem("September");
        cmonth.addItem("October");
        cmonth.addItem("November");
        cmonth.addItem("December");
        cmonth.setBackground(Color.WHITE);
        cmonth.setForeground(Color.BLUE);
        cmonth.setBounds(20, 230, 100, 45);
        cmonth.addActionListener(this);


        year = new JLabel();
        year.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        year.setForeground(Color.blue);
        year.setText("Expiry Year");
        year.setBounds(120, 200, 100, 45);
        cyear = new JComboBox<String>();
        cyear.addItem("2018");
        cyear.addItem("2019");
        cyear.addItem("2020");
        cyear.addItem("2021");
        cyear.addItem("2022");
        cyear.addItem("2023");
        cyear.addItem("2024");
        cyear.addItem("2025");
        cyear.addItem("2026");
        cyear.addItem("2027");
        cyear.addItem("2028");
        cyear.setBackground(Color.WHITE);
        cyear.setForeground(Color.BLUE);
        cyear.setBounds(120, 230, 100, 45);
        cyear.addActionListener(this);

        email = new JLabel();
        email.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        email.setForeground(Color.blue);
        email.setText("Please Enter Your Email");
        email.setBounds(300, 50, 250, 45);
        temail = new JTextField(10);
        temail.setBounds(300, 80, 250, 22);
        temail.setHorizontalAlignment(JLabel.CENTER);


        addr = new JLabel();
        addr.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        addr.setForeground(Color.blue);
        addr.setText("Please Enter Your Address");
        addr.setBounds(300, 90, 250, 45);
        taddr = new JTextField(10);
        taddr.setBounds(300, 120, 250, 22);
        taddr.setHorizontalAlignment(JLabel.CENTER);


        phone = new JLabel();
        phone.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        phone.setForeground(Color.blue);
        phone.setText("Please Enter Your Phone");
        phone.setBounds(300, 130, 250, 45);
        tphone = new JTextField(10);
        tphone.setBounds(300, 160, 250, 22);
        tphone.setHorizontalAlignment(JLabel.CENTER);

        pwd = new JLabel();
        pwd.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        pwd.setForeground(Color.blue);
        pwd.setText("Please Create Your Password");
        pwd.setBounds(300, 170, 250, 45);
        tpwd = new JTextField(10);
        tpwd.setBounds(300, 200, 250, 22);
        tpwd.setHorizontalAlignment(JLabel.CENTER);

        cpwd = new JLabel();
        cpwd.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        cpwd.setForeground(Color.blue);
        cpwd.setText("Confirm Your Password");
        cpwd.setBounds(300, 210, 250, 45);
        tcpwd = new JTextField(10);
        tcpwd.setBounds(300, 240, 250, 22);
        tcpwd.setHorizontalAlignment(JLabel.CENTER);

        ImageIcon img = new ImageIcon("ver.jpg");
        seperationV = new JLabel();
        seperationV.setIcon(img);
        seperationV.setBounds(280, 50, 2, 220);

        register = new JButton("Register Now");
        register.setBounds(240, 310, 80, 30);
        register.setEnabled(checkAll);
        register.addActionListener(this);

        // Declare and initialize JPanel
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.add(title);
        panel.add(login);
        panel.add(name);
        panel.add(cdtcard);
        panel.add(cvv);
        panel.add(month);
        panel.add(year);
        panel.add(email);
        panel.add(addr);
        panel.add(phone);
        panel.add(pwd);
        panel.add(cpwd);

        panel.add(tlogin);
        panel.add(tname);
        panel.add(tcdtcard);
        panel.add(tcvv);
        panel.add(cmonth);
        panel.add(cyear);
        panel.add(temail);
        panel.add(taddr);
        panel.add(tphone);
        panel.add(tpwd);
        panel.add(tcpwd);

        panel.add(cmonth);
        panel.add(cyear);
        panel.add(seperationV);
        panel.add(register);

        // Set properties of the JFrame
        setContentPane(panel);
        setSize(570, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Welcome");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        // 2017 Quan Zhang, David Chen all rights reserved

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        slogin = tlogin.getText();
        sname = tname.getText();
        scdtcard = tcdtcard.getText();
        scvv = tcvv.getText();
        semail = temail.getText();
        saddr = taddr.getText();
        sphone = tphone.getText();
        spwd = tpwd.getText();
        scpwd = tcpwd.getText();


        if (e.getSource() == cmonth) {
            if (cmonth.getSelectedIndex() == 0) {
                monthSelected = 1;
            } else if (cmonth.getSelectedIndex() == 1) {
                monthSelected = 2;
            } else if (cmonth.getSelectedIndex() == 2) {
                monthSelected = 3;
            } else if (cmonth.getSelectedIndex() == 3) {
                monthSelected = 4;
            } else if (cmonth.getSelectedIndex() == 4) {
                monthSelected = 5;
            } else if (cmonth.getSelectedIndex() == 5) {
                monthSelected = 6;
            } else if (cmonth.getSelectedIndex() == 6) {
                monthSelected = 7;
            } else if (cmonth.getSelectedIndex() == 7) {
                monthSelected = 8;
            } else if (cmonth.getSelectedIndex() == 8) {
                monthSelected = 9;
            } else if (cmonth.getSelectedIndex() == 9) {
                monthSelected = 10;
            } else if (cmonth.getSelectedIndex() == 10) {
                monthSelected = 11;
            } else if (cmonth.getSelectedIndex() == 11) {
                monthSelected = 12;
            }
        }

        if (e.getSource() == cyear) {
            if (cyear.getSelectedIndex() == 0) {
                yearSelected = 2018;
            } else if (cyear.getSelectedIndex() == 1) {
                yearSelected = 2019;
            } else if (cyear.getSelectedIndex() == 2) {
                yearSelected = 2021;
            } else if (cyear.getSelectedIndex() == 3) {
                yearSelected = 2022;
            } else if (cyear.getSelectedIndex() == 4) {
                yearSelected = 2023;
            } else if (cyear.getSelectedIndex() == 5) {
                yearSelected = 2024;
            } else if (cyear.getSelectedIndex() == 6) {
                yearSelected = 2025;
            } else if (cyear.getSelectedIndex() == 7) {
                yearSelected = 2026;
            } else if (cyear.getSelectedIndex() == 8) {
                yearSelected = 2027;
            } else if (cyear.getSelectedIndex() == 9) {
                yearSelected = 2028;
            }
        }

    }

    public Boolean CheckAllBeforeRegister(){
        if (spwd == scpwd){
            return true;
        } else {
            return false;
        }
    }

}
