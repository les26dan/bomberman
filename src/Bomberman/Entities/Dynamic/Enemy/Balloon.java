package Bomberman.Entities.Dynamic.Enemy;

import Bomberman.GameContainer;
import Bomberman.graphics.Sprite;

import java.awt.*;

public class Balloon extends Enemy {

    public Balloon(int x, int y, int speed, int direction, int value) {
        super(x, y, speed, direction, value);
    }

    public Balloon(int x, int y, GameContainer gameContainer) {
        super(x, y);
        this.gameContainer = gameContainer;
    }

    @Override
    protected void loadSprite() {
        switch (direction) {
            case 1:
                sprite = Sprite.balloom_right[0];
                break;
            case 3:
                sprite = Sprite.balloom_left[0];
                break;
        }
    }

}
