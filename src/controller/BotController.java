package controller;

import java.util.Random;

import model.Pos;

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
            return pos;
        }

        pos = this.justDontLose();

        if (pos != null) {
            return pos;
        }

        return this.justGetARandomValidPosition();
    }

    private Pos justWin() {
        int x,y;
        int countOnRows = 0;
        int countOnColumns = 0;
        int countOnDioganal = 0;
        int countOnInverseDioganal = 0;

        for (x=0; x<3; x++) {
            for (y=0; y<3; y++) {
                if (this.gameController.chest[x][y] == this.botNumber) {
                    countOnRows++;

                    if (x==y) {
                        countOnDioganal++;
                    }

                    if (x + y == (GameController.CHEST_TAM - 1) ) {
                        countOnInverseDioganal++;
                    }
                }

                if (this.gameController.chest[y][x] == this.botNumber) {
                    countOnColumns++;
                }
            }

            if (countOnRows == 2) {
                if (this.gameController.chest[x][0]==GameController.NO_PLAYER) {
                    return new Pos(x,0);
                } else if (this.gameController.chest[x][1]==GameController.NO_PLAYER) {
                    return new Pos(x,1);
                } else if (this.gameController.chest[x][2]==GameController.NO_PLAYER) {
                    return new Pos(x,2);
                }
            }

            if (countOnColumns == 2) {
                if (this.gameController.chest[0][x]==GameController.NO_PLAYER) {
                    return new Pos(0,x);
                } else if (this.gameController.chest[1][x]==GameController.NO_PLAYER) {
                    return new Pos(1,x);
                } else if (this.gameController.chest[2][x]==GameController.NO_PLAYER) {
                    return new Pos(2,x);
                }
            }

            countOnRows = 0;
            countOnColumns = 0;
        }

        if (countOnDioganal == 2) {
            if (this.gameController.chest[0][0] == GameController.NO_PLAYER) {
                return new Pos(0,0);
            } else if (this.gameController.chest[1][1] == GameController.NO_PLAYER) {
                return new Pos(1,1);
            } else if (this.gameController.chest[2][2]==GameController.NO_PLAYER) {
                return new Pos(2,2);
            }
        }

        if (countOnInverseDioganal == 2) {
            if (this.gameController.chest[0][2] == GameController.NO_PLAYER) {
                return new Pos(0,2);
            } else if (this.gameController.chest[1][1] == GameController.NO_PLAYER) {
                return new Pos(1,1);
            } else if (this.gameController.chest[2][0]==GameController.NO_PLAYER) {
                return new Pos(2,0);
            }
        }

        return null;
    }

    private Pos justDontLose() {
        int countOnRows = 0;
        int countOnColumns = 0;
        int countOnDioganal = 0;
        int countOnInverseDioganal = 0;

        for (int x=0; x<3; x++) {
            for (int y=0; y<3; y++) {
                if (this.gameController.chest[x][y] == this.playerNumber) {
                    countOnRows++;

                    if (x==y) {
                        countOnDioganal++;
                    }

                    if (x + y == (GameController.CHEST_TAM - 1) ) {
                        countOnInverseDioganal++;
                    }
                }

                if (this.gameController.chest[y][x] == this.playerNumber) {
                    countOnColumns++;
                }
            }

            if (countOnRows == 2) {
                if (this.gameController.chest[x][0]==GameController.NO_PLAYER) {
                    return new Pos(x,0);
                } else if (this.gameController.chest[x][1]==GameController.NO_PLAYER) {
                    return new Pos(x,1);
                } else if (this.gameController.chest[x][2]==GameController.NO_PLAYER) {
                    return new Pos(x,2);
                }
            }

            if (countOnColumns == 2) {
                if (this.gameController.chest[0][x]==GameController.NO_PLAYER) {
                    return new Pos(0,x);
                } else if (this.gameController.chest[1][x]==GameController.NO_PLAYER) {
                    return new Pos(1,x);
                } else if (this.gameController.chest[2][x]==GameController.NO_PLAYER) {
                    return new Pos(2,x);
                }
            }

            countOnRows = 0;
            countOnColumns = 0;
        }

        if (countOnDioganal == 2) {
            if (this.gameController.chest[0][0] == GameController.NO_PLAYER) {
                return new Pos(0,0);
            } else if (this.gameController.chest[1][1] == GameController.NO_PLAYER) {
                return new Pos(1,1);
            } else if (this.gameController.chest[2][2]==GameController.NO_PLAYER) {
                return new Pos(2,2);
            }
        }

        if (countOnInverseDioganal == 2) {
            if (this.gameController.chest[0][2] == GameController.NO_PLAYER) {
                return new Pos(0,2);
            } else if (this.gameController.chest[1][1] == GameController.NO_PLAYER) {
                return new Pos(1,1);
            } else if (this.gameController.chest[2][0]==GameController.NO_PLAYER) {
                return new Pos(2,0);
            }
        }

        return null;
    }

    private Pos justGetARandomValidPosition() {

        do {
            Random random = new Random();
            int x = random.nextInt(GameController.CHEST_TAM);
            int y = random.nextInt(GameController.CHEST_TAM);

            if (!isOcuppedPosition(x,y)) {
                return new Pos(x,y);
            }
        } while(true);
    }

    private boolean isOcuppedPosition(int x, int y) {
        if (this.gameController.chest[x][y] == GameController.NO_PLAYER) {
            return false;
        } else {
            return true;
        }
    }
}
