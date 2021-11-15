package models.Enemy;

import models.MobileEntity;

public abstract class Enemy extends MobileEntity {
    protected int value;

    public Enemy(int x, int y) {
        super(x, y);
    }

    public Enemy(int x, int y, int speed, int direction, int value) {
        super(x, y, speed, direction);
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
