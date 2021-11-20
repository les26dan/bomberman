package Bomberman.Entities.Dynamic.Enemy;

import Bomberman.Entities.Dynamic.DynamicEntity;

public abstract class Enemy extends DynamicEntity {
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
