package Bomberman.Entities.Dynamic;

import Bomberman.Entities.Entity;
import Bomberman.Game;
import Bomberman.GameContainer;
import Bomberman.Keyboard.Keyboard;
import Bomberman.graphics.Screen;
import Bomberman.graphics.Sprite;

public class Bomber extends DynamicEntity {
    protected int hearts;
    protected int numBomb;
    protected int score;
    protected int sizeBomb;
    protected Keyboard input;

    public Bomber(double x, double y, int speed, int direction, int hearts, int numBomb, int score, int sizeBomb) {
        super(x, y, speed, direction);
        this.hearts = hearts;
        this.numBomb = numBomb;
        this.score = score;
        this.sizeBomb = sizeBomb;
    }

    public Bomber(double x, double y, GameContainer gameContainer) {
        super(x, y);
        this.gameContainer = gameContainer;
        input = gameContainer.getInput();
    }

    public int getHearts() {
        return hearts;
    }

    public void setHearts(int hearts) {
        this.hearts = hearts;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getNumBomb() {
        return numBomb;
    }

    public void setNumBomb(int numBomb) {
        this.numBomb = numBomb;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public void update() {
        frame = (frame + 1)  % 1000;
        move();
    }

    @Override
    public void render(Screen screen) {
        loadSprite();
        screen.renderEntity( (int)x, (int)y - sprite.SIZE, this);
    }

    @Override
    protected void move() {
        double u = x;
        double v = y;
        if (input.up) {
            direction = 0;
            v -= 1;
        }
        if (input.down) {
            direction = 2;
            v += 1;
        }
        if (input.left) {
            direction = 3;
            u -= 1;
        }
        if (input.right) {
            direction = 1;
            u += 1;
        }
        moving = u != x || v != y;
        if (canMove(u, v)) {
            x = u;
            y = v;
        }
    }

    @Override
    protected boolean canMove(double x, double y) {
        for (int d = 0; d < 4; d++) {
            int posX = (int) ((x + d % 2 * 11)*1.0 / Game.BOX_SIZE*1.0);
            int posY = (int) ((y + d / 2 * 12 - 13)*1.0 / Game.BOX_SIZE*1.0);
            Entity e = gameContainer.getEntity(posX, posY, this);
            if (e.getBlock()) return false;
        }
        return true;
    }

    private void loadSprite() {
        int _frame = (frame / 10) % 3;
        switch (direction) {
            case 0:
                sprite = Sprite.bomber_up[0];
                if(moving) {
                    sprite = Sprite.bomber_up[_frame];
                }
                break;
            case 1:
                sprite = Sprite.bomber_right[0];
                if(moving) {
                    sprite = Sprite.bomber_right[_frame];
                }
                break;
            case 2:
                sprite = Sprite.bomber_down[0];
                if(moving) {
                    sprite = Sprite.bomber_down[_frame];
                }
                break;
            case 3:
                sprite = Sprite.bomber_left[0];
                if(moving) {
                    sprite = Sprite.bomber_left[_frame];
                }

                break;
            default:
                sprite = Sprite.bomber_right[0];
                if(moving) {
                    sprite = Sprite.bomber_right[_frame];
                }
                break;
        }
    }
}
