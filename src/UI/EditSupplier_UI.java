package UI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class EditSupplier_UI {
    private JFrame frame;

    EditSupplier_UI() {
        this.initialize();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                EditSupplier_UI window = new EditSupplier_UI();
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
        this.frame.setFocusable(true);
        this.frame.getContentPane().setLayout(null);
        New_UserUI.data3(this.frame);
        JLabel label_1 = new JLabel("Company Name");
        label_1.setFont(new Font("Arial", Font.BOLD, 15));
        label_1.setBounds(300, 149, 115, 14);
        this.frame.getContentPane().add(label_1);
        JTextField CompanyName = new JTextField();
        CompanyName.setBounds(300, 174, 202, 23);
        this.frame.getContentPane().add(CompanyName);
        CompanyName.setColumns(10);
        JLabel lblEmailAddress = new JLabel("Email Address");
        lblEmailAddress.setFont(new Font("Arial", Font.BOLD, 15));
        lblEmailAddress.setBounds(300, 268, 108, 14);
        this.frame.getContentPane().add(lblEmailAddress);
        JTextField emailField = new JTextField();
        emailField.setColumns(10);
        emailField.setBounds(300, 293, 202, 23);
        this.frame.getContentPane().add(emailField);
        JLabel lblPhoneNumber = new JLabel("Phone Number");
        lblPhoneNumber.setFont(new Font("Arial", Font.BOLD, 15));
        lblPhoneNumber.setBounds(300, 327, 108, 14);
        this.frame.getContentPane().add(lblPhoneNumber);
        JTextField phoneField = new JTextField();
        phoneField.setColumns(10);
        phoneField.setBounds(300, 352, 202, 23);
        this.frame.getContentPane().add(phoneField);
        JLabel lblFarmAddress = new JLabel("Farm Address");
        lblFarmAddress.setFont(new Font("Arial", Font.BOLD, 15));
        lblFarmAddress.setBounds(300, 384, 108, 14);
        this.frame.getContentPane().add(lblFarmAddress);
        JTextField FAddressField = new JTextField();
        FAddressField.setColumns(10);
        FAddressField.setBounds(300, 409, 202, 23);
        this.frame.getContentPane().add(FAddressField);
        JButton btnAddSupplier = new JButton("MAKE EDIT");
        btnAddSupplier.addActionListener((e) -> {
        });
        btnAddSupplier.setForeground(Color.BLACK);
        btnAddSupplier.setBackground(new Color(25, 25, 112));
        btnAddSupplier.setBounds(325, 443, 140, 23);
        this.frame.getContentPane().add(btnAddSupplier);
        New_UserUI.date(this.frame);
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setBounds(43, 231, 193, 29);
        this.frame.getContentPane().add(comboBox);
        JLabel lblToEditA = new JLabel("Choose Supplier to Edit ");
        lblToEditA.setHorizontalAlignment(0);
        lblToEditA.setBounds(43, 209, 193, 14);
        this.frame.getContentPane().add(lblToEditA);
        JButton btnBack = new JButton("BACK");
        btnBack.addActionListener((e) -> {
            this.getFrame().dispose();
            New_ExtSupplierUI previous = null;

            try {
                previous = new New_ExtSupplierUI();
            } catch (IOException var4) {
                var4.printStackTrace();
            }

            if (previous != null) {
                previous.getFrame().setVisible(true);
            }

        });
        btnBack.setBackground(Color.WHITE);
        btnBack.setBounds(10, 11, 89, 23);
        this.frame.getContentPane().add(btnBack);
    }

    JFrame getFrame() {
        return this.frame;
    }
}
