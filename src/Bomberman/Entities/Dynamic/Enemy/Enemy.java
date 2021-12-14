package Bomberman.Entities.Dynamic.Enemy;

import Bomberman.Entities.Bomb.Bomb;
import Bomberman.Entities.Bomb.Flame;
import Bomberman.Entities.Dynamic.DynamicEntity;
import Bomberman.Entities.Dynamic.Enemy.AI.AI;
import Bomberman.Entities.Entity;
import Bomberman.Game;
import Bomberman.UI.Dialog;
import Bomberman.graphics.Sprite;
import Bomberman.graphics.Unit;
import Bomberman.graphics.Screen;

public abstract class Enemy extends DynamicEntity {
    protected int value;
    protected double steps;
    protected double res;
    protected Sprite deadSprite;
    protected AI ai;

    public Enemy(double x, double y, Sprite deadSprite) {
        super(x, y);
        this.deadTime = 60;
        this.deadSprite = deadSprite;
    }

    protected abstract void loadSprite();
    public void kill() {
        if (deadTime > 0)
            deadTime--;
        else {
            Dialog msg = new Dialog(  "" + value, (x + Game.BOX_SIZE/2.0) * Game.SCALE, (y - Game.BOX_SIZE/2.0) * Game.SCALE);
            gameContainer.setPoints(gameContainer.getPoints() + value);
            gameContainer.addDialog(msg);
            remove = true;
        }
    }
    @Override
    public void update() {
        frame = (frame + 1) % 1000;
        if (dead) {
            kill();
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
        direction = this.ai.calculateDirection();
        if (direction == 0)
            v -= 1 * speed;
        if (direction == 2)
            v += 1 * speed;
        if (direction == 3)
            u -= 1 * speed;
        if (direction == 1)
            u += 1 * speed;
        moving = u != x || v != y;
        if (canMove(Math.round((u - x) * (1.0 / speed)), Math.round((v - y) * (1.0 / speed)))) {
            steps -= 1 + res;
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
            gameContainer.setKilledEnemy(true);
            return true;
        }
        return true;
    }

    public double getSteps() {
        return steps;
    }

    public void setSteps(double steps) {
        this.steps = steps;
    }

    public double getRes() {
        return res;
    }

    public void setRes(double res) {
        this.res = res;
    }
}
