package View.UI;

import Model.Database.DB_Main;
import com.opencsv.CSVWriter;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminInterface extends JFrame {
    PrintWriter out;
    CSVWriter csvWriter;
    ResultSet rs;

    private JPanel card2;



    public void prepareGui() {
        setVisible(true);
        setTitle("SLEMS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        JPanel card1 = new JPanel(new GridBagLayout());
        card1.setBackground(new Color(255, 255, 255));
        JPanel btnPanel = new JPanel();
        JPanel cards = new JPanel(new CardLayout());
        JLabel title = new JLabel("<html>SLEMS Admin Interface<br>Select a button to start</html>");
        card1.add(title);
        card1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        cards.add(card1, "Card1");
        JButton generateReport = new JButton("Generate Report");
        JButton newUserBtn = new JButton("New User");
        btnPanel.add(generateReport);
        btnPanel.add(newUserBtn);
        getContentPane().add(cards, BorderLayout.CENTER);
        getContentPane().add(btnPanel, BorderLayout.SOUTH);

        newUserBtn.addActionListener(e -> {
            New_UserUI userUI = new New_UserUI();
            userUI.initialize();
            dispose();
        });

        generateReport.addActionListener(e -> {
            DB_Main db = new DB_Main();
            Object [] columns = {"*"};
            try {
                rs = db.select("employees",columns);
                csvWriter = new CSVWriter(new FileWriter("employees.csv",true),CSVWriter.DEFAULT_SEPARATOR,CSVWriter.NO_QUOTE_CHARACTER,CSVWriter.NO_ESCAPE_CHARACTER,CSVWriter.DEFAULT_LINE_END);
                csvWriter.writeAll(rs,true);
                csvWriter.close();
                rs = db.select("egg_supplies",columns);
                csvWriter = new CSVWriter(new FileWriter("eggs.csv",true),CSVWriter.DEFAULT_SEPARATOR,CSVWriter.NO_QUOTE_CHARACTER,CSVWriter.NO_ESCAPE_CHARACTER,CSVWriter.DEFAULT_LINE_END);
                csvWriter.writeAll(rs,true);
                csvWriter.close();
                rs = db.select("external_supplier",columns);
                csvWriter = new CSVWriter(new FileWriter("externalSupplier.csv",true),CSVWriter.DEFAULT_SEPARATOR,CSVWriter.NO_QUOTE_CHARACTER,CSVWriter.NO_ESCAPE_CHARACTER,CSVWriter.DEFAULT_LINE_END);
                csvWriter.writeAll(rs,true);
                csvWriter.close();
                rs = db.select("inventory",columns);
                csvWriter = new CSVWriter(new FileWriter("inventory.csv",true),CSVWriter.DEFAULT_SEPARATOR,CSVWriter.NO_QUOTE_CHARACTER,CSVWriter.NO_ESCAPE_CHARACTER,CSVWriter.DEFAULT_LINE_END);
                csvWriter.writeAll(rs,true);
                csvWriter.close();
                JOptionPane.showMessageDialog(this,"Report Created Successfully","SLEMS",JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException | IOException throwables) {
                throwables.printStackTrace();
            }
        });
    }
}
