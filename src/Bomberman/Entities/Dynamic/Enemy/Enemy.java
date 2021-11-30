package Bomberman.Entities.Dynamic.Enemy;

import Bomberman.Entities.Dynamic.DynamicEntity;
import Bomberman.Entities.Entity;
import Bomberman.Game;
import Bomberman.graphics.Unit;
import Bomberman.graphics.Screen;

public abstract class Enemy extends DynamicEntity {
    protected int value;
    protected double steps;

    public Enemy(double x, double y) {
        super(x, y);
        this.speed = 0.5;
        this.steps = Game.BOX_SIZE * 1.0 / speed;
    }

    public Enemy(double x, double y, int speed, int direction, int value) {
        super(x, y, speed, direction);
        this.value = value;
    }

    protected abstract void loadSprite();

    @Override
    public void update() {
        move();
    }

    @Override
    public void render(Screen screen) {
        loadSprite();
        screen.renderEntity((int) x, (int) y - sprite.SIZE, this);
    }

    @Override
    protected void move() {
        double u = x;
        double v = y;
        if (steps <= 0) {
            direction = (int) (Math.random() * 100 + 1) % 4;
            steps = Game.BOX_SIZE * 1.0 / speed;
        }
        if (direction == 0)
            v -= 1 * speed;
        if (direction == 2)
            v += 1 * speed;
        if (direction == 3)
            u -= 1 * speed;
        if (direction == 1)
            u += 1 * speed;
        moving = u != x || v != y;
        if (canMove( (u - x) * 2, (v - y) * 2)) {
            steps -= 1;
            x = u;
            y = v;
        } else {
            steps = 0;
        }
    }

    @Override
    protected boolean canMove(double addX, double addY) {
        double xx = x, yy = y - 16;
        if (direction == 0) {
            yy += 15;
            xx += 8;
        }
        if (direction == 1) {
            yy += 8;
            xx += 1;
        }
        if (direction == 2) {
            xx += 8;
            yy += 1;
        }
        if (direction == 3) {
            xx += 15;
            yy += 8;
        }
        Entity e = gameContainer.getEntity(Unit.pixelToPos(xx) + (int) addX, Unit.pixelToPos(yy) + (int) addY);
        return !e.getBlock();
    }
}
