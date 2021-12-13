package Bomberman.Entities.Dynamic.Enemy;

import Bomberman.Entities.Dynamic.Enemy.AI.AIMedium;
import Bomberman.Game;
import Bomberman.GameContainer;
import Bomberman.graphics.Sprite;


public class Oneal extends Enemy {

    public Oneal(int x, int y, GameContainer gameContainer) {
        super(x, y,Sprite.oneal_dead);
        this.gameContainer = gameContainer;
        this.speed = 0.5;
        this.steps = Game.BOX_SIZE * 1.0 / speed;
        this.ai = new AIMedium(gameContainer.getBomber(), this);
    }

    @Override
    protected void loadSprite() {
        int _frame = (frame / 15) % 3;
        switch (direction) {
            case 0:
                sprite = Sprite.oneal_right[_frame];
                break;
            case 1:
                sprite = Sprite.oneal_right[_frame];
                break;
            case 2:
                sprite = Sprite.oneal_left[_frame];
                break;
            case 3:
                sprite = Sprite.oneal_left[_frame];
                break;
        }
    }

}
