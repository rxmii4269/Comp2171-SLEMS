package Security;

import UI.HomeUI;
import User.User;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class LoginUI {
    private String username;
    private JFrame frame;
    private JPasswordField passwordField;
    private JTextField UsernameField;
    private String Password = "";
    private String savedU;

//    public LoginUI() throws IOException, FontFormatException {
//        this.initialize();
//    }

    public static void main(String[] args) throws IOException, FontFormatException {
        LoginUI ui = new LoginUI();
        ui.initialize();
    }

    public void initialize() throws IOException, FontFormatException {

        this.frame = new JFrame();
        this.frame.getContentPane().setBackground(Color.WHITE);
        this.frame.setBounds(100, 100, 570, 520);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.getContentPane().setLayout(null);
        JLabel label = new JLabel("WELCOME TO ");
        label.setForeground(SystemColor.controlDkShadow);
        label.setHorizontalAlignment(0);
        label.setFont(new Font("Noto Sans",Font.BOLD,30));
        label.setBounds(0, 27, 554, 23);
        this.frame.getContentPane().add(label);
        JLabel lblNewLabel = new JLabel("SUPER FRESH EGGS");
        lblNewLabel.setForeground(new Color(25, 25, 112));
        lblNewLabel.setHorizontalAlignment(0);
        lblNewLabel.setFont(new Font("Noto Sans", Font.BOLD, 30));
        lblNewLabel.setBounds(73, 45, 408, 35);
        this.frame.getContentPane().add(lblNewLabel);
        JLabel lblNewLabel_1 = new JLabel("MANAGEMENT SYSTEM");
        lblNewLabel_1.setForeground(SystemColor.controlDkShadow);
        lblNewLabel_1.setHorizontalAlignment(0);
        lblNewLabel_1.setFont(new Font("Noto Sans", Font.BOLD, 20));
        lblNewLabel_1.setBounds(158, 89, 262, 23);
        this.frame.getContentPane().add(lblNewLabel_1);
        JLabel lblNewLabel_2 = new JLabel("Username ");
        lblNewLabel_2.setFont(new Font("Noto Sans", Font.PLAIN, 18));
        lblNewLabel_2.setBounds(127, 163, 108, 14);
        this.frame.getContentPane().add(lblNewLabel_2);
        this.setPassword(new JPasswordField());
        this.passwordField.setBounds(127, 274, 310, 43);
        this.frame.getContentPane().add(this.getPassword());
        this.setUsername(new JTextField());
        this.UsernameField.setBounds(127, 188, 310, 43);
        this.frame.getContentPane().add(this.getUsername());
        this.UsernameField.setColumns(10);
        JLabel lblPassword = new JLabel("Password ");
        lblPassword.setFont(new Font("Noto Sans", Font.PLAIN, 18));
        lblPassword.setBounds(127, 249, 108, 14);
        this.frame.getContentPane().add(lblPassword);
        JButton btnLogin = new JButton("Login ");
        btnLogin.setFont(new Font("Noto Sans",Font.BOLD,13));
        this.frame.getRootPane().setDefaultButton(btnLogin);
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setBackground(new Color(25, 25, 112));
        btnLogin.addActionListener((e) -> {
            char[] password = this.getPassword().getPassword();
            for (char s : password) {
                String tmp = this.Password;
                this.Password = tmp + s;
            }
            username = this.getUsername().getText();
            User user = new User();
            if (user.Login(username,Password).contains("Successful")) {
                JOptionPane.showMessageDialog(getFrame(), user.Login(username, Password), "SLEMS", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(HomeUI.class.getResource("/check-mark.png")));
                getFrame().getContentPane().removeAll();
                getFrame().repaint();
            }
            else
                JOptionPane.showMessageDialog(getFrame(),user.Login(username,Password),"SLEMS",JOptionPane.WARNING_MESSAGE);

        });
        btnLogin.setBounds(199, 374, 168, 34);
        this.frame.getContentPane().add(btnLogin);
        JButton btnExit = new JButton("Exit");
        btnExit.setFont(new Font("Noto Sans",Font.BOLD,13));
        btnExit.setForeground(Color.WHITE);
        btnExit.setBackground(new Color(25, 25, 112));
        btnExit.setBounds(281, 430, 131, 28);
        btnExit.addActionListener((e) -> {
            this.setFrame(new JFrame("Exit"));
            if (JOptionPane.showConfirmDialog(this.getFrame(), "Confirm Exit", "Login Systems", JOptionPane.YES_NO_OPTION) == 0) {
                this.getUsername().setText(null);
                this.getPassword().setText(null);
                System.exit(0);
            } else {
                this.getUsername().grabFocus();
            }

        });
        this.frame.getContentPane().add(btnExit);
        JButton btnReset = new JButton("Reset");
        btnReset.setFont(new Font("Noto Sans",Font.BOLD,13));
        btnReset.setForeground(Color.WHITE);
        btnReset.setBackground(new Color(25, 25, 112));
        btnReset.setBounds(140, 430, 131, 28);
        btnReset.addActionListener((e) -> {
            this.getUsername().setText(null);
            this.getPassword().setText(null);
            this.getUsername().grabFocus();
        });
        this.frame.getContentPane().add(btnReset);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return this.frame;
    }

    private void setFrame(JFrame frame) {
        this.frame = frame;
    }

    private JTextField getUsername() {
        return this.UsernameField;
    }

    private void setUsername(JTextField username) {
        this.UsernameField = username;
    }

    private JPasswordField getPassword() {
        return this.passwordField;
    }

    private void setPassword(JPasswordField password) {
        this.passwordField = password;
    }

    public String getSavedU() {
        return this.savedU;
    }

    public void setSavedU(String savedU) {
        this.savedU = savedU;
    }
}
