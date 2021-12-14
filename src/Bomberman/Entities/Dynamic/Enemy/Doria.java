package Bomberman.Entities.Dynamic.Enemy;

import Bomberman.Entities.Dynamic.Enemy.AI.AIHigh;
import Bomberman.Game;
import Bomberman.GameContainer;
import Bomberman.graphics.Sprite;


public class Doria extends Enemy {

    public Doria(int x, int y, GameContainer gameContainer) {
        super(x, y,Sprite.doria_dead);
        this.gameContainer = gameContainer;
        this.value = 400;
        this.speed = 0.25;
        this.steps = Game.BOX_SIZE * 1.0 / speed;
        this.ai = new AIHigh(gameContainer, this, 5);
    }

    @Override
    protected void loadSprite() {
        int _frame = (frame / 15) % 3;
        switch (direction) {
            case 0:
                sprite = Sprite.doria_right[_frame];
                break;
            case 1:
                sprite = Sprite.doria_right[_frame];
                break;
            case 2:
                sprite = Sprite.doria_left[_frame];
                break;
            case 3:
                sprite = Sprite.doria_left[_frame];
                break;
        }
    }

}
