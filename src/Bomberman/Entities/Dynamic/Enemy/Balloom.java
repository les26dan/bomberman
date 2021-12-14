package Bomberman.Entities.Dynamic.Enemy;

import Bomberman.Entities.Dynamic.Enemy.AI.AILow;
import Bomberman.Game;
import Bomberman.GameContainer;
import Bomberman.graphics.Sprite;


public class Balloom extends Enemy {

    public Balloom(int x, int y, GameContainer gameContainer) {
        super(x, y,Sprite.balloom_dead);
        this.gameContainer = gameContainer;
        this.value = 100;
        this.speed = 0.5;
        this.steps = Game.BOX_SIZE * 1.0 / speed;
        this.ai = new AILow(this);
        hearts = 2;
    }

    @Override
    protected void loadSprite() {
        int _frame = (frame / 15) % 3;
        switch (direction) {
            case 0:
                sprite = Sprite.balloom_right[_frame];
                break;
            case 1:
                sprite = Sprite.balloom_right[_frame];
                break;
            case 2:
                sprite = Sprite.balloom_left[_frame];
                break;
            case 3:
                sprite = Sprite.balloom_left[_frame];
                break;
        }
    }

}
