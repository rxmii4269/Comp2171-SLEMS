package View.UI;

import Data.Egg;
import Model.Database.DB_Main;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Enter_DataUI extends JFrame {
    private JTextField IDField;
    private JTextField ECollectedField;
    private JTextField ESpoiltField;
    private JTextField EBrokenField;
    private JTextField workstationS;
    private JTextField workstationN;
    private JButton btnSaveData;
    private JButton btnUnitsProducible;
    private int eggsSpoiled;
    private int eggsCollected;
    private int eggsBroken;

    public void initialize() {

        getContentPane().setBackground(Color.WHITE);
        setBounds(100, 100, 570, 520);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setFocusable(true);

        getContentPane().setLayout(null);
        New_UserUI newuser = new New_UserUI();
        newuser.data3();
        JLabel lblNewLabel_2 = new JLabel("Enter Workstation Section:");
        lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
        lblNewLabel_2.setBounds(33, 250, 202, 14);
        getContentPane().add(lblNewLabel_2);
        this.IDField = new JTextField();
        this.IDField.setBounds(33, 201, 202, 28);
        getContentPane().add(this.IDField);
        this.IDField.setColumns(10);
        JLabel lblEnterYourId = new JLabel("Enter your ID Number:");
        lblEnterYourId.setFont(new Font("Arial", Font.BOLD, 15));
        lblEnterYourId.setBounds(33, 176, 180, 14);
        getContentPane().add(lblEnterYourId);
        JLabel lblEmailAddress = new JLabel("Enter Workstation Number:");
        lblEmailAddress.setFont(new Font("Arial", Font.BOLD, 15));
        lblEmailAddress.setBounds(33, 336, 202, 14);
        getContentPane().add(lblEmailAddress);
        JLabel lblPleaseEnterSupervisor = new JLabel("Enter Eggs Collected:");
        lblPleaseEnterSupervisor.setHorizontalAlignment(2);
        lblPleaseEnterSupervisor.setFont(new Font("Arial", Font.BOLD, 15));
        lblPleaseEnterSupervisor.setBounds(295, 205, 174, 23);
        getContentPane().add(lblPleaseEnterSupervisor);
        this.ECollectedField = new JTextField();
        this.ECollectedField.setColumns(10);
        this.ECollectedField.setBounds(473, 202, 55, 23);
        getContentPane().add(this.ECollectedField);
        JLabel lblPleaseEnterEmployee = new JLabel("Enter Eggs Spoilt:");
        lblPleaseEnterEmployee.setHorizontalAlignment(2);
        lblPleaseEnterEmployee.setFont(new Font("Arial", Font.BOLD, 15));
        lblPleaseEnterEmployee.setBounds(295, 242, 168, 23);
        getContentPane().add(lblPleaseEnterEmployee);
        JLabel lblEnterEggsBroken = new JLabel("Enter Eggs Broken:");
        lblEnterEggsBroken.setHorizontalAlignment(2);
        lblEnterEggsBroken.setFont(new Font("Arial", Font.BOLD, 15));
        lblEnterEggsBroken.setBounds(295, 282, 161, 21);
        getContentPane().add(lblEnterEggsBroken);
        JLabel lblNewLabel_3 = new JLabel("ENTER DAILY DATA ");
        lblNewLabel_3.setForeground(SystemColor.windowBorder);
        lblNewLabel_3.setHorizontalAlignment(0);
        lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));
        lblNewLabel_3.setBounds(162, 137, 219, 28);
        getContentPane().add(lblNewLabel_3);
        DateTimeFormatter date = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        JLabel lblNewLabel_4 = new JLabel(date.format(now));
        lblNewLabel_4.setHorizontalAlignment(0);
        lblNewLabel_4.setBounds(175, 112, 206, 14);
        getContentPane().add(lblNewLabel_4);
        this.ESpoiltField = new JTextField();
        this.ESpoiltField.setColumns(10);
        this.ESpoiltField.setBounds(473, 238, 55, 23);
        getContentPane().add(this.ESpoiltField);
        this.EBrokenField = new JTextField();
        this.EBrokenField.setColumns(10);
        this.EBrokenField.setBounds(473, 280, 55, 23);
        getContentPane().add(this.EBrokenField);
        JButton btnGoHome = new JButton("Go Home");
        btnGoHome.addActionListener((e) -> {
            dispose();
            HomeUI home = new HomeUI();
            home.getFrame().setVisible(true);
        });
        btnGoHome.setForeground(Color.WHITE);
        btnGoHome.setBackground(new Color(25, 25, 112));
        btnGoHome.setBounds(22, 434, 147, 28);
        getContentPane().add(btnGoHome);
        JButton btnSaveData = new JButton("Save Data");
        btnSaveData.setForeground(Color.WHITE);
        btnSaveData.setBackground(new Color(25, 25, 112));
        btnSaveData.setBounds(191, 434, 147, 28);
        btnSaveData.addActionListener((e) -> {
            this.setEggsSpoiled(Integer.parseInt(this.ESpoiltField.getText()));
            this.setEggsCollected(Integer.parseInt(this.ECollectedField.getText()));
            this.setEggsBroken(Integer.parseInt(this.EBrokenField.getText()));
            new Egg(this.getIDField().getText(), date, this.getEggsCollected(), this.getEggsBroken(), this.getEggsSpoiled());

            Object [] Eggs={getIDField().getText(),getWorkstationS().getText(),getWorkstationN().getText(),getEggsCollected(),getEggsSpoiled(),getEggsBroken()};
            DB_Main db = new DB_Main();
            try {
                db.insert("inventory",Eggs);

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if (!this.getIDField().getText().equals("") && !this.getECollectedField().getText().equals("") && !this.getESpoiltField().getText().equals("") && !this.getEBrokenField().getText().equals("") && !this.getWorkstationS().getText().equals("") && !this.getWorkstationN().getText().equals("")) {
                JOptionPane.showMessageDialog(this.getFrame(), "Data saved", "SLEMS", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(this.getClass().getResource("/check-mark.png")));
                clearScreen();
            } else {
                JOptionPane.showMessageDialog(this.getFrame(), "Please Enter All Fields", "Missing Data", JOptionPane.ERROR_MESSAGE);
            }

        });
        getContentPane().add(btnSaveData);
        JButton btnUnitsProducible = new JButton("Units Producible");
        btnUnitsProducible.setForeground(Color.WHITE);
        btnUnitsProducible.setBackground(new Color(25, 25, 112));
        btnUnitsProducible.setBounds(361, 434, 147, 28);
        getContentPane().add(btnUnitsProducible);
        this.workstationS = new JTextField();
        this.workstationS.setColumns(10);
        this.workstationS.setBounds(33, 275, 202, 28);
        getContentPane().add(this.workstationS);
        this.workstationN = new JTextField();
        this.workstationN.setColumns(10);
        this.workstationN.setBounds(33, 361, 202, 28);
        getContentPane().add(this.workstationN);
        JButton btnBack = new JButton("BACK");
        btnBack.addActionListener((e) -> {
            this.getFrame().dispose();
            HomeUI home = new HomeUI();
            home.getFrame().setVisible(true);
        });
        btnBack.setBackground(Color.WHITE);
        btnBack.setBounds(10, 11, 89, 23);
        getContentPane().add(btnBack);
        setVisible(true);
    }

    JFrame getFrame() {
        return this;
    }

    private JTextField getWorkstationS() {
        return this.workstationS;
    }

    private JTextField getWorkstationN() {
        return this.workstationN;
    }

    private JTextField getIDField() {
        return this.IDField;
    }

    private JTextField getECollectedField() {
        return this.ECollectedField;
    }

    private JTextField getESpoiltField() {
        return this.ESpoiltField;
    }

    private JTextField getEBrokenField() {
        return this.EBrokenField;
    }

    public String toString() {
        int var10000 = this.getEggsCollected();
        return "Eggs Collected: " + var10000 + " " + this.getEggsBroken() + " " + this.getEggsBroken();
    }

    public void clearScreen(){
        ECollectedField.setText(null);
        ESpoiltField.setText(null);
        EBrokenField.setText(null);
    }
    public int getEggsCollected() {
        return this.eggsCollected;
    }

    private void setEggsCollected(int eggsCollected) {
        this.eggsCollected = eggsCollected;
    }

    public int getEggsSpoiled() {
        return this.eggsSpoiled;
    }

    private void setEggsSpoiled(int eggsSpoiled) {
        this.eggsSpoiled = eggsSpoiled;
    }

    public int getEggsBroken() {
        return this.eggsBroken;
    }

    private void setEggsBroken(int eggsBroken) {
        this.eggsBroken = eggsBroken;
    }

    public JButton getBtnSaveData() {
        return this.btnSaveData;
    }

    public void setBtnSaveData(JButton btnSaveData) {
        this.btnSaveData = btnSaveData;
    }

    public JButton getBtnUnitsProducible() {
        return this.btnUnitsProducible;
    }

    public void setBtnUnitsProducible(JButton btnUnitsProducible) {
        this.btnUnitsProducible = btnUnitsProducible;
    }
}
