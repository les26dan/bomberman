package Bomberman.Entities;

import Bomberman.graphics.Screen;

public class Bomb extends Entity {
    protected int timeToExplode;
    protected int sizeFlame;
    protected boolean exploded;

    public void setTimeToExplode(int timeToExplode) {
        this.timeToExplode = timeToExplode;
    }

    public Bomb(int x, int y, int timeToExplode, int sizeFlame, boolean exploded) {
        super(x, y);
        this.timeToExplode = timeToExplode;
        this.sizeFlame = sizeFlame;
        this.exploded = exploded;
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

    }
    @Override
    public void render(Screen screen) {

    }
}
