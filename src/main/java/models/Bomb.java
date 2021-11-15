package models;

public class Bomb extends Entity {
    protected int timeToExplode;
    protected int sizeFlame;
    protected boolean exploded;

    public void setTimeToExplode(int timeToExplode) {
        this.timeToExplode = timeToExplode;
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
}
