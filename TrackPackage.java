import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class TrackPackage extends JFrame implements ActionListener {
    private JButton btntrack, btnconfirm;
    private JTextField tracknum;
    private JCheckBox arrived;
    private JLabel num, status, pktstatus;
    private String pktnum;
    private Tracker tracker;


    public TrackPackage(Connection con) {
        tracker = new Tracker(con);
        //set an image to a label
        ImageIcon img = new ImageIcon("15.jpg");
        JLabel Imglabel = new JLabel();
        Imglabel.setIcon(img);
        Imglabel.setBounds(5, 5, 200, 200);

        num = new JLabel();
        num.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        num.setForeground(Color.BLACK);
        num.setText("Tracking number, please");
        num.setBounds(220, 5, 250, 45);

        // Initialize JTextField
        tracknum = new JTextField(10);
        tracknum.setBounds(220, 50, 196, 22);
        tracknum.setHorizontalAlignment(JLabel.CENTER);

        btntrack = new JButton("Track");
        btntrack.setBounds(280, 72, 80, 30);
        btntrack.addActionListener(this);

        status = new JLabel();
        status.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        status.setForeground(Color.BLACK);
        status.setText("Status");
        status.setBounds(220, 95, 250, 45);

        pktstatus = new JLabel();
        pktstatus.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        pktstatus.setForeground(Color.BLUE);
        pktstatus.setText("Hello");
        pktstatus.setVisible(true);
        pktstatus.setBounds(280, 110, 250, 45);

        // create check-boxes
        arrived = new JCheckBox("Arrived", false);
        arrived.setBackground(Color.WHITE);
        arrived.setForeground(Color.BLACK);
        arrived.addActionListener(this);
        arrived.setBounds(210, 150, 250, 45);
        arrived.addActionListener(this);

        btnconfirm = new JButton("Confirm");
        btnconfirm.setBounds(280, 190, 80, 30);
        btnconfirm.addActionListener(this);


        // Declare and initialize JPanel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(Imglabel);
        panel.add(num);
        panel.add(tracknum);
        panel.add(btntrack);
        panel.add(status);
        panel.add(pktstatus);
        panel.add(arrived);
        panel.add(btnconfirm);


        // Set properties of the JFrame
        setContentPane(panel);
        setSize(450, 250);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Tracking");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        // 2017 Quan Zhang, David Chen all rights reserved
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pktnum = tracknum.getText();

        if(e.getSource() == btntrack) {
            String status = tracker.track(pktnum);
            pktstatus.setText(status);
        }
        if(e.getSource() == btnconfirm) {
            if (arrived.isSelected()) {
                JOptionPane.showMessageDialog(null, "Haha good, right?", "JButton",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
