package Bomberman.Entities.Dynamic.Enemy;

import Bomberman.Entities.Dynamic.Enemy.AI.AIHigh;
import Bomberman.Entities.Dynamic.Enemy.AI.AILow;
import Bomberman.Game;
import Bomberman.GameContainer;
import Bomberman.graphics.Sprite;

import java.util.Random;


public class Oneal extends Enemy {
    private int turn = 0;
    protected Random random = new Random();
    public Oneal(int x, int y, GameContainer gameContainer) {
        super(x, y, Sprite.oneal_dead);
        this.gameContainer = gameContainer;
        this.value = 400;
        this.speed = 0.5;
        this.steps = Game.BOX_SIZE * 1.0 / speed;
        this.res = (steps - (int) steps) / steps;
        this.ai = new AIHigh(gameContainer, this, 5);
    }

    @Override
    public void update() {
        if (steps <= 0) {
            turn = Math.max(0, turn - 1);
            if (turn >= 7) {
                this.speed = 0.8;
            }
            if (turn < 7) {
                this.speed = 0.3;
            }
        }
        frame = (frame + 1) % 1000;
        if (dead) {
            kill();
        } else {
            if (turn == 0) {
                turn = 14;
            }
            move();
        }
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
