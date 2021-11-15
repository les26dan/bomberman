package models;

public abstract class MobileEntity extends Entity {
    protected int speed;
    protected int direction;

    public MobileEntity(int x, int y, int speed, int direction) {
        super(x, y);
        this.speed = 1;
        this.direction = 1;
    }

    public MobileEntity(int x, int y) {
        super(x, y);
    }
}
