package Bomberman.Entities.Bomb;

import Bomberman.Entities.Entity;
import Bomberman.graphics.Screen;
import Bomberman.graphics.Sprite;

public class Flame extends Entity {
    protected boolean last;
    protected int direction;

    public Flame(double x, double y, int direction,boolean last){
        super(x,y);
        this.direction = direction;
        this.last = last;
    }
    @Override
    public void render(Screen screen) {
        loadSprite();
        screen.renderEntity((int) x, (int) y , this);
    }
    @Override
    public void update() {
    }
    @Override
    public boolean collide(Entity e) {
        return false;
    }
    void loadSprite() {
        switch (direction) {
            case 0:
                if(last) {
                    sprite = Sprite.flame_vertical_top[2];
                }
                else {
                    sprite = Sprite.flame_vertical[2];
                }
                break;
            case 1:
                if(last) {
                    sprite = Sprite.flame_horizontal_right[2];
                } else {
                    sprite = Sprite.flame_horizontal[2];
                }
                break;
            case 2:
                if(last) {
                    sprite = Sprite.flame_vertical_bot[2];
                } else {
                    sprite = Sprite.flame_vertical[2];
                }
                break;
            case 3:
                if(last) {
                    sprite = Sprite.flame_horizontal_left[2];
                } else {
                    sprite = Sprite.flame_horizontal[2];
                }
                break;
            case 4:
                sprite = Sprite.bomb_exploded[2];
                break;
        }
    }
}
