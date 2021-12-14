package Bomberman.Entities.Dynamic.Enemy;

import Bomberman.Entities.Dynamic.Enemy.AI.AILow;
import Bomberman.Game;
import Bomberman.GameContainer;
import Bomberman.UI.Dialog;
import Bomberman.graphics.Sprite;
import Bomberman.graphics.Unit;


public class Doll extends Enemy {
    private boolean mother;
    private int timeToDouble = 600;
    public Doll(int x, int y, GameContainer gameContainer, boolean mother) {
        super(x, y,Sprite.doll_dead);
        this.gameContainer = gameContainer;
        this.value = 200;
        this.speed = 0.5;
        this.steps = Game.BOX_SIZE * 1.0 / speed;
        this.res = (steps - (int) steps)/steps;
        this.ai = new AILow(this);
        this.mother = mother;
    }

    @Override
    public void update() {
        timeToDouble--;
        if(timeToDouble == 0 && mother) {
            gameContainer.addDynamicEntity(new Doll(Unit.posToPixel(posX()),
                    Unit.posToPixel(posY()) + Game.BOX_SIZE, gameContainer, false));
            timeToDouble = 600;
        }
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
            move();
        }
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
