package Bomberman.Entities.Dynamic.Enemy;

import Bomberman.Entities.Dynamic.Enemy.AI.AIHigh;
import Bomberman.Game;
import Bomberman.GameContainer;
import Bomberman.UI.Dialog;
import Bomberman.graphics.Sprite;

public class Ovape extends Enemy {
    private int timeChasing = 0;
    private boolean mustReset = false;
    public Ovape(double x, double y, GameContainer gameContainer) {
        super(x, y, Sprite.ovape_dead);
        this.gameContainer = gameContainer;
        this.value = 600;
        this.speed = 0.5;
        this.steps = Game.BOX_SIZE * 1.0 / speed;
        this.ai = new AIHigh(gameContainer, this, 0);
    }

    @Override
    public void update() {
        System.out.println(timeChasing);
        if(mustReset && steps == 0) {
            mustReset = false;
            this.speed = 0.5;
            AIHigh _ai = (AIHigh) this.ai;
            _ai.setChasingRadius(0);
        }
        //System.out.println(steps);
        frame = (frame + 1) % 1000;
        if (dead) {
            if (deadTime > 0)
                deadTime--;
            else {
                Dialog msg = new Dialog(  "" + value, (x + Game.BOX_SIZE/2.0) * Game.SCALE, (y - Game.BOX_SIZE/2.0) * Game.SCALE);
                gameContainer.setPoints(gameContainer.getPoints() + value);
                gameContainer.addDialog(msg);
                remove = true;
            }
        } else {
            if(timeChasing > 0) {
                timeChasing--;
            } else {
                if(steps != 0) {
                    mustReset = true;
                } else {
                    this.speed = 0.5;
                    AIHigh _ai = (AIHigh) this.ai;
                    _ai.setChasingRadius(0);
                }
            }
            if(gameContainer.isKilledEnemy() && steps == 0) {
                this.speed = 0.75;
                AIHigh _ai = (AIHigh) this.ai;
                _ai.setChasingRadius(1000);
                gameContainer.setKilledEnemy(false);
                timeChasing = 200;
                this.steps = Game.BOX_SIZE * 1.0 / speed;
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
