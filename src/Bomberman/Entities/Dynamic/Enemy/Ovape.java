package Bomberman.Entities.Dynamic.Enemy;

import Bomberman.Entities.Dynamic.Enemy.AI.AIHigh;
import Bomberman.Entities.Dynamic.Enemy.AI.AILow;
import Bomberman.Game;
import Bomberman.GameContainer;
import Bomberman.graphics.Sprite;

public class Ovape extends Enemy {
    private int turnChasing = 0;
    private boolean mustReset = false;

    public Ovape(double x, double y, GameContainer gameContainer) {
        super(x, y, Sprite.ovape_dead);
        this.gameContainer = gameContainer;
        this.value = 600;
        this.speed = 0.1;
        this.steps = Game.BOX_SIZE * 1.0 / speed;
        this.res = (steps - (int) steps)/steps;
        this.ai = new AILow(this);
    }

    @Override
    public void update() {
        System.out.println(steps);
        if (steps <= 0) {
            turnChasing = Math.max(0,turnChasing - 1);
            System.out.println("turn " + turnChasing);
            if (turnChasing >= 1 && turnChasing <= 14) {
                this.speed = 0.3;
                this.ai = new AIHigh(gameContainer, this, 1000);
            }
            if (turnChasing == 0) {
                this.speed = 0.1;
                this.ai = new AILow(this);
            }
        }
        frame = (frame + 1) % 1000;
        if (dead) {
            kill();
        } else {
            if (gameContainer.isKilledEnemy()) {
                turnChasing = 15;
                gameContainer.setKilledEnemy(false);
            }
            move();
        }
    }

    @Override
    protected void loadSprite() {
        int _frame = (frame / 15) % 3;
        switch (direction) {
            case 0:
                sprite = Sprite.ovape_right[_frame];
                break;
            case 1:
                sprite = Sprite.ovape_right[_frame];
                break;
            case 2:
                sprite = Sprite.ovape_left[_frame];
                break;
            case 3:
                sprite = Sprite.ovape_left[_frame];
                break;
        }
    }
}
