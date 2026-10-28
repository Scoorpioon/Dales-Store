package view;

import connection.ConnectionFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

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
    private JLabel lblBanco;
    private JLabel lblDbSignal;

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

        lblSobre.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                showAbout();
            }
        });

        databaseStatus();
    }

    private void databaseStatus() {
        ConnectionFactory connection = new ConnectionFactory();

        if(connection.testConnection()) {
            lblBanco.setText("Banco conectado!");
        } else {
            lblBanco.setText("Banco desconectado.");

            ImageIcon icone = new ImageIcon(
                    getClass().getResource("/icons/green.png")
            );

            lblDbSignal.setIcon(
                    greenToRed(icone)
            );

            lblDbSignal.setForeground(Color.red);
            lblDbSignal.setBackground(Color.red);
        }
    }

    private void showAbout() {
        About about = new About();
        about.setVisible(true);
    }

    public static ImageIcon greenToRed(ImageIcon icone) {
        BufferedImage imagem = new BufferedImage(
                icone.getIconWidth(),
                icone.getIconHeight(),
                BufferedImage.TYPE_INT_ARGB
        );

        Graphics2D g = imagem.createGraphics();
        g.drawImage(icone.getImage(), 0, 0, null);
        g.dispose();

        for (int y = 0; y < imagem.getHeight(); y++) {
            for (int x = 0; x < imagem.getWidth(); x++) {
                Color pixel = new Color(imagem.getRGB(x, y), true);

                int r = pixel.getRed();
                int verde = pixel.getGreen();
                int b = pixel.getBlue();

                // Identifica pixels predominantemente verdes
                if (verde > r && verde > b) {
                    imagem.setRGB(x, y, new Color(
                            220,  // vermelho
                            0,
                            0,
                            pixel.getAlpha()
                    ).getRGB());
                }
            }
        }

        return new ImageIcon(imagem);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}