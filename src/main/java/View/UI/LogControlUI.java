package View.UI;

import javax.swing.*;
import java.awt.*;

public class LogControlUI extends JFrame {


    private JPanel card2;




    public void prepareGui() {
        setVisible(true);
        setTitle("SLEMS");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 600);
        JPanel card1 = new JPanel(new GridBagLayout());
        JPanel btnPanel = new JPanel();
        JPanel cards = new JPanel(new CardLayout());
        JLabel title = new JLabel("<html>SLEMS Logistician Interface<br>Select a button to start</html>");
        title.setFont(new Font("Noto Sans",Font.BOLD,19));
        card1.add(title);
        card1.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        cards.add(card1, "Card1");
        JButton viewSupplies = new JButton("View Supplies");
        JButton addExternalSupplier = new JButton("Add External Supplier");
        btnPanel.add(viewSupplies);
        btnPanel.add(addExternalSupplier);
        getContentPane().add(cards, BorderLayout.CENTER);
        getContentPane().add(btnPanel, BorderLayout.SOUTH);


        addExternalSupplier.addActionListener(e -> {
            New_ExtSupplierUI extSupplierUI = new New_ExtSupplierUI();
            extSupplierUI.initialize();
            dispose();

        });

    }
}
