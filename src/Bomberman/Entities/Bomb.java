package Bomberman.Entities;

import Bomberman.graphics.Screen;
import Bomberman.graphics.Sprite;
import Bomberman.graphics.Unit;

public class Bomb extends Entity {
    protected int timeToExplode;
    protected int sizeFlame;
    protected boolean exploded;
    private int frame;

    public void setTimeToExplode(int timeToExplode) {
        this.timeToExplode = timeToExplode;
    }

    public Bomb(int x, int y, int timeToExplode, int sizeFlame, boolean exploded) {
        super(x, y);
        this.timeToExplode = timeToExplode;
        this.sizeFlame = sizeFlame;
        this.exploded = exploded;
    }

    public Bomb(int x, int y) {
        super(x, y);
        this.frame = 0;
        this.block = false;
    }

    public int getSizeFlame() {
        return sizeFlame;
    }

    public void setSizeFlame(int sizeFlame) {
        this.sizeFlame = sizeFlame;
    }

    public boolean isExploded() {
        return exploded;
    }

    public void setExploded(boolean exploded) {
        this.exploded = exploded;
    }

    @Override
    public void update() {
        frame = (frame + 1) % 1000;
    }

    @Override
    public void render(Screen screen) {
        loadSprite();
        screen.renderEntity((int) x, (int) y, this);
    }

    private void loadSprite() {
        int _frame = (frame / 15) % 3;
        sprite = Sprite.bomb[_frame];
    }
}
