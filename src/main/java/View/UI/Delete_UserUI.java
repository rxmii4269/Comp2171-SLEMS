package View.UI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Delete_UserUI extends JFrame {

    private Delete_UserUI() throws IOException {
        this.initialize();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Delete_UserUI window = new Delete_UserUI();
                window.setVisible(true);
            } catch (Exception var1) {
                var1.printStackTrace();
            }

        });
    }

    private void initialize() throws IOException {
        getContentPane().setBackground(Color.WHITE);
        setBounds(100, 100, 570, 520);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setFocusable(true);
        getContentPane().setLayout(null);
        New_UserUI new_userUI = new New_UserUI();
        new_userUI.data3();
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setBackground(Color.WHITE);
        comboBox.setBounds(184, 424, 193, 29);
        getContentPane().add(comboBox);
        JLabel lblToEditA = new JLabel("Choose View.UI.User to Delete");
        lblToEditA.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblToEditA.setHorizontalAlignment(0);
        lblToEditA.setBounds(184, 399, 193, 14);
        getContentPane().add(lblToEditA);
        JTextField textField = new JTextField();
        textField.setBackground(UIManager.getColor("Button.background"));
        textField.setBounds(58, 129, 450, 257);
        getContentPane().add(textField);
        textField.setColumns(10);
        JButton btnBack = new JButton("BACK");
        btnBack.addActionListener((e) -> {
        });
        btnBack.setBackground(Color.WHITE);
        btnBack.setBounds(10, 11, 89, 23);
        getContentPane().add(btnBack);
        New_UserUI new_userUI1 = new New_UserUI();
        new_userUI1.date();
    }
}
