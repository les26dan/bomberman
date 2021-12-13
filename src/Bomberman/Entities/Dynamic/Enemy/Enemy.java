package Bomberman.Entities.Dynamic.Enemy;

import Bomberman.Entities.Bomb.Bomb;
import Bomberman.Entities.Bomb.Flame;
import Bomberman.Entities.Dynamic.DynamicEntity;
import Bomberman.Entities.Dynamic.Enemy.AI.AI;
import Bomberman.Entities.Entity;
import Bomberman.Game;
import Bomberman.graphics.Sprite;
import Bomberman.graphics.Unit;
import Bomberman.graphics.Screen;

public abstract class Enemy extends DynamicEntity {
    protected int value;
    protected double steps;
    protected Sprite deadSprite;
    protected AI ai;

    public Enemy(double x, double y, Sprite deadSprite) {
        super(x, y);
        this.deadTime = 60;
        this.deadSprite = deadSprite;
    }

    protected abstract void loadSprite();

    @Override
    public void update() {
        frame = (frame + 1) % 1000;
        if (dead) {
            if (deadTime > 0)
                deadTime--;
            else
                remove = true;
        } else {
            move();
        }
    }

    @Override
    public void render(Screen screen) {
        if (dead) {
            sprite = deadSprite;
            if(deadTime <= 30) sprite = Sprite.mob_dead[0];
            if(deadTime <= 20) sprite = Sprite.mob_dead[1];
            if(deadTime <= 10) sprite = Sprite.mob_dead[2];
        } else {
            loadSprite();
        }
        screen.renderEntity((int) x, (int) y - sprite.SIZE, this);
    }

    @Override
    protected void move() {
        double u = x;
        double v = y;
        if (steps <= 0) {
            direction = this.ai.calculateDirection();
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
        if (canMove((u - x) * 2, (v - y) * 2)) {
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
        Entity e = gameContainer.getEntity(Unit.pixelToPos(xx) + (int) addX, Unit.pixelToPos(yy) + (int) addY, this);
        return e.collide(this);
    }

    @Override
    public boolean collide(Entity e) {
        if (e instanceof Flame) {
            dead = true;
            return true;
        }
        return true;
    }
}
