package view;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormPrincipal extends JFrame {
    private JPanel pnlMain;
    private JPanel pnlHeader;
    private JButton fornecedoresButton;
    private JButton produtosButton;
    private JButton PDVButton;
    private JButton vendasButton;
    private JButton sairButton;
    private JPanel pnlBody;
    private JPanel pnlFooter;
    private JLabel lblSobre;
    private JPanel pnlProdutosBox;
    private JPanel dashboardBox;
    private JLabel subtitle;
    private JLabel lblData;

    public FormPrincipal() {
        setSize(1000, 600);

        setLocationRelativeTo(null);
        setContentPane(pnlMain);

        fornecedoresButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        produtosButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PDVButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vendasButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sairButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSobre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        LocalDate actualDate = LocalDate.now();
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        lblData.setText(actualDate.format(formattedDate));

        /* Teste position absolute
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(300, 200));

        pnlProdutosBox.setBounds(0, 0, 300, 200);
        iconProdutos.setBounds(240, 10, 50, 25);

        layeredPane.add(pnlProdutosBox, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(iconProdutos, JLayeredPane.PALETTE_LAYER); */
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}