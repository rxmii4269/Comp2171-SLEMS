package View.UI;

import Data.ExternalEggSupplier;
import Data.ExternalEggSupply;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

class New_ExtSupplierUI extends JFrame {

    private JTextField CompanyName;
    private JTextField AmtEggField;
    private JTextField EEmailField;
    private JTextField EPhoneField;
    private JTextField EFAddressField;
    private final FileWriter writeTable;
    private final PrintWriter out;
    private final ExternalEggSupplier externalEggSupplier;
    private final ArrayList<String> details;
    private final String formatStr;

    New_ExtSupplierUI() throws IOException {
        this.writeTable = new FileWriter("Supplier Info.txt", StandardCharsets.UTF_8, true);
        BufferedWriter bw = new BufferedWriter(this.writeTable);
        this.out = new PrintWriter(bw);
        this.externalEggSupplier = new ExternalEggSupplier();
        this.details = new ArrayList<>();
        this.formatStr = "%-30s %-30s %-30s %-20s %-20s%n";
        this.initialize();
    }

    private void initialize() throws IOException {
        getContentPane().setBackground(Color.WHITE);
        setBounds(100, 100, 570, 520);
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
        JLabel label_1 = new JLabel("Company Name");
        label_1.setFont(new Font("Arial", Font.BOLD, 15));
        label_1.setBounds(49, 159, 120, 14);
        getContentPane().add(label_1);
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
        JLabel lblNewLabel_2 = new JLabel("Amount of Eggs");
        lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
        lblNewLabel_2.setBounds(49, 404, 108, 14);
        getContentPane().add(lblNewLabel_2);
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

        new_userUI.date();
        JButton button_2 = new JButton("Add Supplier");
        button_2.setForeground(Color.WHITE);
        button_2.setBackground(new Color(25, 25, 112));
        button_2.setBounds(334, 350, 168, 23);
        button_2.addActionListener((e) -> {
            this.out.print(String.format(this.formatStr, "Company Name", "Email Address", "Phone Number", "Farm Address", "Amount of Eggs"));
            this.details.add(this.getCompanyName().getText());
            this.details.add(this.getEEmailField().getText());
            this.details.add(this.getEPhoneField().getText());
            this.details.add(this.getEFAddressField().getText());
            this.details.add(this.getAmtEggField().getText());
            this.externalEggSupplier.externalEggSupplier.add(this.getCompanyName().getText());
            this.externalEggSupplier.externalEggSupplier.add(this.getEEmailField().getText());
            this.externalEggSupplier.externalEggSupplier.add(this.getEPhoneField().getText());
            this.externalEggSupplier.externalEggSupplier.add(this.getEFAddressField().getText());
            this.externalEggSupplier.externalEggSupplier.add(this.getAmtEggField().getText());
            new ExternalEggSupply(this.getAmtEggField().getText());

            assert this.writeTable != null;

            this.out.print(String.format(this.formatStr, this.details.get(0), this.details.get(1), this.details.get(2), this.details.get(3), this.details.get(4)));
            this.out.close();
            JOptionPane.showMessageDialog(this.getFrame(), "Supplier added", "SLEMS", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(this.getClass().getResource("/check-mark.png")));
        });
        getContentPane().add(button_2);
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
