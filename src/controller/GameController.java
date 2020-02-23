package controller;

import exception.ChestCaseOccupedException;
import exception.OutOfChestException;

public class GameController {

    private static final int PLAYER_1 = 1;
    private static final int PLAYER_2 = -1;
    private static final int NO_PLAYER = 0;

    public int[][] chest = new int[3][3];
    public int winner = GameController.NO_PLAYER;
    public int currentPlayer = GameController.PLAYER_1;

    public GameController() {
        this.resetChest();
    }

    public boolean play(int x,int y) throws ChestCaseOccupedException {
        if (x<0 || x>3) {
            throw new OutOfChestException("Value of X is out of the chest");
        }

        if (y<0 || y>3) {
            throw new OutOfChestException("Value of Y is out of the chest");
        }

        if (this.chest[x][y] != 0) {
            throw new ChestCaseOccupedException("Pos x|y: " + x + y + " occuped!");
        }

        this.chest[x][y] = this.currentPlayer;
        this.currentPlayer *= -1;

        return this.checkWinner();
    }

    private boolean checkWinner() {
        return false;
    }

    private void resetChest() {
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                chest[i][j] = GameController.NO_PLAYER;
            }
        }
    }

}
