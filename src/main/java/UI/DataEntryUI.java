package UI;

import Security.Login_UserUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Date;

class DataEntryUI extends JFrame {
    private final JButton saveButton;
    private final JButton unitsProduce;
    private final JButton exitButton;
    private final JTextField IDBox;
    private final JTextField AmountCollectedTypeBox;
    private final JTextField AmountSpoiltBox;
    private final JTextField AmountBrokenBox;
    private final JTextField WorkStationSectionBox;
    private final JTextField WorkStationNumberBox;
    private JTextField ProductNameBox;
    private JTextField ProductTypeBox;
    private PrintWriter out;
    private final PrintWriter pout;
    private final String formatter;

    DataEntryUI() throws IOException {
        FileWriter product = new FileWriter("Product.txt", StandardCharsets.UTF_8, true);
        BufferedWriter pw = new BufferedWriter(product);
        this.pout = new PrintWriter(pw);
        this.formatter = "%-30s %-30s %-30s%n";
        this.setTitle("Enter Data");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocation(300, 2);
        JPanel MainPanel = new JPanel();
        Date d = new Date();
        JPanel WESTPanel = new JPanel();
        JPanel EASTPanel = new JPanel();
        JPanel SOUTHPanel = new JPanel();
        JPanel NORTHPanel = new JPanel();
        JPanel CENTERPanel = new JPanel();
        MainPanel.setPreferredSize(new Dimension(960, 480));
        MainPanel.setLayout(new BorderLayout());
        SOUTHPanel.setBackground(Color.BLUE);
        WESTPanel.setLayout(new BoxLayout(WESTPanel, BoxLayout.PAGE_AXIS));
        EASTPanel.setLayout(new BoxLayout(EASTPanel, BoxLayout.PAGE_AXIS));
        CENTERPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        JTextArea NorthTextArea = new JTextArea();
        NorthTextArea.setEditable(false);
        NorthTextArea.setOpaque(false);
        NorthTextArea.setText("WELCOME, PLEASE ENTER THE DATA \n      ");
        NorthTextArea.append(d.toString());
        NORTHPanel.add(NorthTextArea, "Center");
        MainPanel.add(NORTHPanel, "North");
        NorthTextArea.setFont(new Font("Calibri", Font.ITALIC, 30));
        this.exitButton = new JButton("Exit");
        this.getExitButton().addActionListener((e) -> {
            this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            this.dispose();
            Login_UserUI window = null;
            try {
                window = new Login_UserUI();
            } catch (IOException | FontFormatException ioException) {
                ioException.printStackTrace();
            }
            try {
                assert window != null;
                window.initialize();
            } catch (IOException | FontFormatException ioException) {
                ioException.printStackTrace();
            }
        });
        this.saveButton = new JButton("Save");
        this.getSaveButton().addActionListener((e) -> {
            try {
                this.out = new PrintWriter("Data.txt", StandardCharsets.UTF_8);
            } catch (IOException var3) {
                var3.printStackTrace();
            }

            assert this.out != null;

            String formatStr = "%%-30s %-30s %-30s %-30s %-25s %-20s%n";
            this.out.write(String.format(formatStr, "Employee ID", "Collected Eggs", "Spoilt Eggs", "Broken Eggs", "WorkStation Section", "WorkStation Number"));
            this.out.append(String.format(formatStr, this.getIDBox().getText(), this.getAmountCollectedTypeBox().getText(), this.getAmountSpoiltBox().getText(), this.getAmountBrokenBox().getText(), this.getWorkStationSectionBox().getText(), this.getWorkStationNumberBox().getText()));
            this.pout.println(String.format(this.formatter, "Collected Eggs", "Spoiled Eggs", "Broken Eggs"));
            this.pout.println(String.format(this.formatter, this.getAmountCollectedTypeBox().getText(), this.getAmountSpoiltBox().getText(), this.getAmountBrokenBox().getText()));
            this.pout.flush();
            this.pout.close();
            this.out.close();
            JOptionPane.showMessageDialog(null, "Data is saved", "SLEMS", JOptionPane.INFORMATION_MESSAGE);
        });
        this.unitsProduce = new JButton("Units Producible ");
        this.getUnitsProduce().addActionListener(this::actionPerformed);
        this.getExitButton().setPreferredSize(new Dimension(150, 100));
        this.getUnitsProduce().setPreferredSize(new Dimension(150, 100));
        this.getSaveButton().setPreferredSize(new Dimension(150, 100));
        WESTPanel.add(Box.createRigidArea(new Dimension(30, 50)));
        WESTPanel.add(this.getExitButton());
        EASTPanel.add(Box.createRigidArea(new Dimension(30, 50)));
        EASTPanel.add(this.getUnitsProduce());
        EASTPanel.add(Box.createRigidArea(new Dimension(30, 50)));
        EASTPanel.add(this.getSaveButton());
        MainPanel.add(WESTPanel, "West");
        MainPanel.add(EASTPanel, "East");
        JLabel userId = new JLabel("ENTER Your ID  ");
        this.IDBox = new JTextField(30);
        this.setUserID(this.getIDBox().getText());
        gbc.gridx = 1;
        gbc.gridy = 3;
        CENTERPanel.add(userId, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        CENTERPanel.add(this.getIDBox(), gbc);
        JLabel AmountCollected = new JLabel("ENTER Amount Collected  ");
        this.AmountCollectedTypeBox = new JTextField(30);
        gbc.gridx = 1;
        gbc.gridy = 7;
        CENTERPanel.add(AmountCollected, gbc);
        gbc.gridx = 1;
        gbc.gridy = 8;
        CENTERPanel.add(this.getAmountCollectedTypeBox(), gbc);
        JLabel AmountSpoilt = new JLabel("ENTER Amount Spoilt ");
        this.AmountSpoiltBox = new JTextField(30);
        gbc.gridx = 1;
        gbc.gridy = 9;
        CENTERPanel.add(AmountSpoilt, gbc);
        gbc.gridx = 1;
        gbc.gridy = 10;
        CENTERPanel.add(this.getAmountSpoiltBox(), gbc);
        JLabel AmountBroken = new JLabel("ENTER Amount Broken  ");
        this.AmountBrokenBox = new JTextField(30);
        gbc.gridx = 1;
        gbc.gridy = 11;
        CENTERPanel.add(AmountBroken, gbc);
        gbc.gridx = 1;
        gbc.gridy = 12;
        CENTERPanel.add(this.getAmountBrokenBox(), gbc);
        JLabel WorkStationSectionLabel = new JLabel("ENTER Work Station Section  ");
        this.WorkStationSectionBox = new JTextField(30);
        gbc.gridx = 1;
        gbc.gridy = 13;
        CENTERPanel.add(WorkStationSectionLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 14;
        CENTERPanel.add(this.getWorkStationSectionBox(), gbc);
        JLabel WorkStationNumberLabel = new JLabel("ENTER Work Station Number   ");
        this.WorkStationNumberBox = new JTextField(30);
        gbc.gridx = 1;
        gbc.gridy = 15;
        CENTERPanel.add(WorkStationNumberLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 16;
        CENTERPanel.add(this.getWorkStationNumberBox(), gbc);
        MainPanel.add(CENTERPanel, "Center");
        SOUTHPanel.setSize(15, 10);
        MainPanel.add(SOUTHPanel, "South");
        this.getContentPane().add(MainPanel);
        this.pack();
        this.setVisible(true);
    }

    private void actionPerformed(ActionEvent e) {
        if (this.getAmountCollected().equalsIgnoreCase("") || this.getAmountSpoilt().equalsIgnoreCase("") || this.getAmountBroken().equalsIgnoreCase("") || this.getWorkStationNumber().equalsIgnoreCase("") || this.getWorkStationSection().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Please Enter Data into all Fields before Proceeding");
            this.SetTextFieldsToNull();
        }

    }

    void addb7ActionListener(ActionListener b7listener) {
        this.getUnitsProduce().addActionListener(b7listener);
    }

    void addb8ActionListener(ActionListener b8listener) {
        this.getSaveButton().addActionListener(b8listener);
    }

    public void addb4ActionListener(ActionListener exit4listener) {
        this.getExitButton().addActionListener(exit4listener);
    }

    private void SetTextFieldsToNull() {
        this.getIDBox().setText(null);
        this.getAmountCollectedTypeBox().setText(null);
        this.getAmountSpoiltBox().setText(null);
        this.getAmountBrokenBox().setText(null);
        this.getWorkStationSectionBox().setText(null);
        this.getWorkStationNumberBox().setText(null);
    }

    public String getProductName() {
        return this.getProductNameBox().getText();
    }

    public void setProductName(String productName) {
    }

    String getUserID() {
        return this.getIDBox().getText();
    }

    private void setUserID(String userID) {
    }

    public String getProductType() {
        return this.getProductTypeBox().getText();
    }

    public void setProductType(String productType) {
    }

    private String getAmountCollected() {
        return this.getAmountCollectedTypeBox().getText();
    }

    public void setAmountcollected(String amountcollected) {
    }

    private String getAmountSpoilt() {
        return this.getAmountSpoiltBox().getText();
    }

    public void setAmountspoilt(String amountspoilt) {
    }

    private String getAmountBroken() {
        return this.getAmountBrokenBox().getText();
    }

    public void setAmountbroken(String amountbroken) {
    }

    private String getWorkStationSection() {
        return this.getWorkStationSectionBox().getText();
    }

    public void setWorkStationSection(String workStationSection) {
    }

    private String getWorkStationNumber() {
        return this.getWorkStationNumberBox().getText();
    }

    public void setWorkStationNumber(String workStationNumber) {
    }

    private JButton getSaveButton() {
        return this.saveButton;
    }

    private JButton getUnitsProduce() {
        return this.unitsProduce;
    }

    private JButton getExitButton() {
        return this.exitButton;
    }

    private JTextField getProductNameBox() {
        return this.ProductNameBox;
    }

    public void setProductNameBox(JTextField productNameBox) {
        this.ProductNameBox = productNameBox;
    }

    private JTextField getIDBox() {
        return this.IDBox;
    }

    private JTextField getProductTypeBox() {
        return this.ProductTypeBox;
    }

    public void setProductTypeBox(JTextField productTypeBox) {
        this.ProductTypeBox = productTypeBox;
    }

    private JTextField getAmountCollectedTypeBox() {
        return this.AmountCollectedTypeBox;
    }

    private JTextField getAmountSpoiltBox() {
        return this.AmountSpoiltBox;
    }

    private JTextField getAmountBrokenBox() {
        return this.AmountBrokenBox;
    }

    private JTextField getWorkStationSectionBox() {
        return this.WorkStationSectionBox;
    }

    private JTextField getWorkStationNumberBox() {
        return this.WorkStationNumberBox;
    }
}
