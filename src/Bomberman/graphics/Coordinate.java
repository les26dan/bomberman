package Bomberman.graphics;

import Bomberman.Game;

public class Coordinate {

    public static int pixelToPos(double i)

    {
        return (int) (i / Game.BOX_SIZE);
    }

    public static int posToPixel(int i) {

        return i * Game.BOX_SIZE;
    }

    public static int posToPixel(double i) {

        return (int) (i * Game.BOX_SIZE);
    }

}