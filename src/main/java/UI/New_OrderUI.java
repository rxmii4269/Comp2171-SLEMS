package UI;

import Data.Customer;
import Data.Order;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class New_OrderUI {
    private JFrame frame;
    private JTextField CustomerField;
    private JTextField phoneField;
    private JTextField emailField;
    private JTextField deliveryField;
    private JTextField AmtField;
    private String custName;
    private String phoneNum;
    private String email;
    private String address;
    private int amt;

    public New_OrderUI() {
        this.initialize();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                New_OrderUI window = new New_OrderUI();
                window.frame.setVisible(true);
            } catch (Exception var1) {
                var1.printStackTrace();
            }

        });
    }

    private void initialize() {
        this.frame = new JFrame();
        this.frame.getContentPane().setBackground(Color.WHITE);
        this.frame.setBounds(100, 100, 570, 520);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.getContentPane().setLayout(null);
        JLabel label = new JLabel("WELCOME TO ");
        label.setForeground(SystemColor.controlDkShadow);
        label.setHorizontalAlignment(0);
        label.setFont(new Font("Ebrima", Font.BOLD, 24));
        label.setBounds(0, 27, 554, 23);
        this.frame.getContentPane().add(label);
        JLabel lblNewLabel = new JLabel("SUPER FRESH EGGS");
        lblNewLabel.setForeground(new Color(25, 25, 112));
        lblNewLabel.setHorizontalAlignment(0);
        lblNewLabel.setFont(new Font("Poetsen One", Font.BOLD, 40));
        lblNewLabel.setBounds(73, 45, 408, 48);
        this.frame.getContentPane().add(lblNewLabel);
        JLabel lblNewLabel_1 = new JLabel("MANAGEMENT SYSTEM");
        lblNewLabel_1.setForeground(SystemColor.controlDkShadow);
        lblNewLabel_1.setHorizontalAlignment(0);
        lblNewLabel_1.setFont(new Font("Ebrima", Font.BOLD, 22));
        lblNewLabel_1.setBounds(158, 89, 246, 23);
        this.frame.getContentPane().add(lblNewLabel_1);
        JLabel phoneLabel = new JLabel("Phone Number");
        phoneLabel.setFont(new Font("Arial", Font.BOLD, 15));
        phoneLabel.setBounds(37, 258, 202, 14);
        this.frame.getContentPane().add(phoneLabel);
        this.CustomerField = new JTextField();
        this.CustomerField.setBounds(37, 224, 202, 23);
        this.frame.getContentPane().add(this.CustomerField);
        this.CustomerField.setColumns(10);
        JLabel lblNewLabel_2 = new JLabel();
        lblNewLabel_2.setBounds(437, 285, 70, 14);
        this.frame.getContentPane().add(lblNewLabel_2);
        JButton btnLogin = new JButton("CONFIRM ORDER");
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setBackground(new Color(25, 25, 112));
        btnLogin.setBounds(327, 357, 168, 48);
        this.frame.getContentPane().add(btnLogin);
        btnLogin.addActionListener((e) -> {
            this.custName = this.CustomerField.getText();
            this.phoneNum = this.phoneField.getText();
            this.address = this.deliveryField.getText();
            this.email = this.emailField.getText();
            this.amt = Integer.parseInt(this.AmtField.getText());
            Customer customer = null;

            try {
                customer = new Customer(this.custName, this.phoneNum, this.address, this.email, this.amt);
            } catch (IOException var5) {
                var5.printStackTrace();
            }

            if (customer != null) {
                customer.customer.add(this.custName);
            }

            if (customer != null) {
                customer.customer.add(this.phoneNum);
            }

            if (customer != null) {
                customer.customer.add(this.address);
            }

            if (customer != null) {
                customer.customer.add(this.email);
            }

            if (customer != null) {
                customer.customer.add(String.valueOf(this.amt));
            }

            Order order = new Order(this.amt);
            if (customer != null) {
                customer.customerInfo();
            }

            lblNewLabel_2.setText("$" + order.total());
        });
        JLabel lblCustomerName = new JLabel("Customer Name");
        lblCustomerName.setFont(new Font("Arial", Font.BOLD, 15));
        lblCustomerName.setBounds(37, 199, 202, 14);
        this.frame.getContentPane().add(lblCustomerName);
        JLabel lblDeliveryAddress = new JLabel("Delivery Address");
        lblDeliveryAddress.setFont(new Font("Arial", Font.BOLD, 15));
        lblDeliveryAddress.setBounds(37, 373, 202, 14);
        this.frame.getContentPane().add(lblDeliveryAddress);
        JLabel lblNewLabel_3 = new JLabel("NEW ORDER");
        lblNewLabel_3.setForeground(SystemColor.windowBorder);
        lblNewLabel_3.setHorizontalAlignment(0);
        lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));
        lblNewLabel_3.setBounds(162, 137, 219, 28);
        this.frame.getContentPane().add(lblNewLabel_3);
        JLabel lblEmailAddress = new JLabel("Email Address");
        lblEmailAddress.setFont(new Font("Arial", Font.BOLD, 15));
        lblEmailAddress.setBounds(37, 312, 202, 14);
        this.frame.getContentPane().add(lblEmailAddress);
        JLabel lblIfItIs = new JLabel("If it is a pick up order, type N/A");
        lblIfItIs.setHorizontalAlignment(0);
        lblIfItIs.setBounds(37, 420, 202, 14);
        this.frame.getContentPane().add(lblIfItIs);
        this.phoneField = new JTextField();
        this.phoneField.setColumns(10);
        this.phoneField.setBounds(37, 276, 202, 23);
        this.frame.getContentPane().add(this.phoneField);
        this.emailField = new JTextField();
        this.emailField.setColumns(10);
        this.emailField.setBounds(37, 331, 202, 23);
        this.frame.getContentPane().add(this.emailField);
        this.deliveryField = new JTextField();
        this.deliveryField.setColumns(10);
        this.deliveryField.setBounds(37, 398, 202, 23);
        this.frame.getContentPane().add(this.deliveryField);
        JLabel lblEnterAmount = new JLabel("Enter Amount:");
        lblEnterAmount.setFont(new Font("Arial", Font.BOLD, 15));
        lblEnterAmount.setBounds(313, 228, 135, 14);
        this.frame.getContentPane().add(lblEnterAmount);
        this.AmtField = new JTextField();
        this.AmtField.setBounds(437, 224, 95, 23);
        this.frame.getContentPane().add(this.AmtField);
        this.AmtField.setColumns(10);
        JLabel lblTotal = new JLabel("Total:");
        lblTotal.setFont(new Font("Arial", Font.BOLD, 15));
        lblTotal.setBounds(313, 285, 135, 14);
        this.frame.getContentPane().add(lblTotal);
        JLabel lblEnterType = new JLabel("Enter Type");
        lblEnterType.setFont(new Font("Arial", Font.BOLD, 15));
        lblEnterType.setBounds(313, 259, 135, 14);
        this.frame.getContentPane().add(lblEnterType);
        JComboBox<String> TypeBox = new JComboBox<>();
        TypeBox.setBackground(new Color(255, 255, 255));
        TypeBox.setBounds(437, 256, 95, 20);
        this.frame.getContentPane().add(TypeBox);
        TypeBox.addItem("Liquid Eggs");
        TypeBox.addItem("Shell Eggs");
        New_UserUI.date(this.frame);
        JButton btnBack = new JButton("BACK");
        btnBack.addActionListener((e) -> {
            this.getFrame().dispose();
            HomeUI home = new HomeUI();
            home.getFrame().setVisible(true);
        });
        btnBack.setBackground(Color.WHITE);
        btnBack.setBounds(10, 11, 89, 23);
        this.frame.getContentPane().add(btnBack);
    }

    public JFrame getFrame() {
        return this.frame;
    }
}
