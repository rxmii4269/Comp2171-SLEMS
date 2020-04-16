package UI;

import Report.Report;
import Security.Login_UserUI;

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

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                HomeUI window = new HomeUI();
                window.frame.setVisible(true);
            } catch (Exception var1) {
                var1.printStackTrace();
            }

        });
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
        lblNewLabel.setBounds(70, 42, 408, 48);
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
        JButton btnNewButton = new JButton("Add/Edit  User");
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setBackground(new Color(25, 25, 112));
        btnNewButton.addActionListener((e) -> {
            this.frame.dispose();
            New_UserUI add_user = null;

            try {
                add_user = new New_UserUI();
            } catch (IOException var4) {
                var4.printStackTrace();
            }

            if (add_user != null) {
                add_user.getFrame().setVisible(true);
            }

        });
        btnNewButton.setBounds(386, 180, 142, 29);
        this.frame.getContentPane().add(btnNewButton);
        JButton btnExternalSup = new JButton("Add/ Edit Supplier");
        btnExternalSup.addActionListener((e) -> {
            this.frame.dispose();
            New_ExtSupplierUI supplierUI = null;

            try {
                supplierUI = new New_ExtSupplierUI();
            } catch (IOException var4) {
                var4.printStackTrace();
            }

            if (supplierUI != null) {
                supplierUI.getFrame().setVisible(true);
            }

        });
        btnExternalSup.setForeground(Color.WHITE);
        btnExternalSup.setBackground(new Color(25, 25, 112));
        btnExternalSup.setBounds(386, 231, 142, 28);
        this.frame.getContentPane().add(btnExternalSup);
        JButton btnAddOrders = new JButton("Add Order");
        btnAddOrders.addActionListener((e) -> {
            this.getFrame().dispose();
            New_OrderUI order = new New_OrderUI();
            order.getFrame().setVisible(true);
        });
        btnAddOrders.setForeground(Color.WHITE);
        btnAddOrders.setBackground(new Color(25, 25, 112));
        btnAddOrders.setBounds(386, 309, 142, 29);
        this.frame.getContentPane().add(btnAddOrders);
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
        JButton btnUpdateInventory = new JButton("Add/Edit Inventory");
        btnUpdateInventory.setForeground(Color.WHITE);
        btnUpdateInventory.setBackground(new Color(25, 25, 112));
        btnUpdateInventory.setBounds(386, 383, 142, 27);
        btnUpdateInventory.addActionListener((e) -> {
            this.frame.dispose();
            Enter_DataUI data = null;

            try {
                data = new Enter_DataUI();
            } catch (IOException var4) {
                var4.printStackTrace();
            }

            if (data != null) {
                data.getFrame().setVisible(true);
            }

        });
        this.frame.getContentPane().add(btnUpdateInventory);
        JButton btnGenerateReport_1 = new JButton("Generate Report");
        btnGenerateReport_1.setForeground(Color.WHITE);
        btnGenerateReport_1.setBackground(new Color(25, 25, 112));
        btnGenerateReport_1.setBounds(386, 421, 142, 27);
        btnGenerateReport_1.addActionListener((e) -> {
            Report report = null;

            try {
                report = new Report();
            } catch (IOException var5) {
                var5.printStackTrace();
            }

            if (report != null) {
                try {
                    report.generateReport();
                } catch (IOException var4) {
                    var4.printStackTrace();
                }
            }

            JOptionPane.showMessageDialog(this.getFrame(), "Report Successfully Created", "SLEMS", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(HomeUI.class.getResource("/check-mark.png")));
        });
        this.frame.getContentPane().add(btnGenerateReport_1);
        JButton btnLogout = new JButton("LOGOUT");
        btnLogout.setForeground(Color.BLACK);
        btnLogout.setBackground(Color.WHITE);
        btnLogout.addActionListener((e) -> {
            this.frame.dispose();
            Login_UserUI login = null;
            try {
                login = new Login_UserUI();
            } catch (IOException | FontFormatException ioException) {
                ioException.printStackTrace();
            }
            assert login != null;
            login.getFrame().setVisible(true);
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
