package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MenuViewer {

    private JFrame frame;

    public void run() {

        this.frame = new JFrame();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setTitle("MENU");
        this.frame.setVisible(true);
        this.frame.setSize(500,500);

        JPanel panelCentral = new JPanel();
        this.frame.add(panelCentral, BorderLayout.CENTER);

        panelCentral.setBorder(
                BorderFactory.createTitledBorder("Modo de Jogo")
        );
        panelCentral.setLayout(new GridLayout(2,1));

        JButton singlePlayerButton = new JButton("Singleplayer");
        JButton multiPlayerButton = new JButton("Multiplayer");

        Font font = new Font("TimesRoman", Font.BOLD, 40);
        singlePlayerButton.setFont(font);
        multiPlayerButton.setFont(font);

        singlePlayerButton.addActionListener(this::singlePlayerButtonClick);
        multiPlayerButton.addActionListener(this::multiPlayerButtonClick);

        panelCentral.add(singlePlayerButton);
        panelCentral.add(multiPlayerButton);

    }

    private void singlePlayerButtonClick(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Ainda não disponivel!");
    }

    private void multiPlayerButtonClick(ActionEvent event) {
        JOptionPane.showMessageDialog(null, "Ainda não disponivel!");
    }

}
