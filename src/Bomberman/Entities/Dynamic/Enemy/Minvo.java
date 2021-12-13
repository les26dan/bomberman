package Bomberman.Entities.Dynamic.Enemy;

import Bomberman.Game;
import Bomberman.GameContainer;
import Bomberman.graphics.Sprite;


public class Minvo extends Enemy {

    public Minvo(int x, int y, GameContainer gameContainer) {
        super(x, y,Sprite.minvo_dead);
        this.gameContainer = gameContainer;
        this.value = 500;
        this.speed = 0.5;
        this.steps = Game.BOX_SIZE * 1.0 / speed;
    }

    @Override
    protected void loadSprite() {
        int _frame = (frame / 15) % 3;
        switch (direction) {
            case 0:
                sprite = Sprite.minvo_right[_frame];
                break;
            case 1:
                sprite = Sprite.minvo_right[_frame];
                break;
            case 2:
                sprite = Sprite.minvo_left[_frame];
                break;
            case 3:
                sprite = Sprite.minvo_left[_frame];
                break;
        }
    }

}
