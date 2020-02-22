package view;

import controller.GameController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameViewer {

    private JFrame frame;

    public static final int SINGLEPLAYER = 0;
    public static final int MULTIPLAYER = 1;
    private final int mode;

    private JButton buttonPos11;
    private JButton buttonPos12;
    private JButton buttonPos13;
    private JButton buttonPos21;
    private JButton buttonPos22;
    private JButton buttonPos23;
    private JButton buttonPos31;
    private JButton buttonPos32;
    private JButton buttonPos33;

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

        this.buttonPos11 = new JButton(startCharOnButton);
        this.buttonPos12 = new JButton(startCharOnButton);
        this.buttonPos13 = new JButton(startCharOnButton);
        this.buttonPos21 = new JButton(startCharOnButton);
        this.buttonPos22 = new JButton(startCharOnButton);
        this.buttonPos23 = new JButton(startCharOnButton);
        this.buttonPos31 = new JButton(startCharOnButton);
        this.buttonPos32 = new JButton(startCharOnButton);
        this.buttonPos33 = new JButton(startCharOnButton);

        Font font = new Font("TimesRoman", Font.BOLD, 40);
        this.buttonPos11.setFont(font);
        this.buttonPos12.setFont(font);
        this.buttonPos13.setFont(font);
        this.buttonPos21.setFont(font);
        this.buttonPos22.setFont(font);
        this.buttonPos23.setFont(font);
        this.buttonPos31.setFont(font);
        this.buttonPos32.setFont(font);
        this.buttonPos33.setFont(font);

        panelChest.add(this.buttonPos11);
        panelChest.add(this.buttonPos12);
        panelChest.add(this.buttonPos13);
        panelChest.add(this.buttonPos21);
        panelChest.add(this.buttonPos22);
        panelChest.add(this.buttonPos23);
        panelChest.add(this.buttonPos31);
        panelChest.add(this.buttonPos32);
        panelChest.add(this.buttonPos33);

        this.buttonPos11.addActionListener(this::buttonPos11Click);
        this.buttonPos12.addActionListener(this::buttonPos12Click);
        this.buttonPos13.addActionListener(this::buttonPos13Click);
        this.buttonPos21.addActionListener(this::buttonPos21Click);
        this.buttonPos22.addActionListener(this::buttonPos22Click);
        this.buttonPos23.addActionListener(this::buttonPos23Click);
        this.buttonPos31.addActionListener(this::buttonPos31Click);
        this.buttonPos32.addActionListener(this::buttonPos32Click);
        this.buttonPos33.addActionListener(this::buttonPos33Click);
    }

    private void buttonPos11Click(ActionEvent event) {  JOptionPane.showMessageDialog(null, "Ainda não disponivel!");}
    private void buttonPos12Click(ActionEvent event) {  JOptionPane.showMessageDialog(null, "Ainda não disponivel!");}
    private void buttonPos13Click(ActionEvent event) {  JOptionPane.showMessageDialog(null, "Ainda não disponivel!");}
    private void buttonPos21Click(ActionEvent event) {  JOptionPane.showMessageDialog(null, "Ainda não disponivel!");}
    private void buttonPos22Click(ActionEvent event) {  JOptionPane.showMessageDialog(null, "Ainda não disponivel!");}
    private void buttonPos23Click(ActionEvent event) {  JOptionPane.showMessageDialog(null, "Ainda não disponivel!");}
    private void buttonPos31Click(ActionEvent event) {  JOptionPane.showMessageDialog(null, "Ainda não disponivel!");}
    private void buttonPos32Click(ActionEvent event) {  JOptionPane.showMessageDialog(null, "Ainda não disponivel!");}
    private void buttonPos33Click(ActionEvent event) {  JOptionPane.showMessageDialog(null, "Ainda não disponivel!");}
}
