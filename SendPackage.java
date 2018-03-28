
import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import java.text.DecimalFormat;
import java.awt.Insets;
import java.awt.event.*;

public class SendPackage extends JFrame implements ActionListener, ItemListener,
        WindowListener {
    private DecimalFormat df = new DecimalFormat("$ 0.00");
    private JButton calculate, clear, checkout, exit;
    private JComboBox<String> colors, memory, harddrive, battery, cpu;
    private JCheckBox screen, cool, bose, retina, keys;
    private JRadioButton w12, w14, M12, M13, M14;
    private ButtonGroup group1;
    private JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14,
            l15, l16, l17, l18, l19, l20, l21, l22, l23;
    private double base = 0, reference1 = 0, reference2 = 0, reference3 = 0,
            subtotalp = 0, tax = 0, grandtotal = 0, totalp = 0, acc = 1,
            pacc = 0, color = 0, pmemory = 0, pcpu = 0, pharddrive = 0,
            pbattery = 0;
    private String colorchoice = "with yellow body",
            cpuchoice = "and A4, 4 cores with 3.0 GHz",
            memorychoice = "and Kingston 8GB Memory",
            harddrivechoice = "and WD 1TB Grand Built-in Harddrive",
            batterychoice = "and 1 Built-in S6 Battery",
            screenchoice = "with normal screen",
            coolchoice = "and standard cooling system",
            bosechoice = "and Pioneer Stereo",
            retinachoice = "and standard E10 Fingerprint scanner",
            keyschoice = "", basechoice = "", sumchoice = "";

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new SendPackage();
    }

    public SendPackage() {
        // create title label for main panel
        ImageIcon img = new ImageIcon("BEE.png");
        l1 = new JLabel();
        l1.setIcon(img);

        // create image label for products
        ImageIcon imgproduct = new ImageIcon("2020 Yellow.jpg");
        l2 = new JLabel();
        l2.setIcon(imgproduct);

        // create image label for ways of payment
        ImageIcon imgvisa = new ImageIcon("VISA.png");
        l3 = new JLabel();
        l3.setIcon(imgvisa);

        // create label for slogan
        l4 = new JLabel();
        l4.setFont(new Font("Broadway", Font.ITALIC, 22));
        l4.setForeground(Color.RED);
        l4.setText("The Best LemonCake Ever");

        // create radio buttons for sizes of lap-top
        w12 = new JRadioButton("  12'' LemonCake with Windows 10");
        w12.setBackground(Color.BLACK);
        w12.setForeground(Color.WHITE);
        w12.addItemListener(this);
        w12.addActionListener(this);

        w14 = new JRadioButton("  14'' LemonCake with Windows 10");
        w14.setBackground(Color.BLACK);
        w14.setForeground(Color.WHITE);
        w14.addItemListener(this);
        w14.addActionListener(this);

        M12 = new JRadioButton("  12'' LemonCake with MOS 3");
        M12.setBackground(Color.BLACK);
        M12.setForeground(Color.WHITE);
        M12.addItemListener(this);
        M12.addActionListener(this);

        M13 = new JRadioButton("  13'' LemonCake with MOS 3");
        M13.setBackground(Color.BLACK);
        M13.setForeground(Color.WHITE);
        M13.addItemListener(this);
        M13.addActionListener(this);

        M14 = new JRadioButton("  14'' LemonCake with MOS 3");
        M14.setBackground(Color.BLACK);
        M14.setForeground(Color.WHITE);
        M14.addItemListener(this);
        M14.addActionListener(this);

        // create radio button group for size of laptop
        group1 = new ButtonGroup();
        group1.add(w12);
        group1.add(w14);
        group1.add(M12);
        group1.add(M13);
        group1.add(M14);

        // create an inner panel for radio buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory
                .createTitledBorder("Pick A LemonCake"));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(w12);
        buttonPanel.add(w14);
        buttonPanel.add(M12);
        buttonPanel.add(M13);
        buttonPanel.add(M14);
        buttonPanel.setBackground(Color.BLACK);

        // create check-boxes
        screen = new JCheckBox(" MYJARVIS 8 removable screen ", false);
        screen.setBackground(Color.BLACK);
        screen.setForeground(Color.WHITE);
        screen.addActionListener(this);

        cool = new JCheckBox(" 2014 Superb Cooling ", false);
        cool.setBackground(Color.BLACK);
        cool.setForeground(Color.WHITE);
        cool.addActionListener(this);

        bose = new JCheckBox(" QC10 Bose Stereo ", false);
        bose.setBackground(Color.BLACK);
        bose.setForeground(Color.WHITE);
        bose.addActionListener(this);

        retina = new JCheckBox(" Eye Tribe 2014 Retinal Scanner", false);
        retina.setBackground(Color.BLACK);
        retina.setForeground(Color.WHITE);
        retina.addActionListener(this);

        keys = new JCheckBox(" Illuminating keyboard and touchpad ", false);
        keys.setBackground(Color.BLACK);
        keys.setForeground(Color.WHITE);
        keys.addActionListener(this);

        // create an inner panel for radio buttons
        JPanel boxPanel = new JPanel();
        boxPanel.setBorder(BorderFactory.createTitledBorder("Substitutions"));
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));
        boxPanel.add(screen);
        boxPanel.add(cool);
        boxPanel.add(bose);
        boxPanel.add(retina);
        boxPanel.add(keys);
        boxPanel.setBackground(Color.BLACK);

        // labels in the inner panel for combo boxes
        l5 = new JLabel();
        l5.setFont(new Font("Calibri", Font.PLAIN, 15));
        l5.setForeground(new Color((int) (0), (int) (255), (int) (255)));
        l5.setText(" Customize a finish");

        l6 = new JLabel();
        l6.setFont(new Font("Calibri", Font.PLAIN, 15));
        l6.setForeground(new Color((int) (0), (int) (255), (int) (255)));
        l6.setText(" Choose your CPU");

        l7 = new JLabel();
        l7.setFont(new Font("Calibri", Font.PLAIN, 15));
        l7.setForeground(new Color((int) (0), (int) (255), (int) (255)));
        l7.setText(" Choose your memory");

        l8 = new JLabel();
        l8.setFont(new Font("Calibri", Font.PLAIN, 15));
        l8.setForeground(new Color((int) (0), (int) (255), (int) (255)));
        l8.setText(" Choose your harddrive");

        l9 = new JLabel();
        l9.setFont(new Font("Calibri", Font.PLAIN, 15));
        l9.setForeground(new Color((int) (0), (int) (255), (int) (255)));
        l9.setText(" Choose your endurance");

        // set up combo-boxes
        colors = new JComboBox<String>();
        colors.addItem("  Lemon Yellow");
        colors.addItem("  Cute Pink");
        colors.addItem("  Ruby Red");
        colors.addItem("  Vital Green");
        colors.addItem("  Noble Blue");
        colors.addItem("  Pearl White");
        colors.addItem("  Elegant Black");
        colors.setBackground(Color.BLACK);
        colors.setForeground(Color.WHITE);
        colors.addActionListener(this);

        cpu = new JComboBox<String>();
        cpu.addItem("  A4, 4 cores with 3.0 GHz");
        cpu.addItem("  A6, 4 cores with 3.6 GHZ");
        cpu.setBackground(Color.BLACK);
        cpu.setForeground(Color.WHITE);
        cpu.addActionListener(this);

        memory = new JComboBox<String>();
        memory.addItem("  Kingston 8GB Memory");
        memory.addItem("  Kingston 16GB Memory");
        memory.addItem("  Kingston 32GB Memory");
        memory.setBackground(Color.BLACK);
        memory.setForeground(Color.WHITE);
        memory.addActionListener(this);

        harddrive = new JComboBox<String>();
        harddrive.addItem("  WD 1TB Grand Built-in Harddrive");
        harddrive.addItem("  WD 2TB Grand Built-in Harddrive");
        harddrive.addItem("  WD 4TB Grand Built-in Harddrive");
        harddrive.setBackground(Color.BLACK);
        harddrive.setForeground(Color.WHITE);
        harddrive.addActionListener(this);

        battery = new JComboBox<String>();
        battery.addItem("  1 Built-in S6 Battery");
        battery.addItem("  2 Built-in S6 Batteries");
        battery.setBackground(Color.BLACK);
        battery.setForeground(Color.WHITE);
        battery.addActionListener(this);

        // create a panel for combo boxes
        JPanel comboxPanel = new JPanel();
        comboxPanel.setBorder(BorderFactory
                .createTitledBorder("Customize Your LemonCake"));
        comboxPanel.setLayout(new GridLayout(5, 2, 10, 0));
        comboxPanel.add(l5);
        comboxPanel.add(colors);
        comboxPanel.add(l6);
        comboxPanel.add(cpu);
        comboxPanel.add(l7);
        comboxPanel.add(memory);
        comboxPanel.add(l8);
        comboxPanel.add(harddrive);
        comboxPanel.add(l9);
        comboxPanel.add(battery);
        comboxPanel.setBackground(Color.BLACK);

        // create price tags
        l10 = new JLabel();
        l10.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        l10.setBorder(BorderFactory.createLineBorder(Color.RED));
        l10.setHorizontalAlignment(JLabel.CENTER);
        l10.setForeground(Color.WHITE);
        l10.setText("$ 0.00");
        l10.setPreferredSize(new Dimension(100, 20));
        l10.setMinimumSize(new Dimension(100, 20));

        l11 = new JLabel();
        l11.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        l11.setBorder(BorderFactory.createLineBorder(Color.RED));
        l11.setHorizontalAlignment(JLabel.CENTER);
        l11.setForeground(Color.WHITE);
        l11.setText("$ 0.00");
        l11.setPreferredSize(new Dimension(100, 20));
        l11.setMinimumSize(new Dimension(100, 20));

        l12 = new JLabel();
        l12.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        l12.setBorder(BorderFactory.createLineBorder(Color.RED));
        l12.setHorizontalAlignment(JLabel.CENTER);
        l12.setForeground(Color.WHITE);
        l12.setText("$ 0.00");
        l12.setPreferredSize(new Dimension(100, 20));
        l12.setMinimumSize(new Dimension(100, 20));

        l13 = new JLabel();
        l13.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        l13.setForeground(new Color((int) (255), (int) (128), (int) (192)));
        l13.setText("   Subtotal   ");

        l14 = new JLabel();
        l14.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        l14.setForeground(new Color((int) (255), (int) (128), (int) (192)));
        l14.setText("   Discount   ");

        l15 = new JLabel();
        l15.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        l15.setForeground(new Color((int) (255), (int) (128), (int) (192)));
        l15.setText("   HST         ");

        l16 = new JLabel();
        l16.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        l16.setForeground(new Color((int) (255), (int) (128), (int) (192)));
        l16.setText("   Grand Total ");

        l17 = new JLabel();
        l17.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        l17.setOpaque(true);
        l17.setBackground(new Color((int) (0), (int) (255), (int) (255)));
        l17.setHorizontalAlignment(JLabel.CENTER);
        l17.setForeground(Color.WHITE);
        l17.setText(df.format(subtotalp));

        l18 = new JLabel();
        l18.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        l18.setOpaque(true);
        l18.setBackground(new Color((int) (0), (int) (255), (int) (255)));
        l18.setHorizontalAlignment(JLabel.CENTER);
        l18.setForeground(Color.WHITE);
        l18.setText("$ 0.00");

        l19 = new JLabel();
        l19.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        l19.setOpaque(true);
        l19.setBackground(new Color((int) (0), (int) (255), (int) (255)));
        l19.setHorizontalAlignment(JLabel.CENTER);
        l19.setForeground(Color.WHITE);
        l19.setText("$ 0.00");

        l20 = new JLabel();
        l20.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        l20.setOpaque(true);
        l20.setBackground(new Color((int) (0), (int) (255), (int) (255)));
        l20.setHorizontalAlignment(JLabel.CENTER);
        l20.setForeground(Color.WHITE);
        l20.setText("$ 0.00");

        // create a label to remind the free substitution
        l21 = new JLabel();
        l21.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        l21.setOpaque(true);
        l21.setBackground(Color.BLACK);
        l21.setForeground(Color.BLUE);
        l21.setText("    The First Substitution Is FREE!");

        // create a label to remind customers of features
        l22 = new JLabel();
        l22.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        l22.setOpaque(true);
        l22.setBackground(Color.BLACK);
        l22.setForeground(Color.WHITE);
        l22.setText("    Please Notice: The Standard LemonCake Comes With Pioneer Stereo, Built-in Camera And BEE's One Year Limited Warranty");

        // buy now with $99 CHINESE NEW YEAR DISCOUNT
        l23 = new JLabel();
        l23.setFont(new Font("Times New Roman", Font.PLAIN, 19));
        l23.setOpaque(true);
        l23.setBackground(Color.BLACK);
        l23.setForeground(Color.RED);
        l23.setText("BUY NOW WITH $ 99 CHINESE NEW YEAR DISCOUNT FOR PURCHASE MORE THAN $ 3600~");

        // set up a panel for price tags
        JPanel pricepanel1 = new JPanel();
        pricepanel1.setLayout(new GridLayout(4, 2, 2, 6));
        pricepanel1.add(l13);
        pricepanel1.add(l17);
        pricepanel1.add(l14);
        pricepanel1.add(l18);
        pricepanel1.add(l15);
        pricepanel1.add(l19);
        pricepanel1.add(l16);
        pricepanel1.add(l20);
        pricepanel1.setBackground(Color.BLACK);

        // create buttons for main panel
        Dimension d = new Dimension(210, 30);
        calculate = new JButton("CALCULATION");
        calculate.setPreferredSize(d);
        calculate.setBackground(Color.BLACK);
        calculate.setForeground(Color.WHITE);
        calculate.addActionListener(this);

        clear = new JButton("CLEAR");
        clear.setPreferredSize(d);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);

        checkout = new JButton("CHECKOUT");
        checkout.setPreferredSize(d);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setEnabled(false);
        checkout.addActionListener(this);

        exit = new JButton("EXIT");
        exit.setPreferredSize(d);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);

        // set a panel for buttons of main panel
        JPanel gridpanel = new JPanel();
        gridpanel.setLayout(new GridLayout(4, 1, 2, 6));
        gridpanel.add(calculate);
        gridpanel.add(clear);
        gridpanel.add(checkout);
        gridpanel.add(exit);
        gridpanel.setBackground(Color.BLACK);

        // set constraints
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        gc.gridwidth = 2;
        gc.gridheight = 1;
        gc.weightx = 100.0;
        gc.weighty = 0.0;
        gc.insets = new Insets(2, 2, 2, 2);
        gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.NONE;

        // adding components to the main panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.add(l1, gc);
        gc.gridy = 1;
        gc.weighty = 100.0;
        gc.anchor = GridBagConstraints.NORTH;
        panel.add(l4, gc);
        gc.gridx = 2;
        gc.gridy = 0;
        gc.gridwidth = 2;
        gc.anchor = GridBagConstraints.SOUTH;
        panel.add(l2, gc);
        gc.gridx = 0;
        gc.gridy = 2;
        gc.gridwidth = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.BOTH;
        panel.add(buttonPanel, gc);
        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.CENTER;
        panel.add(boxPanel, gc);
        gc.gridx = 2;
        gc.gridy = 2;
        gc.gridwidth = 2;
        gc.anchor = GridBagConstraints.CENTER;
        panel.add(comboxPanel, gc);
        gc.gridx = 0;
        gc.gridy = 4;
        gc.gridwidth = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.fill = GridBagConstraints.NONE;
        panel.add(l10, gc);
        gc.gridx = 1;
        gc.gridy = 4;
        panel.add(l11, gc);
        gc.gridx = 2;
        gc.gridy = 4;
        gc.gridwidth = 2;
        panel.add(l12, gc);
        gc.gridx = 0;
        gc.gridy = 6;
        gc.gridwidth = 1;
        gc.anchor = GridBagConstraints.EAST;
        gc.fill = GridBagConstraints.BOTH;
        panel.add(l3, gc);
        gc.gridx = 1;
        gc.gridy = 6;
        gc.gridwidth = 1;
        gc.anchor = GridBagConstraints.CENTER;
        panel.add(pricepanel1, gc);
        gc.gridx = 2;
        gc.gridy = 6;
        panel.add(gridpanel, gc);
        gc.gridx = 1;
        gc.gridy = 3;
        gc.fill = GridBagConstraints.NONE;
        panel.add(l21, gc);
        gc.gridx = 0;
        gc.gridy = 7;
        gc.gridwidth = 3;
        gc.gridheight = 1;
        gc.anchor = GridBagConstraints.NORTH;
        gc.insets = new Insets(12, 8, 5, 2);
        panel.add(l22, gc);
        gc.gridx = 0;
        gc.gridy = 5;
        gc.gridwidth = 3;
        gc.gridheight = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(8, 8, 10, 8);
        panel.add(l23, gc);

        // main panel construction
        setContentPane(panel);
        setSize(980, 700);
        setLocationRelativeTo(null);
        setResizable(true);
        setTitle("BEE ONLINE \u00A9 2015");
        getContentPane().setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        addWindowListener(this);
    }

    // set up window event of yes/no option panel
    public void windowClosing(WindowEvent e) {
        int option = JOptionPane.showConfirmDialog(null,
                "You Sure You Wanna Leave Me?", "BEE \u00a9 2015",
                JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null,
                    "TNAK YOU FOR CHOOSING BEE! \nWELCOME TO COME AGAIN~",
                    "BEE \u00a9 2015", JOptionPane.INFORMATION_MESSAGE);
            //
            //
            //
            // System.exit(0);
        } else if (option == JOptionPane.NO_OPTION)
            return;
    }

    // set up item event of radio buttons for sizes of lap-top
    public void itemStateChanged(ItemEvent f) {
        JRadioButton selected = (JRadioButton) f.getItem();
        {

            if (selected.equals(w12)) {
                base = 1999.99;
                basechoice = "12'' LemonCake with Windows 10";
                l10.setText(df.format(base));
            } else if (selected.equals(w14)) {
                base = 3099.58;
                basechoice = "14'' LemonCake with Windows 10";
                l10.setText(df.format(base));
            } else if (selected.equals(M12)) {
                base = 1999.99;
                basechoice = "12'' LemonCake with MOS 3";
                l10.setText(df.format(base));
            } else if (selected.equals(M13)) {
                base = 2499.87;
                basechoice = "13'' LemonCake with MOS 3";
                l10.setText(df.format(base));
            } else if (selected.equals(M14)) {
                base = 3099.58;
                basechoice = "14'' LemonCake with MOS 3";
                l10.setText(df.format(base));
            }
            reference1 = base;
        }
    }

    // set up action event for the rest of the buttons
    public void actionPerformed(ActionEvent e) {

        // set up clear button to clean up choices
        if (e.getSource() == clear) {
            group1.clearSelection();
            checkout.setEnabled(false);
            screen.setSelected(false);
            bose.setSelected(false);
            cool.setSelected(false);
            retina.setSelected(false);
            keys.setSelected(false);
            colors.setSelectedIndex(0);
            memory.setSelectedIndex(0);
            harddrive.setSelectedIndex(0);
            battery.setSelectedIndex(0);
            cpu.setSelectedIndex(0);
            l10.setText("$ 0.00");
            l11.setText("$ 0.00");
            l12.setText("$ 0.00");
            acc = 0;
            reference1 = 0;
            reference2 = 0;
            reference3 = 0;
            subtotalp = reference1 + reference2 + reference3;
            l17.setText(df.format(subtotalp));
            l18.setText("$ 0.00");
            l18.setBackground(new Color((int) (0), (int) (255), (int) (255)));
            l19.setText("$ 0.00");
            l20.setText("$ 0.00");

            /*
             * lock down, for 1.0 version only w12.setEnabled(true);
             * w14.setEnabled(true); M12.setEnabled(true); M13.setEnabled(true);
             * M14.setEnabled(true); colors.setEnabled(true);
             * memory.setEnabled(true); harddrive.setEnabled(true);
             * battery.setEnabled(true); cpu.setEnabled(true);
             * screen.setEnabled(true); cool.setEnabled(true);
             * bose.setEnabled(true); retina.setEnabled(true);
             * keys.setEnabled(true);
             */

        }

        // calculate rough amount of money for substitutes and change strings
        // screen
        if (e.getSource() == screen) {
            if (screen.isSelected()) {
                acc += 1;
                screenchoice = "with MYJARVIS 8 removable screen";
            } else {
                acc -= 1;
                screenchoice = "with normal screen";
            }
        }
        // cool
        else if (e.getSource() == cool) {
            if (cool.isSelected()) {
                acc += 1;
                coolchoice = "and 2014 Superb Cooling";
            } else {
                acc -= 1;
                coolchoice = "and standard cooling system";
            }
        }
        // body
        else if (e.getSource() == bose) {
            if (bose.isSelected()) {
                acc++;

                bosechoice = "and QC10 Bose Stereo";
            }
            if (!bose.isSelected()) {
                acc--;
                bosechoice = "and Pioneer Stereo";
            }
        }

        // retina
        else if (e.getSource() == retina) {
            if (retina.isSelected()) {
                acc++;
                retinachoice = "and E10 Fingerprint Senser \nas well as Eye Tribe 2014 Retina Scanner";
            }
            if (!retina.isSelected()) {
                acc--;
                retinachoice = "and standard E10 Fingerprint scanner";
            }
        }
        // keys
        else if (e.getSource() == keys) {
            if (keys.isSelected()) {
                acc++;
                keyschoice = "and Illuminating keyboard and touchpad \n";
            }
            if (!keys.isSelected()) {
                acc--;
                keyschoice = "";
            }
        }

        // calculate the money for substitutes
        pacc = acc - 2;
        if (pacc < 0) {
            l11.setText("$ 0.00");
            reference2 = 0;
        } else {
            l11.setText(df.format(pacc * 99.99));
            reference2 = pacc * 99.99;
        }

        // calculate rough amount of money for customization and change strings
        {
            // colors
            if (e.getSource() == colors) {
                if (colors.getSelectedIndex() == 0) {
                    ImageIcon imgproduct = new ImageIcon("2020 Yellow.jpg");
                    l2.setIcon(imgproduct);
                    color = 0;
                } else if (colors.getSelectedIndex() == 1) {
                    ImageIcon imgproduct2 = new ImageIcon("2020 pink.jpg");
                    l2.setIcon(imgproduct2);
                    color = 10.16;
                    colorchoice = "with pink body";
                } else if (colors.getSelectedIndex() == 2) {
                    ImageIcon imgproduct3 = new ImageIcon("2020 red.jpg");
                    l2.setIcon(imgproduct3);
                    color = 8.88;
                    colorchoice = "with red body";
                } else if (colors.getSelectedIndex() == 3) {
                    ImageIcon imgproduct4 = new ImageIcon("2020 green.jpg");
                    l2.setIcon(imgproduct4);
                    color = 8.88;
                    colorchoice = "with green body";
                } else if (colors.getSelectedIndex() == 4) {
                    ImageIcon imgproduct5 = new ImageIcon("2020 blue.jpg");
                    l2.setIcon(imgproduct5);
                    color = 8.88;
                    colorchoice = "with blue body";
                } else if (colors.getSelectedIndex() == 5) {
                    ImageIcon imgproduct6 = new ImageIcon("2020 white.jpg");
                    l2.setIcon(imgproduct6);
                    color = 6.66;
                    colorchoice = "with white body";
                } else if (colors.getSelectedIndex() == 6) {
                    ImageIcon imgproduct7 = new ImageIcon("2020 black.jpg");
                    l2.setIcon(imgproduct7);
                    color = 6.66;
                    colorchoice = "with black body";
                }
                totalp = color + pcpu + pmemory + pharddrive + pbattery;
            }

            // CPU
            if (e.getSource() == cpu) {
                if (cpu.getSelectedIndex() == 0) {
                    pcpu = 0;
                } else if (cpu.getSelectedIndex() == 1) {
                    pcpu = 166.58;
                    cpuchoice = "and A6, 4 cores with 3.6 GHz";
                }
                totalp = color + pcpu + pmemory + pharddrive + pbattery;
            }

            // memories
            if (e.getSource() == memory) {
                if (memory.getSelectedIndex() == 0) {
                    pmemory = 0;
                } else if (memory.getSelectedIndex() == 1) {
                    pmemory = 81.03;
                    memorychoice = "and Kingston 16GB Memory";
                } else if (memory.getSelectedIndex() == 2) {
                    pmemory = 180.16;
                    memorychoice = "and Kingston 32GB Memory";
                }
                totalp = color + pcpu + pmemory + pharddrive + pbattery;
            }

            // hard-drives
            if (e.getSource() == harddrive) {
                if (harddrive.getSelectedIndex() == 0) {
                    pharddrive = 0;
                } else if (harddrive.getSelectedIndex() == 1) {
                    pharddrive = 230.12;
                    harddrivechoice = "and WD 2TB Grand Built-in Harddrive";
                } else if (harddrive.getSelectedIndex() == 2) {
                    pharddrive = 499.87;
                    harddrivechoice = "and WD 4TB Grand Built-in Harddrive";
                }
                totalp = color + pcpu + pmemory + pharddrive + pbattery;
            }

            // batteries
            if (e.getSource() == battery) {
                if (battery.getSelectedIndex() == 0) {
                    pbattery = 0;
                } else if (battery.getSelectedIndex() == 1) {
                    pbattery = 160.16;
                    batterychoice = "and an extra Built-in S6 Battery";
                }
                totalp = color + pcpu + pmemory + pharddrive + pbattery;
            }

            // calculate the money for customization
            reference3 = totalp;
            l12.setText(df.format(totalp));
        }

        // set up algorithm for after all calculation
        if (e.getSource() == calculate) {
            subtotalp = reference1 + reference2 + reference3;

            /*
             * Lock down, for 1.0 only w12.setEnabled(false);
             * w14.setEnabled(false); M12.setEnabled(false);
             * M13.setEnabled(false); M14.setEnabled(false);
             * colors.setEnabled(false); memory.setEnabled(false);
             * harddrive.setEnabled(false); battery.setEnabled(false);
             * cpu.setEnabled(false); screen.setEnabled(false);
             * cool.setEnabled(false); bose.setEnabled(false);
             * retina.setEnabled(false); keys.setEnabled(false);
             */

            if (subtotalp > 3600) {
                l17.setText(df.format(subtotalp));
                subtotalp -= 99;
                l18.setOpaque(true);
                l18.setBackground(Color.GREEN);
                l18.setText("$ 99.00");
                tax = subtotalp * 0.13;
                l19.setText(df.format(tax));
                grandtotal = subtotalp + tax;
                l20.setText(df.format(grandtotal));
            } else {
                l17.setText(df.format(subtotalp));
                l18.setText("$ 0.00");
                l18.setBackground(new Color((int) (0), (int) (255), (int) (255)));
                tax = subtotalp * 0.13;
                l19.setText(df.format(tax));
                grandtotal = subtotalp + tax;
                l20.setText(df.format(grandtotal));
            }
            checkout.setEnabled(true);
        }

        // set action for checkout button
        if (e.getSource() == checkout) {
            calculate.doClick();
            if (w12.isSelected() || w14.isSelected() || M12.isSelected()
                    || M13.isSelected() || M14.isSelected()) {
                sumchoice = basechoice + "\n" + colorchoice + "\n" + coolchoice
                        + "\n" + bosechoice + "\n" + retinachoice + "\n"
                        + keyschoice + harddrivechoice + "\n" + cpuchoice
                        + "\n" + memorychoice + "\n" + batterychoice + "\n"
                        + screenchoice + "\n" + "\n"
                        + "           TOTAL:    " + df.format(grandtotal);
                int option = JOptionPane.showConfirmDialog(null,
                        "Is This Your Order? " + "\n" + "\n" + sumchoice,
                        "BEE \u00a9 2015", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    ImageIcon Icon = new ImageIcon("icon.png");
                    JOptionPane
                            .showMessageDialog(
                                    null,
                                    "TNAK YOU SO MUCH FOR CHOOSING BEE! \nWELCOME TO COME AGAIN SOON~ \nAS ALWAYS, DELIVERY IS FOR FREE",
                                    "BEE \u00a9 2015",
                                    JOptionPane.INFORMATION_MESSAGE, Icon);
                    ImageIcon product = new ImageIcon("razer-blade-qhd.png");
                    JOptionPane.showMessageDialog(null, "", "BEE \u00a9 2015",
                            JOptionPane.INFORMATION_MESSAGE, product);
                    //System.exit(0);
                } else if (option == JOptionPane.NO_OPTION)
                    JOptionPane.showMessageDialog(null,
                            "Sorry. Please Contact +1 647 918 5452 For Help.",
                            "BEE \u00a9 2015", JOptionPane.INFORMATION_MESSAGE);

                /*
                 * Lock down, for 1.0 only group1.clearSelection();
                 *
                 * checkout.setEnabled(false);
                 *
                 * screen.setSelected(false); bose.setSelected(false);
                 * cool.setSelected(false); retina.setSelected(false);
                 * keys.setSelected(false);
                 *
                 * colors.setSelectedIndex(0); memory.setSelectedIndex(0);
                 * harddrive.setSelectedIndex(0); battery.setSelectedIndex(0);
                 * cpu.setSelectedIndex(0);
                 *
                 * l10.setText("$ 0"); l11.setText("$ 0"); l12.setText("$ 0");
                 *
                 * l18.setText("          $ " + 0); l19.setText("          $ " +
                 * 0); l20.setText("          $ " + 0);
                 *
                 * acc = 0; reference1 = 0; reference2 = 0; reference3 = 0;
                 * subtotalp = reference1 + reference2 + reference3;
                 * l17.setText("          $ " + subtotalp);
                 *
                 * w12.setEnabled(true); w14.setEnabled(true);
                 * M12.setEnabled(true); M13.setEnabled(true);
                 * M14.setEnabled(true); colors.setEnabled(true);
                 * memory.setEnabled(true); harddrive.setEnabled(true);
                 * battery.setEnabled(true); cpu.setEnabled(true);
                 * screen.setEnabled(true); cool.setEnabled(true);
                 * bose.setEnabled(true); retina.setEnabled(true);
                 * keys.setEnabled(true);
                 */

            } else {
                JOptionPane.showMessageDialog(null,
                        "Don't Fool Me! Go Back And Pick A LemonCake!",
                        "BEE \u00a9 2015", JOptionPane.ERROR_MESSAGE);
            }
        }

        // set action for exit button
        if (e.getSource() == exit) {
            int option = JOptionPane.showConfirmDialog(null,
                    "You Sure You Wanna Leave Me?", "Exit",
                    JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null,
                        "TNAK YOU FOR CHOOSING BEE! \nWELCOME TO COME AGAIN~",
                        "BEE \u00a9 2015", JOptionPane.INFORMATION_MESSAGE);
                //System.exit(0);
            } else if (option == JOptionPane.NO_OPTION)
                return;
        }

    }

    public void windowActivated(WindowEvent arg0) {

    }

    public void windowClosed(WindowEvent arg0) {
    }

    public void windowClosing1(WindowEvent arg0) {
    }

    public void windowDeactivated(WindowEvent arg0) {
    }

    public void windowDeiconified(WindowEvent arg0) {
    }

    public void windowIconified(WindowEvent arg0) {
    }

    public void windowOpened(WindowEvent arg0) {
    }
}
