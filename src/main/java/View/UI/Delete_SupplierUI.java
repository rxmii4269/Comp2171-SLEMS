package View.UI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Delete_SupplierUI extends JFrame {


    Delete_SupplierUI() throws IOException {
        this.initialize();
    }


    private void initialize() throws IOException {

        getContentPane().setBackground(Color.WHITE);
        setBounds(100, 100, 570, 520);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setFocusable(true);
        getContentPane().setLayout(null);
        New_UserUI newUser = new New_UserUI();
        newUser.data3();
        JTextArea textArea = new JTextArea();
        textArea.setBackground(UIManager.getColor("Button.background"));
        textArea.setBounds(58, 129, 450, 257);
        getContentPane().add(textArea);
        textArea.setColumns(10);
        JComboBox<String> comboBox1 = new JComboBox<>();
        comboBox1.setBackground(Color.WHITE);
        comboBox1.setBounds(184, 412, 193, 29);
        getContentPane().add(comboBox1);
        comboBox1.addItem("HHh");
        JLabel lblToEditA = new JLabel("Choose View.UI.User to Delete");
        lblToEditA.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblToEditA.setHorizontalAlignment(0);
        lblToEditA.setBounds(184, 397, 193, 14);
        getContentPane().add(lblToEditA);
        JButton btnNewButton = new JButton("DELETE");
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(25, 25, 112));
        btnNewButton.setBounds(234, 452, 89, 23);
        getContentPane().add(btnNewButton);
        JButton btnBack = new JButton("BACK");
        btnBack.addActionListener((e) -> {
            this.getFrame().dispose();
            New_ExtSupplierUI previous = null;

            previous = new New_ExtSupplierUI();

            previous.getFrame().setVisible(true);

        });
        btnBack.setBackground(Color.WHITE);
        btnBack.setBounds(10, 11, 89, 23);
        getContentPane().add(btnBack);
        New_UserUI Newuser = new New_UserUI();
        Newuser.date();
    }

    JFrame getFrame() {
        return this;
    }
}
