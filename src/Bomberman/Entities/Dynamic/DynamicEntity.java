package Bomberman.Entities.Dynamic;

import Bomberman.Entities.Entity;

public abstract class DynamicEntity extends Entity {
    protected double speed;
    protected int direction ;
    protected boolean moving;
    protected int frame;
    protected int deadTime = 28;
    protected boolean dead = false;
    protected int hearts;

    public DynamicEntity(double x, double y) {
        super(x, y);
        this.direction = 1;
    }
    protected abstract boolean canMove(double x, double y);
    protected abstract void move();

    public double getSpeed() {
        return speed;
    }

    public int getDirection() {
        return direction;
    }
}
