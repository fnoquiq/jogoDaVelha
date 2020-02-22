package util;

import model.Pos;

public class Util {

    public static Pos singleToPos(int singlePos) {
        Pos pos = new Pos();

        switch (singlePos) {
            case 0:
                pos.x = 0;
                pos.y = 0;
                break;
            case 1:
                pos.x = 0;
                pos.y = 1;
                break;
            case 2:
                pos.x = 0;
                pos.y = 2;
                break;
            case 3:
                pos.x = 1;
                pos.y = 0;
                break;
            case 4:
                pos.x = 1;
                pos.y = 1;
                break;
            case 5:
                pos.x = 1;
                pos.y = 2;
                break;
            case 6:
                pos.x = 2;
                pos.y = 0;
                break;
            case 7:
                pos.x = 2;
                pos.y = 1;
                break;
            case 8:
                pos.x = 2;
                pos.y = 2;
                break;
            default:

        }

        return pos;
    }
}
