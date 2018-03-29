
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;

public class UIClientService extends JFrame implements ActionListener {
    private JLabel hello, name;
    private JLabel viewOrder, status, changeCard, changeAddr,changePhone, month, year, receiver;
    private JLabel l1, l2, l3, l4, l5;
    private JLabel o1, o2, o3, o4, o5;
    private JLabel s1, s2, s3, s4, s5;
    private JLabel r1, r2, r3, r4, r5;
    private JCheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5;

    private JTextField ccdtcard, caddr, ccvv, cphone;
    private JComboBox<String> cmonth, cyear;
    private JButton cdtCard, delete, btnCard, btnAddr, btnPhone;
    private Connection con;

    public UIClientService(Connection con) {
        this.con = con;
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
        status.setBounds(200, 60, 50, 45);

        receiver = new JLabel();
        receiver.setFont(new Font("Times New Roman", Font.BOLD, 12));
        receiver.setForeground(Color.BLACK);
        receiver.setText("Receiver");
        receiver.setBounds(260, 60, 250, 45);

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

        r1 = new JLabel();
        r1.setFont(new Font("Magneto", Font.BOLD, 12));
        r1.setForeground(Color.BLACK);
        r1.setText("pending");
        r2 = new JLabel();
        r2.setFont(new Font("Magneto", Font.BOLD, 12));
        r2.setForeground(Color.BLACK);
        r2.setText("pending");
        r3 = new JLabel();
        r3.setFont(new Font("Magneto", Font.BOLD, 12));
        r3.setForeground(Color.BLACK);
        r3.setText("pending");
        r4 = new JLabel();
        r4.setFont(new Font("Magneto", Font.BOLD, 12));
        r4.setForeground(Color.BLACK);
        r4.setText("pending");
        r5 = new JLabel();
        r5.setFont(new Font("Magneto", Font.BOLD, 12));
        r5.setForeground(Color.BLACK);
        r5.setText("pending");


        JPanel packagePanel = new JPanel();
        packagePanel.setBorder(BorderFactory
                .createTitledBorder("Your Packages"));
        packagePanel.setLayout(new GridLayout(5, 4, 10, 5));
        packagePanel.add(l1);
        packagePanel.add(o1);
        packagePanel.add(s1);
        packagePanel.add(r1);

        packagePanel.add(l2);
        packagePanel.add(o2);
        packagePanel.add(s2);
        packagePanel.add(r2);

        packagePanel.add(l3);
        packagePanel.add(o3);
        packagePanel.add(s3);
        packagePanel.add(r3);

        packagePanel.add(l4);
        packagePanel.add(o4);
        packagePanel.add(s4);
        packagePanel.add(r4);

        packagePanel.add(l5);
        packagePanel.add(o5);
        packagePanel.add(s5);
        packagePanel.add(r5);

        packagePanel.setBackground(Color.WHITE);
        packagePanel.setBounds(20, 110, 320, 230);

        checkBox1 = new JCheckBox("Delete Order", false);
        checkBox1.setBackground(Color.WHITE);
        checkBox1.setForeground(Color.BLACK);
        checkBox1.addActionListener(this);
        checkBox1.setBounds(350, 130, 250, 45);
        checkBox1.addActionListener(this);
        checkBox2 = new JCheckBox("Delete Order", false);
        checkBox2.setBackground(Color.WHITE);
        checkBox2.setForeground(Color.BLACK);
        checkBox2.addActionListener(this);
        checkBox2.setBounds(350, 170, 250, 45);
        checkBox2.addActionListener(this);
        checkBox3 = new JCheckBox("Delete Order", false);
        checkBox3.setBackground(Color.WHITE);
        checkBox3.setForeground(Color.BLACK);
        checkBox3.addActionListener(this);
        checkBox3.setBounds(350, 210, 250, 45);
        checkBox3.addActionListener(this);
        checkBox4 = new JCheckBox("Delete Order", false);
        checkBox4.setBackground(Color.WHITE);
        checkBox4.setForeground(Color.BLACK);
        checkBox4.addActionListener(this);
        checkBox4.setBounds(350, 250, 250, 45);
        checkBox4.addActionListener(this);
        checkBox5 = new JCheckBox("Delete Order", false);
        checkBox5.setBackground(Color.WHITE);
        checkBox5.setForeground(Color.BLACK);
        checkBox5.addActionListener(this);
        checkBox5.setBounds(350, 290, 250, 45);
        checkBox5.addActionListener(this);


        changeCard = new JLabel();
        changeCard.setFont(new Font("Times New Roman", Font.BOLD, 12));
        changeCard.setForeground(Color.BLACK);
        changeCard.setText("Change Card");
        changeCard.setBounds(20, 350, 250, 45);

        ccdtcard = new JTextField(10);
        ccdtcard.setBounds(20, 390, 200, 22);
        ccdtcard.setHorizontalAlignment(JLabel.CENTER);

        ccvv = new JTextField(10);
        ccvv.setBounds(230, 390, 50, 22);
        ccvv.setHorizontalAlignment(JLabel.CENTER);

        month = new JLabel();
        month.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        month.setForeground(Color.blue);
        month.setText("Expiry Month");
        month.setBounds(20, 410, 100, 45);
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
        cmonth.setBounds(20, 430, 100, 45);
        cmonth.addActionListener(this);

        year = new JLabel();
        year.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        year.setForeground(Color.blue);
        year.setText("Expiry Year");
        year.setBounds(150, 410, 100, 45);
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
        cyear.setBounds(150, 430, 100, 45);
        cyear.addActionListener(this);

        cdtCard = new JButton("Delete Card");
        cdtCard.setForeground(Color.RED);
        cdtCard.setBounds(345, 383, 120, 30);
        cdtCard.setEnabled(true);
        cdtCard.addActionListener(this);

        changeAddr = new JLabel();
        changeAddr.setFont(new Font("Times New Roman", Font.BOLD, 12));
        changeAddr.setForeground(Color.BLACK);
        changeAddr.setText("Change Address");
        changeAddr.setBounds(20, 460, 250, 45);

        caddr = new JTextField(10);
        caddr.setBounds(20, 500, 280, 22);
        caddr.setHorizontalAlignment(JLabel.CENTER);

        changePhone = new JLabel();
        changePhone.setFont(new Font("Times New Roman", Font.BOLD, 12));
        changePhone.setForeground(Color.BLACK);
        changePhone.setText("Change Phone");
        changePhone.setBounds(20, 530, 250, 45);

        cphone = new JTextField(10);
        cphone.setBounds(20, 570, 280, 22);
        cphone.setHorizontalAlignment(JLabel.CENTER);

        delete = new JButton("Delete Account");
        delete.setForeground(Color.RED);
        delete.setBounds(20, 620, 120, 30);
        delete.setEnabled(true);
        delete.addActionListener(this);

        btnCard = new JButton("Change Card");
        btnCard.setForeground(Color.BLACK);
        btnCard.setBounds(190, 350, 120, 30);
        btnCard.setEnabled(true);
        btnCard.addActionListener(this);

        btnAddr = new JButton("Change Address");
        btnAddr.setForeground(Color.BLACK);
        btnAddr.setBounds(190, 460, 140, 30);
        btnAddr.setEnabled(true);
        btnAddr.addActionListener(this);

        btnPhone = new JButton("Change Phone");
        btnPhone.setForeground(Color.BLACK);
        btnPhone.setBounds(190, 530, 120, 30);
        btnPhone.setEnabled(true);
        btnPhone.addActionListener(this);

        // Declare and initialize JPanel
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
        panel.add(changeCard);
        panel.add(ccdtcard);
        panel.add(ccvv);
        panel.add(month);
        panel.add(year);
        panel.add(cmonth);
        panel.add(cyear);
        panel.add(cdtCard);
        panel.add(changeAddr);
        panel.add(caddr);
        panel.add(changePhone);
        panel.add(cphone);
        panel.add(delete);
        panel.add(btnCard);
        panel.add(btnPhone);
        panel.add(btnAddr);
        panel.add(receiver);

        // Set properties of the JFrame
        setContentPane(panel);
        setSize(560, 700);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Express Service Client Register");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        // 2017 Quan Zhang, David Chen all rights reserved
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
}
