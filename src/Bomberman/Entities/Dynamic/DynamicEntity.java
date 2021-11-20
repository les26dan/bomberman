package Bomberman.Entities.Dynamic;

import Bomberman.Entities.Entity;

public abstract class DynamicEntity extends Entity {
    protected int speed;
    protected int direction;

    public DynamicEntity(int x, int y, int speed, int direction) {
        super(x, y);
        this.speed = 1;
        this.direction = 1;
    }

    public DynamicEntity(int x, int y) {
        super(x, y);
    }
}
