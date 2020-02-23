package controller;

import exception.ChestCaseOccupedException;
import exception.OutOfChestException;

public class GameController {

    private static final int CHEST_TAM = 3;

    private static final int PLAYER_1 = 1;
    private static final int PLAYER_2 = -1;
    private static final int NO_PLAYER = 0;

    public int[][] chest = new int[CHEST_TAM][CHEST_TAM];
    public int winner;
    public int currentPlayer;

    public GameController() {
        this.reset();
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
        if (checkWinnerOnRows()) {
            return true;
        }

        if (checkWinnerOnColumns()) {
            return true;
        }

        if (checkWinnerOnDioganal()) {
            return true;
        }

        return false;
    }

    private boolean checkWinnerOnDioganal() {
        int sumPlayer1OnDioganal = 0;
        int sumPlayer2OnDioganal = 0;

        int sumPlayer1OnInvertedDioganal = 0;
        int sumPlayer2OnInvertedDioganal = 0;

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
               if (i == j) {
                   int playerOnDiagonal = this.chest[i][j];
                   if (playerOnDiagonal == GameController.PLAYER_1) {
                       sumPlayer1OnDioganal += playerOnDiagonal;
                   } else if (playerOnDiagonal == GameController.PLAYER_2) {
                       sumPlayer2OnDioganal += playerOnDiagonal;
                   }
               }

               if (i+j == (GameController.CHEST_TAM -1)) {
                   int playerOnInvertedDiagonal = this.chest[i][j];
                   if (playerOnInvertedDiagonal == GameController.PLAYER_1) {
                       sumPlayer1OnInvertedDioganal += playerOnInvertedDiagonal;
                   } else if (playerOnInvertedDiagonal == GameController.PLAYER_2) {
                       sumPlayer2OnInvertedDioganal += playerOnInvertedDiagonal;
                   }
               }
            }
        }

        if ((sumPlayer1OnDioganal == 3) || (sumPlayer1OnInvertedDioganal == 3)) {
            this.winner = GameController.PLAYER_1;
            return true;
        } else if ((sumPlayer2OnDioganal == -3) || (sumPlayer2OnInvertedDioganal == -3)) {
            this.winner = GameController.PLAYER_2;
            return true;
        }

        return false;
    }

    private boolean checkWinnerOnRows() {
        for (int i=0; i<3; i++) {
            int sumPlayer1OnRows = 0;
            int sumPlayer2OnRows = 0;

            for (int j=0; j<3; j++) {
                int playerOnRows = this.chest[i][j];
                if (playerOnRows == GameController.PLAYER_1) {
                    sumPlayer1OnRows += playerOnRows;
                } else if (playerOnRows == GameController.PLAYER_2) {
                    sumPlayer2OnRows += playerOnRows;
                } else if (playerOnRows == GameController.NO_PLAYER) {
                    break;
                }
            }

            if (sumPlayer1OnRows == 3) {
                this.winner = GameController.PLAYER_1;
                return true;
            } else if (sumPlayer2OnRows == -3) {
                this.winner = GameController.PLAYER_2;
                return true;
            }
        }
        return false;
    }

    private boolean checkWinnerOnColumns() {
        for (int i=0; i<3; i++) {
            int sumPlayer1OnColumns = 0;
            int sumPlayer2OnColumns = 0;

            for (int j=0; j<3; j++) {
                int playerOnColumns = this.chest[j][i];
                if (playerOnColumns == GameController.PLAYER_1) {
                    sumPlayer1OnColumns += playerOnColumns;
                } else if (playerOnColumns == GameController.PLAYER_2) {
                    sumPlayer2OnColumns += playerOnColumns;
                } else if (playerOnColumns == GameController.NO_PLAYER) {
                    break;
                }
            }
            if (sumPlayer1OnColumns == 3) {
                this.winner = GameController.PLAYER_1;
                return true;
            } else if (sumPlayer2OnColumns == -3) {
                this.winner = GameController.PLAYER_2;
                return true;
            }
        }
        return false;
    }

    public void reset() {
        currentPlayer = GameController.PLAYER_1;
        this.winner = GameController.NO_PLAYER;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                chest[i][j] = GameController.NO_PLAYER;
            }
        }
    }

}
