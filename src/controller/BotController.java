package controller;

import model.Pos;

public class BotController {

    private GameController gameController;

    public boolean isBotTurn;

    public BotController(GameController gameController, boolean isBotStart) {
        this.gameController = gameController;

        this.setIsBotTurn(isBotStart);
    }

    public Pos getNextPlay() {
        return new Pos();
    }

    private void setIsBotTurn(boolean isBotStart) {
        if (isBotStart) {
            this.isBotTurn = true;
        } else {
            this.isBotTurn = false;
        }
    }
}
