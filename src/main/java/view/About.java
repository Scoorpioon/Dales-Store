package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

public class About extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel lblTitle;
    private JLabel lblAuthor;
    private JLabel lblMIT;
    private JLabel lblGithub;

    public About() {
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(false);

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        setTitle("About me");
        //ImageIcon image = new ImageIcon(getClass().getResource("/icons/fa")) to sem favicon

        setModal(true);

        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
        lblGithub.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                openUrl("https://github.com/scoorpioon/Dales-Store");
            }
        });
    }

    private void onOK() {
        dispose();
    }

    private void openUrl(String url) {
        Desktop desk = Desktop.getDesktop();

        try {
            URI uri = new URI(url);
            desk.browse(uri);
        } catch(Exception error) {
            System.out.println("Error getting the url: " + error);
        }
    }
}
