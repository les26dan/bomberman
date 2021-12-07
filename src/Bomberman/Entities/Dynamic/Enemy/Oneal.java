package Bomberman.Entities.Dynamic.Enemy;

import Bomberman.GameContainer;
import Bomberman.graphics.Sprite;


public class Oneal extends Enemy {

    public Oneal(int x, int y, GameContainer gameContainer) {
        super(x, y, Sprite.oneal_dead);
        this.gameContainer = gameContainer;
    }


    @Override
    protected void loadSprite() {
    }
}
