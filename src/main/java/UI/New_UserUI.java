package UI;

import User.Position;
import User.Subordinate;
import User.Supervisor;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class New_UserUI {
    private JTextField EmpIDField;
    ArrayList<String> details = new ArrayList<>();
    private JFrame frame;
    private JTextField FNameField;
    private JTextField LNameField;
    private JTextField EmailField;
    private JTextField phoneField;
    private JTextField LetterSWField;
    private JTextField PositionField;
    private final FileWriter writeTable;
    private final PrintWriter out;
    private final String formatStr;

    public New_UserUI() throws IOException {
        this.writeTable = new FileWriter("User Info.txt", StandardCharsets.UTF_8, true);
        BufferedWriter bw = new BufferedWriter(this.writeTable);
        this.out = new PrintWriter(bw);
        this.formatStr = "%-30s %-30s %-30s %-30s %-20s %-15s%n";
        this.initialize();
    }

    private void initialize() {
        this.frame = new JFrame();
        this.frame.getContentPane().setBackground(Color.WHITE);
        this.frame.setBounds(100, 100, 570, 520);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.setFocusable(true);
        this.frame.getContentPane().setLayout(null);
        data3(this.frame);
        JLabel lblNewLabel_2 = new JLabel("Last Name");
        lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
        lblNewLabel_2.setBounds(33, 246, 108, 14);
        this.frame.getContentPane().add(lblNewLabel_2);
        this.FNameField = new JTextField();
        this.FNameField.setBounds(33, 201, 202, 23);
        this.frame.getContentPane().add(this.FNameField);
        this.FNameField.setColumns(10);
        JButton btnEditUser = new JButton("EDIT USER");
        btnEditUser.setForeground(Color.WHITE);
        btnEditUser.setBackground(new Color(25, 25, 112));
        btnEditUser.setBounds(317, 419, 127, 33);
        this.frame.getContentPane().add(btnEditUser);
        btnEditUser.addActionListener((e) -> {
            this.getFrame().dispose();
            Edit_UserUI edit = null;

            try {
                edit = new Edit_UserUI();
            } catch (IOException var4) {
                var4.printStackTrace();
            }

            if (edit != null) {
                edit.getFrame().setVisible(true);
            }

        });
        date(this.frame);
        JButton saveBtn = new JButton("ADD USER");
        saveBtn.setForeground(Color.WHITE);
        saveBtn.setBackground(new Color(25, 25, 112));
        saveBtn.setBounds(317, 375, 127, 33);
        this.frame.getContentPane().add(saveBtn);
        this.out.print(String.format(this.formatStr, "Employee ID", "First Name", "Last Name", "Email Address", "Phone Number", "Position"));
        saveBtn.addActionListener((e) -> {
            if (this.getLetterSWField().getText().equalsIgnoreCase("s")) {
                data();
                this.out.print(String.format(this.formatStr, this.details.get(0), this.details.get(1), this.details.get(2), this.details.get(3), this.details.get(4), this.details.get(5)));
                Supervisor.getInstance();
            } else if (this.getLetterSWField().getText().equalsIgnoreCase("w")) {
                data();

                assert this.writeTable != null;

                this.out.print(String.format(this.formatStr, this.details.get(0), this.details.get(1), this.details.get(2), this.details.get(3), this.details.get(4), this.details.get(5)));
                new Subordinate(this.getEmpIDField().getText(), this.getFNameField().getText(), this.getLNameField().getText(), this.getEmailField().getText(), Long.parseLong(this.getPhoneField().getText()), Position.Subordinate);
            } else {
                System.out.println("Please select the correct letters");
                System.out.println((new String(new char[50])).replace("\u0000", "\r\n"));
            }

            JOptionPane.showMessageDialog(this.getFrame(), "User added", "SLEMS", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(this.getClass().getResource("/check-mark.png")));
            this.out.close();
        });
        JLabel label_1 = new JLabel("First Name");
        label_1.setFont(new Font("Arial", Font.BOLD, 15));
        label_1.setBounds(33, 176, 108, 14);
        this.frame.getContentPane().add(label_1);
        this.LNameField = new JTextField();
        this.LNameField.setColumns(10);
        this.LNameField.setBounds(33, 272, 202, 23);
        this.frame.getContentPane().add(this.LNameField);
        JLabel lblEmailAddress = new JLabel("Email Address");
        lblEmailAddress.setFont(new Font("Arial", Font.BOLD, 15));
        lblEmailAddress.setBounds(33, 317, 108, 14);
        this.frame.getContentPane().add(lblEmailAddress);
        this.EmailField = new JTextField();
        this.EmailField.setColumns(10);
        this.EmailField.setBounds(33, 342, 202, 23);
        this.frame.getContentPane().add(this.EmailField);
        JLabel lblPhoneNumber = new JLabel("Phone Number");
        lblPhoneNumber.setFont(new Font("Arial", Font.BOLD, 15));
        lblPhoneNumber.setBounds(33, 387, 108, 14);
        this.frame.getContentPane().add(lblPhoneNumber);
        this.phoneField = new JTextField();
        this.phoneField.setColumns(10);
        this.phoneField.setBounds(33, 411, 202, 23);
        this.frame.getContentPane().add(this.phoneField);
        JLabel lblPleaseEnterSupervisor = new JLabel("Please Enter [S]upervisor or [W]orker");
        lblPleaseEnterSupervisor.setHorizontalAlignment(0);
        lblPleaseEnterSupervisor.setFont(new Font("Arial", Font.BOLD, 15));
        lblPleaseEnterSupervisor.setBounds(276, 176, 268, 14);
        this.frame.getContentPane().add(lblPleaseEnterSupervisor);
        this.LetterSWField = new JTextField();
        this.LetterSWField.setColumns(10);
        this.LetterSWField.setBounds(276, 202, 202, 23);
        this.frame.getContentPane().add(this.LetterSWField);
        JLabel lblPleaseEnterEmployee = new JLabel("Please Enter Employee ID");
        lblPleaseEnterEmployee.setHorizontalAlignment(2);
        lblPleaseEnterEmployee.setFont(new Font("Arial", Font.BOLD, 15));
        lblPleaseEnterEmployee.setBounds(276, 247, 268, 14);
        this.frame.getContentPane().add(lblPleaseEnterEmployee);
        this.EmpIDField = new JTextField();
        this.EmpIDField.setColumns(10);
        this.EmpIDField.setBounds(279, 273, 202, 23);
        this.frame.getContentPane().add(this.EmpIDField);
        JLabel label_2 = new JLabel("Please Enter Position");
        label_2.setHorizontalAlignment(2);
        label_2.setFont(new Font("Arial", Font.BOLD, 15));
        label_2.setBounds(276, 318, 268, 14);
        this.frame.getContentPane().add(label_2);
        this.PositionField = new JTextField();
        this.PositionField.setColumns(10);
        this.PositionField.setBounds(276, 343, 202, 23);
        this.frame.getContentPane().add(this.PositionField);
        JLabel lblNewLabel_3 = new JLabel("CREATE NEW USER ");
        lblNewLabel_3.setForeground(SystemColor.windowBorder);
        lblNewLabel_3.setHorizontalAlignment(0);
        lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));
        lblNewLabel_3.setBounds(162, 137, 219, 28);
        this.frame.getContentPane().add(lblNewLabel_3);
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

    static void data3(JFrame frame) {
        JLabel label = new JLabel("WELCOME TO ");
        label.setForeground(SystemColor.controlDkShadow);
        label.setHorizontalAlignment(0);
        label.setFont(new Font("Ebrima", Font.BOLD, 24));
        label.setBounds(0, 27, 554, 23);
        frame.getContentPane().add(label);
        JLabel lblNewLabel = new JLabel("SUPER FRESH EGGS");
        lblNewLabel.setForeground(new Color(25, 25, 112));
        lblNewLabel.setHorizontalAlignment(0);
        lblNewLabel.setFont(new Font("Poetsen One", Font.BOLD, 40));
        lblNewLabel.setBounds(73, 45, 408, 48);
        frame.getContentPane().add(lblNewLabel);
        JLabel lblNewLabel_1 = new JLabel("MANAGEMENT SYSTEM");
        lblNewLabel_1.setForeground(SystemColor.controlDkShadow);
        lblNewLabel_1.setHorizontalAlignment(0);
        lblNewLabel_1.setFont(new Font("Ebrima", Font.BOLD, 22));
        lblNewLabel_1.setBounds(158, 89, 260, 23);
        frame.getContentPane().add(lblNewLabel_1);
    }

    private void data() {
        this.details.add(this.getEmpIDField().getText());
        this.details.add(this.getFNameField().getText());
        this.details.add(this.getLNameField().getText());
        this.details.add(this.getEmailField().getText());
        this.details.add(this.getPhoneField().getText());
        this.details.add(this.getPositionField().getText());
    }

    static void date(JFrame frame) {
        DateTimeFormatter date = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        JLabel lblNewLabel_4 = new JLabel(date.format(now));
        lblNewLabel_4.setHorizontalAlignment(0);
        lblNewLabel_4.setBounds(175, 112, 206, 14);
        frame.getContentPane().add(lblNewLabel_4);
    }

    public JFrame getFrame() {
        return this.frame;
    }

    private JTextField getFNameField() {
        return this.FNameField;
    }

    private JTextField getLNameField() {
        return this.LNameField;
    }

    private JTextField getEmailField() {
        return this.EmailField;
    }

    private JTextField getPhoneField() {
        return this.phoneField;
    }

    private JTextField getPositionField() {
        return this.PositionField;
    }

    private JTextField getLetterSWField() {
        return this.LetterSWField;
    }

    private JTextField getEmpIDField() {
        return this.EmpIDField;
    }
}
