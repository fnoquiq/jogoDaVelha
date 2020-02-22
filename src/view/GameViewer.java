package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameViewer {

    private JFrame frame;

    public static final int SINGLEPLAYER = 0;
    public static final int MULTIPLAYER = 1;
    private final int mode;

    public GameViewer(int mode) {
        this.mode = mode;
    }

    public void run() {

        this.frame = new JFrame();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setTitle("Game Viewer (" + this.mode + ")");
        this.frame.setVisible(true);
        this.frame.setSize(500,500);
        this.frame.setLayout(new BorderLayout());

        JPanel panelSuperior = new JPanel();
        JPanel panelCentral = new JPanel();
        JPanel panelInferior = new JPanel();
        this.frame.add(panelSuperior, BorderLayout.NORTH);
        this.frame.add(panelCentral, BorderLayout.CENTER);
        this.frame.add(panelInferior, BorderLayout.SOUTH);

        panelSuperior.setBorder(
                BorderFactory.createTitledBorder("Menu")
        );

        panelCentral.setBorder(
                BorderFactory.createTitledBorder("Tabuleiro")
        );

        panelInferior.setBorder(
                BorderFactory.createTitledBorder("Estatísticas")
        );

        this.renderTabuleiro(panelCentral);
    }

    private void renderTabuleiro(JPanel panelTabuleiro) {
        String startCharOnButton = ".";

        panelTabuleiro.setLayout(new GridLayout(3,3));

        JButton buttonPos11 = new JButton(startCharOnButton);
        JButton buttonPos12 = new JButton(startCharOnButton);
        JButton buttonPos13 = new JButton(startCharOnButton);
        JButton buttonPos21 = new JButton(startCharOnButton);
        JButton buttonPos22 = new JButton(startCharOnButton);
        JButton buttonPos23 = new JButton(startCharOnButton);
        JButton buttonPos31 = new JButton(startCharOnButton);
        JButton buttonPos32 = new JButton(startCharOnButton);
        JButton buttonPos33 = new JButton(startCharOnButton);

        Font font = new Font("TimesRoman", Font.BOLD, 40);
        buttonPos11.setFont(font);
        buttonPos12.setFont(font);
        buttonPos13.setFont(font);
        buttonPos21.setFont(font);
        buttonPos22.setFont(font);
        buttonPos23.setFont(font);
        buttonPos31.setFont(font);
        buttonPos32.setFont(font);
        buttonPos33.setFont(font);

        panelTabuleiro.add(buttonPos11);
        panelTabuleiro.add(buttonPos12);
        panelTabuleiro.add(buttonPos13);
        panelTabuleiro.add(buttonPos21);
        panelTabuleiro.add(buttonPos22);
        panelTabuleiro.add(buttonPos23);
        panelTabuleiro.add(buttonPos31);
        panelTabuleiro.add(buttonPos32);
        panelTabuleiro.add(buttonPos33);

        buttonPos11.addActionListener(this::buttonPos11Click);
        buttonPos12.addActionListener(this::buttonPos12Click);
        buttonPos13.addActionListener(this::buttonPos13Click);
        buttonPos21.addActionListener(this::buttonPos21Click);
        buttonPos22.addActionListener(this::buttonPos22Click);
        buttonPos23.addActionListener(this::buttonPos23Click);
        buttonPos31.addActionListener(this::buttonPos31Click);
        buttonPos32.addActionListener(this::buttonPos32Click);
        buttonPos33.addActionListener(this::buttonPos33Click);
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
