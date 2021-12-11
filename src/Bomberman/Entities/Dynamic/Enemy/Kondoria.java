package Bomberman.Entities.Dynamic.Enemy;

import Bomberman.Game;
import Bomberman.GameContainer;
import Bomberman.graphics.Sprite;


public class Kondoria extends Enemy {

    public Kondoria(int x, int y, GameContainer gameContainer) {
        super(x, y,Sprite.kondoria_dead);
        this.gameContainer = gameContainer;
        this.speed = 0.5;
        this.steps = Game.BOX_SIZE * 1.0 / speed;
    }

    @Override
    protected void loadSprite() {
        int _frame = (frame / 15) % 3;
        switch (direction) {
            case 0:
                sprite = Sprite.kondoria_right[_frame];
                break;
            case 1:
                sprite = Sprite.kondoria_right[_frame];
                break;
            case 2:
                sprite = Sprite.kondoria_left[_frame];
                break;
            case 3:
                sprite = Sprite.kondoria_left[_frame];
                break;
        }
    }

}
