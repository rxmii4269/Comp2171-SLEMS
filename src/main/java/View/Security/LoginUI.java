package View.Security;

import View.UI.New_UserUI;
import View.User.User;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.IOException;

public class LoginUI extends JFrame {
    private final JTextField tfUsername;
    private final JPasswordField pfPassword;

    public LoginUI() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
        setSize(500, 500);
        setTitle("SLEMS");
        cs.fill = GridBagConstraints.HORIZONTAL;

        JLabel lbCompany = new JLabel("<html>WELCOME</html>");
        cs.gridx = 2;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbCompany, cs);

        JLabel lbUsername = new JLabel("Username: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbUsername, cs);

        tfUsername = new JTextField(20);
        cs.gridx = 2;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(tfUsername, cs);

        JLabel lbPassword = new JLabel("Password: ");
        cs.gridx = 0;
        cs.gridy = 2;
        cs.gridwidth = 1;
        panel.add(lbPassword, cs);

        pfPassword = new JPasswordField(20);
        cs.gridx = 2;
        cs.gridy = 2;
        cs.gridwidth = 2;
        panel.add(pfPassword, cs);
        panel.setBorder(new LineBorder(Color.GRAY));

        JButton btnLogin = new JButton("Login");

        btnLogin.addActionListener(e -> {
            User user = new User();

            if (tfUsername.getText().isEmpty()) {
                JOptionPane.showMessageDialog(getParent(), "Error in Fields Do not leave them Empty", "Login", JOptionPane.ERROR_MESSAGE);
            } else if (user.Login(getUsername(), getPassword()).contains("Success")) {
                JOptionPane.showMessageDialog(getParent(), String.format("Welcome %s", getUsername()), "Login", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                New_UserUI newuser = null;
                try {
                    newuser = new New_UserUI();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                assert newuser != null;
                newuser.getFrame().setVisible(true);

            } else {
                JOptionPane.showMessageDialog(getParent(), "Invalid username or password", "Login", JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(e -> dispose());

        JPanel bp = new JPanel();
        bp.add(btnLogin);
        bp.add(btnCancel);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);

//        pack();
        setResizable(false);
        setLocationRelativeTo(getParent());


    }

    public static void main(String[] args) {
        LoginUI ui = new LoginUI();
        ui.setVisible(true);
    }

    public String getUsername() {
        return tfUsername.getText().trim();
    }

    public String getPassword() {
        return new String(pfPassword.getPassword());
    }

}
