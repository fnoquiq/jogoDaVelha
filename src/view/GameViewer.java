package view;

import controller.GameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GameViewer {

    private JFrame frame;

    public static final int SINGLEPLAYER = 0;
    public static final int MULTIPLAYER = 1;
    private final int mode;

    private ArrayList<JButton> buttonChess = new ArrayList();

    private GameController gameController;

    public GameViewer(int mode) {
        this.mode = mode;

        this.gameController = new GameController();
    }

    public void run() {

        this.frame = new JFrame();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setTitle("Game Viewer (" + this.mode + ")");
        this.frame.setVisible(true);
        this.frame.setSize(500,500);
        this.frame.setLayout(new BorderLayout());

        JPanel panelTop = new JPanel();
        JPanel panelMid = new JPanel();
        JPanel panelBot = new JPanel();
        this.frame.add(panelTop, BorderLayout.NORTH);
        this.frame.add(panelMid, BorderLayout.CENTER);
        this.frame.add(panelBot, BorderLayout.SOUTH);

        panelTop.setBorder(
                BorderFactory.createTitledBorder("Status")
        );

        panelMid.setBorder(
                BorderFactory.createTitledBorder("Tabuleiro")
        );

        panelBot.setBorder(
                BorderFactory.createTitledBorder("Estatísticas")
        );

        this.renderStatus(panelTop);
        this.renderTabuleiro(panelMid);
    }

    private void renderStatus(JPanel panelStatus) {
        JLabel currentPlayerLabel = new JLabel("Vez do Jogador: " + this.gameController.currentPlayer);
        panelStatus.add(currentPlayerLabel);
    }

    private void renderTabuleiro(JPanel panelChest) {
        String startCharOnButton = ".";

        panelChest.setLayout(new GridLayout(3,3));

        Font font = new Font("TimesRoman", Font.BOLD, 40);

        for(int i=0;i<9;i++) {
            JButton button = new JButton(startCharOnButton);
            button.setFont(font);
            panelChest.add(button);

            this.buttonChess.add(button);
        }

        this.buttonChess.get(0).addActionListener(this::buttonPos11Click);
        this.buttonChess.get(1).addActionListener(this::buttonPos12Click);
        this.buttonChess.get(2).addActionListener(this::buttonPos13Click);
        this.buttonChess.get(3).addActionListener(this::buttonPos21Click);
        this.buttonChess.get(4).addActionListener(this::buttonPos22Click);
        this.buttonChess.get(5).addActionListener(this::buttonPos23Click);
        this.buttonChess.get(6).addActionListener(this::buttonPos31Click);
        this.buttonChess.get(7).addActionListener(this::buttonPos32Click);
        this.buttonChess.get(8).addActionListener(this::buttonPos33Click);
    }

    private void buttonPos11Click(ActionEvent event) {  JOptionPane.showMessageDialog(null, "1");};
    private void buttonPos12Click(ActionEvent event) {  JOptionPane.showMessageDialog(null, "2");}
    private void buttonPos13Click(ActionEvent event) {  JOptionPane.showMessageDialog(null, "3");}
    private void buttonPos21Click(ActionEvent event) {  JOptionPane.showMessageDialog(null, "4");}
    private void buttonPos22Click(ActionEvent event) {  JOptionPane.showMessageDialog(null, "5");}
    private void buttonPos23Click(ActionEvent event) {  JOptionPane.showMessageDialog(null, "6");}
    private void buttonPos31Click(ActionEvent event) {  JOptionPane.showMessageDialog(null, "7");}
    private void buttonPos32Click(ActionEvent event) {  JOptionPane.showMessageDialog(null, "8");}
    private void buttonPos33Click(ActionEvent event) {  JOptionPane.showMessageDialog(null, "9");}
}
