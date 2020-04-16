package UI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Delete_SupplierUI {
    private JFrame frame;

    Delete_SupplierUI() {
        this.initialize();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Delete_SupplierUI window = new Delete_SupplierUI();
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
        JTextArea textArea = new JTextArea();
        textArea.setBackground(UIManager.getColor("Button.background"));
        textArea.setBounds(58, 129, 450, 257);
        this.frame.getContentPane().add(textArea);
        textArea.setColumns(10);
        JComboBox<String> comboBox1 = new JComboBox<>();
        comboBox1.setBackground(Color.WHITE);
        comboBox1.setBounds(184, 412, 193, 29);
        this.frame.getContentPane().add(comboBox1);
        comboBox1.addItem("HHh");
        JLabel lblToEditA = new JLabel("Choose User to Delete");
        lblToEditA.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblToEditA.setHorizontalAlignment(0);
        lblToEditA.setBounds(184, 397, 193, 14);
        this.frame.getContentPane().add(lblToEditA);
        JButton btnNewButton = new JButton("DELETE");
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(25, 25, 112));
        btnNewButton.setBounds(234, 452, 89, 23);
        this.frame.getContentPane().add(btnNewButton);
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
        New_UserUI.date(this.frame);
    }

    JFrame getFrame() {
        return this.frame;
    }
}
