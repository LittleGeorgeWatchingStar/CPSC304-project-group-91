import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.sql.Connection;

public class Main extends JFrame implements ActionListener{
    private DBDriver dbDriver;
    private Connection connection;
    private JButton employee, client, tracking, btnexit;
    public JLabel l1, l4;
    private UIbasic EUIlogin;
    private UIClient UIlogin;
    private TrackPackage trackpkg;


    public static void main(String[] args) {
        new Main();
    }

    public Main(){
        dbDriver = new DBDriver();
        if(!dbDriver.connect()){
            System.out.println("not connected");
            System.exit(0);
        }
        connection = dbDriver.connection;
        l1 = new JLabel();
        l1.setFont(new Font("Magneto", Font.PLAIN, 28));
        l1.setForeground(Color.RED);
        l1.setText("SF Express Database");
        l1.setBounds(330, 20, 350, 100);

        btnexit = new JButton("Exit");
        btnexit.setBounds(680, 63, 30, 20);
        btnexit.addActionListener(this);

        ImageIcon hearts = new ImageIcon("18.jpg");
        l4 = new JLabel();
        l4.setIcon(hearts);
        l4.setBounds(210, 120, 500, 200);


        //submit names button
        employee = new JButton("Employee");
        employee.setOpaque(true);
        employee.setBackground(Color.PINK);
        employee.setBounds(210, 360, 150, 40);
        employee.addActionListener(this);

        //client names button
        client = new JButton("Client");
        client.setOpaque(true);
        client.setBackground(Color.PINK);
        client.setBounds(380, 360, 150, 40);
        client.addActionListener(this);

        //tracking button
        tracking = new JButton("Tracking");
        tracking.setOpaque(true);
        tracking.setBackground(Color.PINK);
        tracking.setBounds(550, 360, 150, 40);
        tracking.addActionListener(this);


        // Declare and initialize JPanel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(l1);

        panel.add(l4);
        panel.add(employee);
        panel.add(client);
        panel.add(tracking);
        panel.add(btnexit);

        // Set properties of the JFrame
        setContentPane(panel);
        setSize(900, 480);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("SF Express");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        // 2017 Quan Zhang, David Chen all rights reserved
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //check if there are inputs
        if (e.getSource() == btnexit) {
            JOptionPane.showMessageDialog(null, "Thank you, see you again", "JButton",
                    JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
            // 2017 Quan Zhang, David Chen all rights reserved
        } else if (e.getSource() == tracking) {
            trackpkg = new TrackPackage(connection);
        } else if (e.getSource() == employee) {
            EUIlogin = new UIbasic(connection);
        } else if (e.getSource() == client) {
            UIlogin = new UIClient(connection);
        }

    }
}
