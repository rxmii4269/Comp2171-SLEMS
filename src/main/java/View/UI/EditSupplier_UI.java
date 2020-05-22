package View.UI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class EditSupplier_UI extends JFrame {

    EditSupplier_UI() throws IOException {
        this.initialize();
    }


    private void initialize() throws IOException {

        getContentPane().setBackground(Color.WHITE);
        setBounds(100, 100, 570, 520);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setFocusable(true);
        getContentPane().setLayout(null);
        New_UserUI newuser = new New_UserUI();
        newuser.data3();
        JLabel label_1 = new JLabel("Company Name");
        label_1.setFont(new Font("Arial", Font.BOLD, 15));
        label_1.setBounds(300, 149, 115, 14);
        getContentPane().add(label_1);
        JTextField CompanyName = new JTextField();
        CompanyName.setBounds(300, 174, 202, 23);
        getContentPane().add(CompanyName);
        CompanyName.setColumns(10);
        JLabel lblEmailAddress = new JLabel("Email Address");
        lblEmailAddress.setFont(new Font("Arial", Font.BOLD, 15));
        lblEmailAddress.setBounds(300, 268, 108, 14);
        getContentPane().add(lblEmailAddress);
        JTextField emailField = new JTextField();
        emailField.setColumns(10);
        emailField.setBounds(300, 293, 202, 23);
        getContentPane().add(emailField);
        JLabel lblPhoneNumber = new JLabel("Phone Number");
        lblPhoneNumber.setFont(new Font("Arial", Font.BOLD, 15));
        lblPhoneNumber.setBounds(300, 327, 108, 14);
        getContentPane().add(lblPhoneNumber);
        JTextField phoneField = new JTextField();
        phoneField.setColumns(10);
        phoneField.setBounds(300, 352, 202, 23);
        getContentPane().add(phoneField);
        JLabel lblFarmAddress = new JLabel("Farm Address");
        lblFarmAddress.setFont(new Font("Arial", Font.BOLD, 15));
        lblFarmAddress.setBounds(300, 384, 108, 14);
        getContentPane().add(lblFarmAddress);
        JTextField FAddressField = new JTextField();
        FAddressField.setColumns(10);
        FAddressField.setBounds(300, 409, 202, 23);
        getContentPane().add(FAddressField);
        JButton btnAddSupplier = new JButton("MAKE EDIT");
        btnAddSupplier.addActionListener((e) -> {
        });
        btnAddSupplier.setForeground(Color.BLACK);
        btnAddSupplier.setBackground(new Color(25, 25, 112));
        btnAddSupplier.setBounds(325, 443, 140, 23);
        getContentPane().add(btnAddSupplier);
        newuser.date();
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setBounds(43, 231, 193, 29);
        getContentPane().add(comboBox);
        JLabel lblToEditA = new JLabel("Choose Supplier to Edit ");
        lblToEditA.setHorizontalAlignment(0);
        lblToEditA.setBounds(43, 209, 193, 14);
        getContentPane().add(lblToEditA);
        JButton btnBack = new JButton("BACK");
        btnBack.addActionListener((e) -> {
            this.getFrame().dispose();
            New_ExtSupplierUI previous = null;

            previous = new New_ExtSupplierUI();

            previous.getFrame().setVisible(true);

        });
        btnBack.setBackground(Color.WHITE);
        btnBack.setBounds(10, 11, 89, 23);
        getContentPane().add(btnBack);
    }

    JFrame getFrame() {
        return this;
    }
}
