package Bomberman.Entities;

import Bomberman.GameContainer;
import Bomberman.graphics.Screen;
import Bomberman.graphics.Sprite;
import Bomberman.graphics.Unit;

public abstract class Entity {
    protected double x;
    protected double y;
    protected Sprite sprite;
    protected boolean remove = false;
    protected GameContainer gameContainer;

    public Entity(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Entity getEntity() {
        return this;
    }
    public abstract void render(Screen screen);
    public abstract void update();
    public Sprite getSprite() {
        return sprite;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public abstract boolean collide(Entity e);

    public boolean isRemoved() {
        return remove;
    }
    public int posX(){
        return Unit.pixelToPos(x + 8);
    }
    public int posY(){
        return Unit.pixelToPos(y - 8);
    }
}
