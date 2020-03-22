package controller;

import model.Pos;
import view.GameViewer;

import java.util.Random;

public class BotController {

    private GameController gameController;
    private int botNumber;
    private int playerNumber;

    public BotController(GameController gameController, int botNumber) {
        this.gameController = gameController;
        this.botNumber = botNumber;
        this.playerNumber = this.botNumber * -1;
    }

    public Pos getNextPlay() {
        Pos pos = this.justWin();

        if (pos != null) {
            System.out.println("Win por justWin");
            return pos;
        }

        pos = this.justDontLose();

        if (pos != null) {
            System.out.println("Win por justDontLose");
            return pos;
        }

        System.out.println("Random");

        return this.justGetARandomValidPosition();
    }

    private Pos justWin() {
        int countOnRows = 0;
        int countOnColumn1 = 0;
        int countOnColumn2 = 0;
        int countOnColumn3 = 0;
        int countOnDioganal = 0;
        int countOnInverseDioganal = 0;

        for (int x=0; x<3; x++) {
            for (int y=0; y<3; y++) {
                if (this.gameController.chest[x][y] == this.botNumber) {
                    countOnRows++;

                    if (x==0) {
                        countOnColumn1++;
                    } else if (x==1) {
                        countOnColumn2++;
                    } else {
                        countOnColumn3++;
                    }

                    if (x==y) {
                        countOnDioganal++;
                    }

                    if (x + y == (GameController.CHEST_TAM - 1) ) {
                        countOnInverseDioganal++;
                    }
                }
            }

            if (countOnRows == 2) {
                if (this.gameController.chest[x][0]==GameController.NO_PLAYER) {
                    return new Pos(x,0);
                } else if (this.gameController.chest[x][1]==GameController.NO_PLAYER) {
                    return new Pos(x,1);
                } else {
                    return new Pos(x,2);
                }
            }

            countOnRows = 0;
        }

        if (countOnColumn1 == 2) {
            if (this.gameController.chest[0][0]==GameController.NO_PLAYER) {
                return new Pos(0,0);
            } else if (this.gameController.chest[0][1]==GameController.NO_PLAYER) {
                return new Pos(1,0);
            } else {
                return new Pos(2,0);
            }
        }

        if (countOnColumn2 == 2) {
            if (this.gameController.chest[1][0]==GameController.NO_PLAYER) {
                return new Pos(0,1);
            } else if (this.gameController.chest[1][1]==GameController.NO_PLAYER) {
                return new Pos(1,1);
            } else {
                return new Pos(2,1);
            }
        }

        if (countOnColumn3 == 2) {
            if (this.gameController.chest[2][0]==GameController.NO_PLAYER) {
                return new Pos(0,2);
            } else if (this.gameController.chest[2][1]==GameController.NO_PLAYER) {
                return new Pos(1,2);
            } else {
                return new Pos(2,2);
            }
        }

        if (countOnDioganal == 2) {
            if (this.gameController.chest[0][0] == GameController.NO_PLAYER) {
                return new Pos(0,0);
            } else if (this.gameController.chest[1][1] == GameController.NO_PLAYER) {
                return new Pos(1,1);
            } else {
                return new Pos(2,2);
            }
        }

        if (countOnInverseDioganal == 2) {
            if (this.gameController.chest[0][2] == GameController.NO_PLAYER) {
                return new Pos(0,2);
            } else if (this.gameController.chest[1][1] == GameController.NO_PLAYER) {
                return new Pos(1,1);
            } else {
                return new Pos(2,0);
            }
        }

        return null;
    }

    private Pos justDontLose() {

        return null;
    }

    private Pos justGetARandomValidPosition() {

        do {
            Random random = new Random();
            int x = random.nextInt(GameController.CHEST_TAM);
            int y = random.nextInt(GameController.CHEST_TAM);

            System.out.println(x + " " + y);
            if (this.gameController.chest[x][y] == GameController.NO_PLAYER) {
                return new Pos(x,y);
            }
        } while(true);
    }
}
