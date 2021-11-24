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

    public Bomber(int x, int y, int speed, int direction, int hearts, int numBomb, int score, int sizeBomb) {
        super(x, y, speed, direction);
        this.hearts = hearts;
        this.numBomb = numBomb;
        this.score = score;
        this.sizeBomb = sizeBomb;
    }

    public Bomber(int x, int y, GameContainer gameContainer) {
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

    public int getSpeed() {
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
        move();
    }

    @Override
    public void render(Screen screen) {
        chooseSprite();
        screen.renderEntity( x, y - sprite.SIZE, this);
    }

    @Override
    protected void move() {
        int u = x;
        int v = y;
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

        if (canMove(u, v)) {
            x = u;
            y = v;
        }
    }

    @Override
    protected boolean canMove(int x, int y) {
        for (int d = 0; d < 4; d++) {
            int posX = (x + d % 2 * 11) / Game.BOX_SIZE;
            int posY = (y + d / 2 * 12 - 13) / Game.BOX_SIZE;
            Entity e = gameContainer.getEntity(posX, posY, this);
            if (e.getBlock()) return false;
        }
        return true;
    }

    private void chooseSprite() {
        switch (direction) {
            case 0:
                sprite = Sprite.player_up;
                break;
            case 1:
                sprite = Sprite.player_right;
                break;
            case 2:
                sprite = Sprite.player_down;
                break;
            case 3:
                sprite = Sprite.player_left;

                break;
            default:
                sprite = Sprite.player_right;

                break;
        }
    }
}
