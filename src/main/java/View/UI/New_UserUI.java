package View.UI;

import Model.Database.DB_Main;
import org.mindrot.jbcrypt.BCrypt;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class New_UserUI extends JFrame {
    private JTextField EmpIDField;
    ArrayList<String> details = new ArrayList<>();
    private JTextField FNameField;
    private JTextField LNameField;
    private JTextField EmailField;
    private JTextField phoneField;
    private JTextField PositionField;
    private DB_Main db;
    private Object[] newUser;

    public void initialize() {
        setBounds(100, 100, 570, 520);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setFocusable(true);
        getContentPane().setLayout(null);
        data3();
        JLabel lblNewLabel_2 = new JLabel("Last Name");
        lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
        lblNewLabel_2.setBounds(33, 246, 108, 14);
        add(lblNewLabel_2);
        this.FNameField = new JTextField();
        this.FNameField.setBounds(33, 201, 202, 23);
        add(this.FNameField);
        this.FNameField.setColumns(10);
        JButton btnEditUser = new JButton("EDIT USER");
        btnEditUser.setForeground(Color.WHITE);
        btnEditUser.setBackground(new Color(25, 25, 112));
        btnEditUser.setBounds(317, 419, 127, 33);
        add(btnEditUser);
        btnEditUser.addActionListener((e) -> {
            this.dispose();
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
        date();
        JButton saveBtn = new JButton("ADD USER");
        saveBtn.setForeground(Color.WHITE);
        saveBtn.setBackground(new Color(25, 25, 112));
        saveBtn.setBounds(317, 375, 127, 33);
        add(saveBtn);
        saveBtn.addActionListener((e) -> {
                data();
                db = new DB_Main();
                String id = details.get(0);
                String firstName = details.get(1);
                String lastName = details.get(2);
                String username = (firstName+lastName).toLowerCase();
                String password = BCrypt.hashpw(String.format("%s%s",id,username ),BCrypt.gensalt());
                String email = details.get(3);
                String telephone = details.get(4);
                String role = details.get(5);
                Object[] newUser = {id,firstName,lastName,username,password,email,telephone,role};
                System.out.println(Arrays.toString(newUser));
                try {
                    db.insert("employees",newUser);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            JOptionPane.showMessageDialog( this,"View.UI.User added", "SLEMS", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(this.getClass().getResource("/check-mark.png")));
        });
        JLabel label_1 = new JLabel("First Name");
        label_1.setFont(new Font("Arial", Font.BOLD, 15));
        label_1.setBounds(33, 176, 108, 14);
        add(label_1);
        this.LNameField = new JTextField();
        this.LNameField.setColumns(10);
        this.LNameField.setBounds(33, 272, 202, 23);
        add(this.LNameField);
        JLabel lblEmailAddress = new JLabel("Email Address");
        lblEmailAddress.setFont(new Font("Arial", Font.BOLD, 15));
        lblEmailAddress.setBounds(33, 317, 108, 14);
        add(lblEmailAddress);
        this.EmailField = new JTextField();
        this.EmailField.setColumns(10);
        this.EmailField.setBounds(33, 342, 202, 23);
        add(this.EmailField);
        JLabel lblPhoneNumber = new JLabel("Phone Number");
        lblPhoneNumber.setFont(new Font("Arial", Font.BOLD, 15));
        lblPhoneNumber.setBounds(33, 387, 108, 14);
        add(lblPhoneNumber);
        this.phoneField = new JTextField();
        this.phoneField.setColumns(10);
        this.phoneField.setBounds(33, 411, 202, 23);
        add(this.phoneField);
        JLabel lblPleaseEnterEmployee = new JLabel("Please Enter Employee ID");
        lblPleaseEnterEmployee.setHorizontalAlignment(2);
        lblPleaseEnterEmployee.setFont(new Font("Arial", Font.BOLD, 15));
        lblPleaseEnterEmployee.setBounds(276, 247, 268, 14);
        add(lblPleaseEnterEmployee);
        this.EmpIDField = new JTextField();
        this.EmpIDField.setColumns(10);
        this.EmpIDField.setBounds(279, 273, 202, 23);
        add(this.EmpIDField);
        JLabel label_2 = new JLabel("Please Enter Position");
        label_2.setHorizontalAlignment(2);
        label_2.setFont(new Font("Arial", Font.BOLD, 15));
        label_2.setBounds(276, 318, 268, 14);
        add(label_2);
        this.PositionField = new JTextField();
        this.PositionField.setColumns(10);
        this.PositionField.setBounds(276, 343, 202, 23);
        add(this.PositionField);
        JLabel lblNewLabel_3 = new JLabel("CREATE NEW USER ");
        lblNewLabel_3.setForeground(SystemColor.windowBorder);
        lblNewLabel_3.setHorizontalAlignment(0);
        lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));
        lblNewLabel_3.setBounds(162, 137, 219, 28);
        add(lblNewLabel_3);
        JButton btnBack = new JButton("BACK");
        btnBack.addActionListener((e) -> {
            this.dispose();
            HomeUI home = new HomeUI();
            home.getFrame().setVisible(true);
        });
        btnBack.setBackground(Color.WHITE);
        btnBack.setBounds(10, 11, 89, 23);
        add(btnBack);
    }

    void data3() {
        JLabel label = new JLabel("WELCOME TO ");
        label.setForeground(SystemColor.controlDkShadow);
        label.setHorizontalAlignment(0);
        label.setFont(new Font("Ebrima", Font.BOLD, 24));
        label.setBounds(0, 27, 554, 23);
        add(label);
        JLabel lblNewLabel = new JLabel("SUPER FRESH EGGS");
        lblNewLabel.setForeground(new Color(25, 25, 112));
        lblNewLabel.setHorizontalAlignment(0);
        lblNewLabel.setFont(new Font("Poetsen One", Font.BOLD, 40));
        lblNewLabel.setBounds(73, 45, 408, 48);
        add(lblNewLabel);
        JLabel lblNewLabel_1 = new JLabel("MANAGEMENT SYSTEM");
        lblNewLabel_1.setForeground(SystemColor.controlDkShadow);
        lblNewLabel_1.setHorizontalAlignment(0);
        lblNewLabel_1.setFont(new Font("Ebrima", Font.BOLD, 22));
        lblNewLabel_1.setBounds(158, 89, 260, 23);
        add(lblNewLabel_1);
    }

    private void data() {
        this.details.add(this.getEmpIDField().getText());
        this.details.add(this.getFNameField().getText());
        this.details.add(this.getLNameField().getText());
        this.details.add(this.getEmailField().getText());
        this.details.add(this.getPhoneField().getText());
        this.details.add(this.getPositionField().getText());
    }

    void date() {
        DateTimeFormatter date = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        JLabel lblNewLabel_4 = new JLabel(date.format(now));
        lblNewLabel_4.setHorizontalAlignment(0);
        lblNewLabel_4.setBounds(175, 112, 206, 14);
        add(lblNewLabel_4);
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

    private JTextField getEmpIDField() {
        return this.EmpIDField;
    }
}
