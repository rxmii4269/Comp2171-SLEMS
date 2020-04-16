package UI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Edit_UserUI {
    private JFrame frame;

    Edit_UserUI() throws IOException {
        this.initialize();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Edit_UserUI window = new Edit_UserUI();
                window.frame.setVisible(true);
            } catch (Exception var1) {
                var1.printStackTrace();
            }

        });
    }

    private void initialize() throws IOException {
        this.frame = new JFrame();
        this.frame.getContentPane().setBackground(Color.WHITE);
        this.frame.setBounds(100, 100, 570, 520);
        HomeUI.closeFrame(this.frame);
        Component label = null;
        assert false;
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
        JLabel lblNewLabel_2 = new JLabel("Last Name");
        lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
        lblNewLabel_2.setBounds(32, 333, 108, 14);
        this.frame.getContentPane().add(lblNewLabel_2);
        JTextField textField = new JTextField();
        textField.setBounds(32, 299, 202, 23);
        this.frame.getContentPane().add(textField);
        textField.setColumns(10);
        JButton btnLogin = new JButton("EDIT USER");
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setBackground(new Color(25, 25, 112));
        btnLogin.setBounds(304, 368, 154, 38);
        this.frame.getContentPane().add(btnLogin);
        JLabel label_1 = new JLabel("First Name");
        label_1.setFont(new Font("Arial", Font.BOLD, 15));
        label_1.setBounds(32, 274, 108, 14);
        this.frame.getContentPane().add(label_1);
        JTextField textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(32, 358, 202, 23);
        this.frame.getContentPane().add(textField_1);
        JLabel lblEmailAddress = new JLabel("Email Address");
        lblEmailAddress.setFont(new Font("Arial", Font.BOLD, 15));
        lblEmailAddress.setBounds(32, 392, 108, 14);
        this.frame.getContentPane().add(lblEmailAddress);
        JTextField textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(32, 417, 202, 23);
        this.frame.getContentPane().add(textField_2);
        JLabel lblPhoneNumber = new JLabel("Phone Number");
        lblPhoneNumber.setFont(new Font("Arial", Font.BOLD, 15));
        lblPhoneNumber.setBounds(289, 276, 108, 14);
        this.frame.getContentPane().add(lblPhoneNumber);
        JTextField textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(289, 301, 202, 23);
        this.frame.getContentPane().add(textField_3);
        JLabel lblPleaseEnterEmployee = new JLabel("Please Enter Employee ID");
        lblPleaseEnterEmployee.setHorizontalAlignment(2);
        lblPleaseEnterEmployee.setFont(new Font("Arial", Font.BOLD, 15));
        lblPleaseEnterEmployee.setBounds(32, 216, 215, 14);
        this.frame.getContentPane().add(lblPleaseEnterEmployee);
        JTextField textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setBounds(35, 242, 212, 23);
        this.frame.getContentPane().add(textField_5);
        JLabel lblEnterYourPosition = new JLabel("Enter your Position");
        lblEnterYourPosition.setHorizontalAlignment(2);
        lblEnterYourPosition.setFont(new Font("Arial", Font.BOLD, 15));
        lblEnterYourPosition.setBounds(286, 218, 268, 14);
        this.frame.getContentPane().add(lblEnterYourPosition);
        JTextField textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setBounds(286, 244, 202, 23);
        this.frame.getContentPane().add(textField_6);
        JLabel lblNewLabel_3 = new JLabel("EDIT USER");
        lblNewLabel_3.setForeground(SystemColor.windowBorder);
        lblNewLabel_3.setHorizontalAlignment(0);
        lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));
        lblNewLabel_3.setBounds(168, 123, 219, 28);
        this.frame.getContentPane().add(lblNewLabel_3);
        JLabel lblChooseUserTo = new JLabel("Choose User to Edit ");
        lblChooseUserTo.setHorizontalAlignment(0);
        lblChooseUserTo.setBounds(178, 156, 193, 14);
        this.frame.getContentPane().add(lblChooseUserTo);
        New_UserUI user = new New_UserUI();
        String[] array = user.details.toArray(new String[0]);
        JComboBox<String> comboBox = new JComboBox<>(array);
        comboBox.setEditable(true);
        comboBox.setBackground(Color.WHITE);
        comboBox.setBounds(178, 178, 193, 29);
        this.frame.getContentPane().add(comboBox);
        JButton btnBack = new JButton("BACK");
        btnBack.addActionListener((e) -> {
            this.getFrame().dispose();
            New_UserUI previous = null;

            try {
                previous = new New_UserUI();
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
        New_UserUI.date(this.frame);
    }

    JFrame getFrame() {
        return this.frame;
    }
}