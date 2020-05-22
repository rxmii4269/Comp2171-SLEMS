package View.Security;

import View.UI.AdminInterface;
import View.UI.Enter_DataUI;
import View.UI.LogControlUI;
import View.User.User;
import org.json.JSONObject;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class LoginUI extends JFrame {
    private final JTextField tfUserID;
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

        JLabel lbUserID = new JLabel("ID Number" +
                ": ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbUserID, cs);

        tfUserID = new JTextField(20);
        cs.gridx = 2;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(tfUserID, cs);

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

            if (tfUserID.getText().isEmpty()) {
                JOptionPane.showMessageDialog(getParent(), "Error in Fields Do not leave them Empty", "Login", JOptionPane.ERROR_MESSAGE);
            } else if (user.Login(getUserID(), getPassword()).contains("Success")) {
                JOptionPane.showMessageDialog(getParent(), String.format("Welcome %s", getJUsername(user.getUser())), "Login", JOptionPane.INFORMATION_MESSAGE);
                String role = user.getUser().getString("role").toLowerCase();
                switch (role) {
                    case "admin":
                        System.out.println(role);
                        dispose();
                        AdminInterface adminInterface = new AdminInterface();
                        adminInterface.prepareGui();
                        break;
                    case "logistician":
                        dispose();
                        LogControlUI logControlUI = new LogControlUI();
                        logControlUI.prepareGui();
                        break;
                    case "factoryworker":
                        dispose();
                        Enter_DataUI ui = new Enter_DataUI();
                        ui.initialize();
                        break;
                }




            } else {
                JOptionPane.showMessageDialog(getParent(), "Invalid ID or password", "Login", JOptionPane.ERROR_MESSAGE);
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

    public String getUserID() {
        return tfUserID.getText().trim();
    }

    public String getJUsername(JSONObject user) {
        return user.getString("username");
    }
    public String getPassword() {
        return new String(pfPassword.getPassword());
    }

}
