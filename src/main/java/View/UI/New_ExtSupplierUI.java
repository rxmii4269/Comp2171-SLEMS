package View.UI;

import Model.Database.DB_Main;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

class New_ExtSupplierUI extends JFrame {

    private JTextField CompanyName;
    private JTextField AmtEggField;
    private JTextField EEmailField;
    private JTextField EPhoneField;
    private JTextField EFAddressField;
    private DB_Main db;
    private Integer count = Math.toIntExact(System.nanoTime() / 100000);


    public void initialize() {

        setSize(600,600);
        getContentPane().setBackground(Color.WHITE);
        setBounds(100, 100, 570, 520);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setFocusable(true);
        getContentPane().setLayout(null);
        New_UserUI new_userUI = new New_UserUI();
        new_userUI.data3();
        this.CompanyName = new JTextField();
        this.CompanyName.setBounds(49, 184, 202, 23);
        getContentPane().add(this.CompanyName);
        this.CompanyName.setColumns(10);
        JLabel company_name = new JLabel("Company Name");
        company_name.setFont(new Font("Arial", Font.BOLD, 15));
        company_name.setBounds(49, 159, 120, 14);
        getContentPane().add(company_name);
        JLabel lblEmailAddress = new JLabel("Email Address");
        lblEmailAddress.setFont(new Font("Arial", Font.BOLD, 15));
        lblEmailAddress.setBounds(49, 218, 108, 14);
        getContentPane().add(lblEmailAddress);
        this.EEmailField = new JTextField();
        this.EEmailField.setColumns(10);
        this.EEmailField.setBounds(49, 244, 202, 23);
        getContentPane().add(this.EEmailField);
        JLabel lblPhoneNumber = new JLabel("Phone Number");
        lblPhoneNumber.setFont(new Font("Arial", Font.BOLD, 15));
        lblPhoneNumber.setBounds(49, 280, 120, 14);
        getContentPane().add(lblPhoneNumber);
        this.EPhoneField = new JTextField();
        this.EPhoneField.setColumns(10);
        this.EPhoneField.setBounds(49, 306, 202, 23);
        getContentPane().add(this.EPhoneField);
        JLabel lblNewLabel_3 = new JLabel("EXTERNAL SUPPLIERS");
        lblNewLabel_3.setForeground(SystemColor.windowBorder);
        lblNewLabel_3.setHorizontalAlignment(0);
        lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));
        lblNewLabel_3.setBounds(168, 132, 219, 28);
        getContentPane().add(lblNewLabel_3);
        JLabel lblFarmAddress = new JLabel("Farm Address");
        lblFarmAddress.setFont(new Font("Arial", Font.BOLD, 15));
        lblFarmAddress.setBounds(49, 342, 108, 14);
        getContentPane().add(lblFarmAddress);
        this.EFAddressField = new JTextField();
        this.EFAddressField.setColumns(10);
        this.EFAddressField.setBounds(49, 368, 202, 23);
        getContentPane().add(this.EFAddressField);
        JLabel amountOfEggs = new JLabel("Amount of Eggs");
        amountOfEggs.setFont(new Font("Arial", Font.BOLD, 15));
        amountOfEggs.setBounds(49, 404, 108, 14);
        getContentPane().add(amountOfEggs);
        this.AmtEggField = new JTextField();
        this.AmtEggField.setColumns(10);
        this.AmtEggField.setBounds(49, 430, 202, 23);
        getContentPane().add(this.AmtEggField);
        JButton btnEditExistingSuppliers = new JButton("Edit Existing Suppliers");
        btnEditExistingSuppliers.setForeground(Color.WHITE);
        btnEditExistingSuppliers.setBackground(new Color(25, 25, 112));
        btnEditExistingSuppliers.setBounds(334, 279, 168, 34);
        getContentPane().add(btnEditExistingSuppliers);
        btnEditExistingSuppliers.addActionListener((e) -> {
            this.getFrame().dispose();
            EditSupplier_UI edit = null;
            try {
                edit = new EditSupplier_UI();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            assert edit != null;
            edit.getFrame().setVisible(true);
        });
        JButton btnDeleteSupplier = new JButton("Delete Supplier");
        btnDeleteSupplier.setForeground(Color.WHITE);
        btnDeleteSupplier.setBackground(new Color(25, 25, 112));
        btnDeleteSupplier.setBounds(334, 220, 168, 34);
        getContentPane().add(btnDeleteSupplier);
        btnDeleteSupplier.addActionListener((e) -> {
            this.getFrame().dispose();
            Delete_SupplierUI delete = null;
            try {
                delete = new Delete_SupplierUI();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            assert delete != null;
            delete.getFrame().setVisible(true);
        });

        JButton addSupplier = new JButton("Add Supplier");
        addSupplier.setForeground(Color.WHITE);
        addSupplier.setBackground(new Color(25, 25, 112));
        addSupplier.setBounds(334, 350, 168, 23);
        addSupplier.addActionListener((e) -> {

            db = new DB_Main();
            String companyName = getCompanyName().getText();
            String emailAddress = getEEmailField().getText();
            String phoneNumber = getEPhoneField().getText();
            String address = getEFAddressField().getText();
            String amount_of_Eggs = getAmtEggField().getText();
            count++;
            Object[] newExtSupplier = {count,companyName,emailAddress,phoneNumber,address,amount_of_Eggs};
            System.out.println(Arrays.toString(newExtSupplier));

            try {

                db.insert("external_supplier",newExtSupplier);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            JOptionPane.showMessageDialog(this.getFrame(), "Supplier added", "SLEMS", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(this.getClass().getResource("/check-mark.png")));
        });
        getContentPane().add(addSupplier);
        JButton btnBack = new JButton("BACK");
        btnBack.addActionListener((e) -> {
            this.getFrame().dispose();
            HomeUI home = new HomeUI();
            home.getFrame().setVisible(true);
        });
        btnBack.setBackground(Color.WHITE);
        btnBack.setBounds(10, 11, 89, 23);
        getContentPane().add(btnBack);
    }

    JFrame getFrame() {
        return this;
    }

    private JTextField getCompanyName() {
        return this.CompanyName;
    }

    private JTextField getAmtEggField() {
        return this.AmtEggField;
    }

    private JTextField getEEmailField() {
        return this.EEmailField;
    }

    private JTextField getEPhoneField() {
        return this.EPhoneField;
    }

    private JTextField getEFAddressField() {
        return this.EFAddressField;
    }
}
