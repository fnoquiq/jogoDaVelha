package view;

import controller.GameController;
import exception.ChestCaseOccupedException;
import model.Pos;
import util.Util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GameViewer {

    public static final int SINGLEPLAYER = 0;
    public static final int MULTIPLAYER = 1;
    public static final String PLAYER_1_CHAR = "X";
    public static final String PLAYER_2_CHAR = "O";
    public static final String NO_PLAYER_CHAR = ".";

    private JFrame frame;
    private final int mode;

    private ArrayList<JButton> buttonChess = new ArrayList();
    private JLabel currentPlayerLabel;

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

    private void refreshChest() {
        for (int i=0;i<9;i++) {
            Pos pos = Util.singleToPos(i);

            this.buttonChess.get(i).setText(this.playerCharDecode(this.gameController.chest[pos.x][pos.y]));
        }
        this.currentPlayerLabel.setText("Vez do Jogador:" + this.gameController.currentPlayer);
    }

    private String playerCharDecode(int i) {
        switch (i) {
            case -1:
                return GameViewer.PLAYER_1_CHAR;
            case 0:
                return GameViewer.NO_PLAYER_CHAR;
            case 1:
                return GameViewer.PLAYER_2_CHAR;
            default:
                return "Error";
        }
    }

    private void renderStatus(JPanel panelStatus) {
        this.currentPlayerLabel = new JLabel("Vez do Jogador: " + this.gameController.currentPlayer);
        panelStatus.add(this.currentPlayerLabel);

        JButton newGameButton = new JButton("Novo Jogo");
        newGameButton.addActionListener(this::buttonNewGameClick);
        panelStatus.add(newGameButton);
    }

    private void renderTabuleiro(JPanel panelChest) {
        String startCharOnButton = GameViewer.NO_PLAYER_CHAR;

        panelChest.setLayout(new GridLayout(3,3));

        Font font = new Font("TimesRoman", Font.BOLD, 40);

        for(int i=0;i<9;i++) {
            JButton button = new JButton(startCharOnButton);
            button.setFont(font);
            panelChest.add(button);

            this.buttonChess.add(button);
        }

        this.buttonChess.get(0).addActionListener(this::buttonPos1Click);
        this.buttonChess.get(1).addActionListener(this::buttonPos2Click);
        this.buttonChess.get(2).addActionListener(this::buttonPos3Click);
        this.buttonChess.get(3).addActionListener(this::buttonPos4Click);
        this.buttonChess.get(4).addActionListener(this::buttonPos5Click);
        this.buttonChess.get(5).addActionListener(this::buttonPos6Click);
        this.buttonChess.get(6).addActionListener(this::buttonPos7Click);
        this.buttonChess.get(7).addActionListener(this::buttonPos8Click);
        this.buttonChess.get(8).addActionListener(this::buttonPos9Click);
    }

    private void doPlay(Pos pos) {
        try {
            boolean isWinner = this.gameController.play(pos.x, pos.y);

            this.refreshChest();

            this.checkWinner(isWinner);

        } catch (ChestCaseOccupedException e) {
            this.occupedChest();
        }
    }

    private void checkWinner(boolean isWinner) {
        if (isWinner) {
            this.currentPlayerLabel.setText("Vencedor: " + this.gameController.winner);

            for (JButton button : this.buttonChess) {
                button.setEnabled(false);
            }
        }
    }

    private void occupedChest() {
        JOptionPane.showMessageDialog(null,"Ocupado!");
    }

    private void buttonNewGameClick(ActionEvent event) {
        this.gameController.reset();
        this.refreshChest();
        for (JButton button : this.buttonChess) {
            button.setEnabled(true);
        }
    }

    private void buttonPos1Click(ActionEvent event) {
        this.doPlay(Util.singleToPos(0));
    };
    private void buttonPos2Click(ActionEvent event) {
        this.doPlay(Util.singleToPos(1));
    }
    private void buttonPos3Click(ActionEvent event) {
        this.doPlay(Util.singleToPos(2));
    }
    private void buttonPos4Click(ActionEvent event) {
        this.doPlay(Util.singleToPos(3));
    }
    private void buttonPos5Click(ActionEvent event) {
        this.doPlay(Util.singleToPos(4));
    }
    private void buttonPos6Click(ActionEvent event) {
        this.doPlay(Util.singleToPos(5));
    }
    private void buttonPos7Click(ActionEvent event) {
        this.doPlay(Util.singleToPos(6));
    }
    private void buttonPos8Click(ActionEvent event) {
        this.doPlay(Util.singleToPos(7));
    }
    private void buttonPos9Click(ActionEvent event) { this.doPlay(Util.singleToPos(8)); }
}
