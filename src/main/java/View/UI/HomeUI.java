package View.UI;

import View.Security.LoginUI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HomeUI {
    private JFrame frame;
    private JButton btnExternalSup;

    public HomeUI() {
        this.initialize();
    }



    private void initialize() {
        this.frame = new JFrame();
        this.frame.getContentPane().setBackground(Color.WHITE);
        this.frame.setBounds(100, 100, 570, 550);
        closeFrame(this.frame);
        JLabel label = new JLabel();
        label.setBounds(10, 22, 554, 23);
        this.frame.getContentPane().add(label);
        JLabel lblNewLabel = new JLabel("SUPER FRESH EGGS");
        lblNewLabel.setForeground(new Color(25, 25, 112));
        lblNewLabel.setHorizontalAlignment(0);
        lblNewLabel.setFont(new Font("Poetsen One", Font.BOLD, 40));
        lblNewLabel.setBounds(50, 38, 500, 48);
        this.frame.getContentPane().add(lblNewLabel);
        JLabel lblNewLabel_1 = new JLabel("MANAGEMENT SYSTEM");
        lblNewLabel_1.setForeground(SystemColor.controlDkShadow);
        lblNewLabel_1.setHorizontalAlignment(0);
        lblNewLabel_1.setFont(new Font("Ebrima", Font.BOLD, 22));
        lblNewLabel_1.setBounds(80, 84, 386, 23);
        this.frame.getContentPane().add(lblNewLabel_1);
        JLabel lblNewLabel_3 = new JLabel("HOME SCREEN");
        lblNewLabel_3.setForeground(SystemColor.windowBorder);
        lblNewLabel_3.setHorizontalAlignment(0);
        lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 25));
        lblNewLabel_3.setBounds(159, 118, 219, 28);
        this.frame.getContentPane().add(lblNewLabel_3);



        JTextArea textArea = new JTextArea();
        textArea.setBackground(UIManager.getColor("Button.background"));
        textArea.setForeground(Color.BLACK);
        textArea.setBounds(23, 157, 340, 301);
        this.frame.getContentPane().add(textArea);
        JButton btnViewSuppliers = new JButton("View Suppliers");
        btnViewSuppliers.setForeground(Color.WHITE);
        btnViewSuppliers.setBackground(new Color(25, 25, 112));
        btnViewSuppliers.setBounds(386, 270, 142, 28);
        this.frame.getContentPane().add(btnViewSuppliers);


        JButton btnLogout = new JButton("LOGOUT");
        btnLogout.setSize(50,30);
        btnLogout.setForeground(Color.BLACK);
        btnLogout.setBackground(Color.WHITE);
        btnLogout.addActionListener((e) -> {
            this.frame.dispose();
            LoginUI login;
            login = new LoginUI();
            login.setVisible(true);
        });
        btnLogout.setBounds(455, 8, 89, 23);
        this.frame.getContentPane().add(btnLogout);
        JButton btnViewOrders_1 = new JButton("View Orders");
        btnViewOrders_1.setForeground(Color.WHITE);
        btnViewOrders_1.setBackground(new Color(25, 25, 112));
        btnViewOrders_1.setBounds(386, 349, 142, 27);
        this.frame.getContentPane().add(btnViewOrders_1);
        btnViewOrders_1.addActionListener((e) -> {
            try {
                String content = new String(Files.readAllBytes(Paths.get("./Customer Info.txt")));
                textArea.append(content);
                textArea.setFont(new Font("Arial", Font.PLAIN, 12));
            } catch (IOException var5) {
                var5.printStackTrace();
            }

            try {
                textArea.read(new InputStreamReader(this.getClass().getResourceAsStream("./Customer Info.txt")), null);
            } catch (Exception var4) {
                var4.printStackTrace();
            }

        });
    }

    static void closeFrame(JFrame frame) {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setFocusable(true);
        frame.getContentPane().setLayout(null);
        JLabel label = new JLabel("WELCOME TO ");
        label.setForeground(SystemColor.controlDkShadow);
        label.setHorizontalAlignment(0);
        label.setFont(new Font("Ebrima", Font.BOLD, 24));
    }

    public JButton getSupBtn() {
        return this.btnExternalSup;
    }

    public JFrame getFrame() {
        return this.frame;
    }

    public void setBtnExternalSup(JButton btnExternalSup) {
        this.btnExternalSup = btnExternalSup;
    }
}
