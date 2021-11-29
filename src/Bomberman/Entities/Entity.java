package Bomberman.Entities;

import Bomberman.GameContainer;
import Bomberman.graphics.Screen;
import Bomberman.graphics.Sprite;

public abstract class Entity {
    protected double x;
    protected double y;
    protected Sprite sprite;
    protected GameContainer gameContainer;
    protected boolean block;

    public Entity(double x, double y) {
        this.x = x;
        this.y = y;
        block = false;
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

    public boolean getBlock() {
        return block;
    }
}
