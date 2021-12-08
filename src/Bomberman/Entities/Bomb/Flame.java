package Bomberman.Entities.Bomb;

import Bomberman.Entities.Entity;
import Bomberman.graphics.Screen;
import Bomberman.graphics.Sprite;

public class Flame extends Entity {
    protected boolean last;
    protected int direction;
    protected int frame = 0;

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
        frame = (frame + 1) % 1000;
    }
    @Override
    public boolean collide(Entity e) {
        return false;
    }
    void loadSprite() {
        int _frame = 0;
        if(frame >= 3) _frame = 1;
        if(frame >= 6) _frame = 2;
        if(frame >= 14) _frame = 1;
        if(frame >= 17) _frame = 0;
        switch (direction) {
            case 0:
                if(last) {
                    sprite = Sprite.flame_vertical_top[_frame];
                }
                else {
                    sprite = Sprite.flame_vertical[_frame];
                }
                break;
            case 1:
                if(last) {
                    sprite = Sprite.flame_horizontal_right[_frame];
                } else {
                    sprite = Sprite.flame_horizontal[_frame];
                }
                break;
            case 2:
                if(last) {
                    sprite = Sprite.flame_vertical_bot[_frame];
                } else {
                    sprite = Sprite.flame_vertical[_frame];
                }
                break;
            case 3:
                if(last) {
                    sprite = Sprite.flame_horizontal_left[_frame];
                } else {
                    sprite = Sprite.flame_horizontal[_frame];
                }
                break;
            case 4:
                sprite = Sprite.bomb_exploded[_frame];
                break;
        }
    }
}
