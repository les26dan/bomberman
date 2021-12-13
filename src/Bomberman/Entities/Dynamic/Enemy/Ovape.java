package Bomberman.Entities.Dynamic.Enemy;

import Bomberman.Game;
import Bomberman.GameContainer;
import Bomberman.graphics.Sprite;

public class Ovape extends Enemy {

    public Ovape(double x, double y, GameContainer gameContainer) {
        super(x, y, Sprite.ovape_dead);
        this.gameContainer = gameContainer;
        this.speed = 0.5;
        this.steps = Game.BOX_SIZE * 1.0 / speed;
    }

    @Override
    protected void loadSprite() {

    }
}
