package view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class WhoStartViewer {

    JFrame frame;

    public WhoStartViewer() {
        this.frame = new JFrame();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setTitle("SINGLEPLAYER");
        this.frame.setSize(500,500);
    }

    public void render() {
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(2,1));

        Font font = new Font("TimesRoman", Font.ITALIC, 20);

        panel.setBorder(
                BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(3, 4, 4, 3, Color.DARK_GRAY),"Escolha quem começa?", TitledBorder.CENTER,TitledBorder.DEFAULT_POSITION,font)
        );

        Font fontButtons = new Font("TimesRoman", Font.BOLD, 32);

        JPanel panelTop = new JPanel();
        panelTop.setLayout(new GridLayout(1,1));
        JButton buttonYouStart = new JButton("Você começa!");
        buttonYouStart.addActionListener(this::buttonYouStartClick);
        buttonYouStart.setFont(fontButtons);
        panelTop.add(buttonYouStart);

        JPanel panelBot = new JPanel();
        panelBot.setLayout(new GridLayout(1,1));
        JButton buttonBotStart = new JButton("O bot começa!");
        buttonBotStart.setFont(fontButtons);
        buttonBotStart.addActionListener(this::buttonBotStartClick);
        panelBot.add(buttonBotStart);

        panel.add(panelTop);
        panel.add(panelBot);

        this.frame.add(panel);
        this.frame.setVisible(true);
    }

    private void buttonYouStartClick(ActionEvent event) {
        GameViewer game = new GameViewer(GameViewer.SINGLEPLAYER_YOU_START);
        game.run();
        this.frame.dispose();
    }

    private void buttonBotStartClick(ActionEvent event) {
        GameViewer game = new GameViewer(GameViewer.SINGLEPLAYER_BOT_START);
        game.run();
        this.frame.dispose();
    }

}
