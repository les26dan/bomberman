package Bomberman.Entities;

import Bomberman.GameContainer;
import Bomberman.graphics.Screen;
import Bomberman.graphics.Sprite;

public abstract class Entity {
    protected int x;
    protected int y;
    protected Sprite sprite;
    protected GameContainer gameContainer;

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public abstract void render(Screen screen);
    public abstract void update();

    public Sprite getSprite() {
        return sprite;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
