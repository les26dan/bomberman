package Bomberman.Entities.Bomb;

import Bomberman.Entities.Dynamic.Bomber;
import Bomberman.Entities.Entity;
import Bomberman.graphics.Screen;
import Bomberman.graphics.Sprite;
import Bomberman.graphics.Unit;

public class Bomb extends Entity {
    protected int timeToExplode = 120;
    protected int explodeTime = 20;
    protected int sizeFlame;
    protected boolean exploded;
    private int frame;
    protected Flame[] flames;

    public Bomb(int x, int y) {
        super(x, y);
        this.frame = 0;
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
        timeToExplode = Math.max(--timeToExplode,0);
        if(timeToExplode == 0) {
            explore();
            explodeTime = Math.max(--explodeTime,0);
            if(explodeTime == 0)
                remove = true;
        }
    }

    @Override
    public void render(Screen screen) {
        if(timeToExplode == 0) {
            renderFlames(screen);
        }
        else {
            loadSprite();
            screen.renderEntity((int) x, (int) y, this);
        }
    }
    public void renderFlames(Screen screen) {
        for(Flame flame: flames) {
            flame.render(screen);
        }
    }
    public void explore() {
        flames = new Flame[5];
        flames[0] = new Flame(x ,y - 16,0);
        flames[1] = new Flame(x + 16,y,1);
        flames[2] = new Flame(x,y + 16,2);
        flames[3] = new Flame(x - 16,y,3);
        flames[4] = new Flame(x,y,4);
    }
    private void loadSprite() {
        int _frame = (frame / 15) % 3;
        sprite = Sprite.bomb[_frame];
    }
    @Override
    public boolean collide(Entity e) {

        if (e instanceof Bomber) {
            double diffX = x - e.getX();
            double diffY = y - e.getY() + sprite.SIZE;

            return (diffX >= -15 && diffX <= 10 && diffY <= 15 && diffY >= -11);
        }
        return false;
    }
}
