package UI;

import javax.swing.*;
import java.awt.*;

public class Delete_UserUI {
    private JFrame frame;

    private Delete_UserUI() {
        this.initialize();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Delete_UserUI window = new Delete_UserUI();
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
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setBackground(Color.WHITE);
        comboBox.setBounds(184, 424, 193, 29);
        this.frame.getContentPane().add(comboBox);
        JLabel lblToEditA = new JLabel("Choose User to Delete");
        lblToEditA.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblToEditA.setHorizontalAlignment(0);
        lblToEditA.setBounds(184, 399, 193, 14);
        this.frame.getContentPane().add(lblToEditA);
        JTextField textField = new JTextField();
        textField.setBackground(UIManager.getColor("Button.background"));
        textField.setBounds(58, 129, 450, 257);
        this.frame.getContentPane().add(textField);
        textField.setColumns(10);
        JButton btnBack = new JButton("BACK");
        btnBack.addActionListener((e) -> {
        });
        btnBack.setBackground(Color.WHITE);
        btnBack.setBounds(10, 11, 89, 23);
        this.frame.getContentPane().add(btnBack);
        New_UserUI.date(this.frame);
    }
}
