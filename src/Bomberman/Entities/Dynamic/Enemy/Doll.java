package Bomberman.Entities.Dynamic.Enemy;

import Bomberman.Game;
import Bomberman.GameContainer;
import Bomberman.graphics.Sprite;


public class Doll extends Enemy {

    public Doll(int x, int y, GameContainer gameContainer) {
        super(x, y,Sprite.doll_dead);
        this.gameContainer = gameContainer;
        this.speed = 0.5;
        this.steps = Game.BOX_SIZE * 1.0 / speed;
    }

    @Override
    protected void loadSprite() {
        int _frame = (frame / 15) % 3;
        switch (direction) {
            case 0:
                sprite = Sprite.doll_right[_frame];
                break;
            case 1:
                sprite = Sprite.doll_right[_frame];
                break;
            case 2:
                sprite = Sprite.doll_left[_frame];
                break;
            case 3:
                sprite = Sprite.doll_left[_frame];
                break;
        }
    }

}
