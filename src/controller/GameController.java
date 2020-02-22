package controller;

public class GameController {
    public int[][] chest = new int[3][3];

    private static final int PLAYER_1 = 1;
    private static final int PLAYER_2 = -1;

    public int currentPlayer = GameController.PLAYER_1;

    public GameController() {
        this.resetChest();
    }

    public int play(int x,int y) throws Exception {
        if (x<0 || x>3) {
            throw new Exception("Value of X is out of the chess");
        }

        if (y<0 || y>3) {
            throw new Exception("Value of Y is out of the chess");
        }

        this.chest[x][y] = this.currentPlayer;
        this.currentPlayer *= -1;

        return this.checkWinner();
    }

    private int checkWinner() {
        return 0;
    }

    private void resetChest() {
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                chest[i][j] = 0;
            }
        }
    }

}
