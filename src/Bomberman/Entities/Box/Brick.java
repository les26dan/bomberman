package Bomberman.Entities.Box;

import Bomberman.Entities.Bomb.Bomb;
import Bomberman.Entities.Bomb.Flame;
import Bomberman.Entities.Entity;
import Bomberman.graphics.Screen;
import Bomberman.graphics.Sprite;
import Bomberman.graphics.Unit;

public class Brick extends Box {
    protected int frame;
    protected int brokenTime = 20;
    protected boolean broken = false;
    public Brick(int x, int y) {
        super(x, y);
    }
    @Override
    public void update() {
        if(broken) {
            frame = (frame + 1) % 1000;
            if(brokenTime > 0)
                brokenTime--;
            else
                remove = true;
        }
    }
    @Override
    public void render(Screen screen) {
        int _frame = (frame / 10) % 3;
        if(broken) {
            sprite = Sprite.broken_brick[_frame];
            screen.renderEntity(Unit.posToPixel(x), Unit.posToPixel(y), this);
        }
        else {
            sprite = Sprite.brick;
            screen.renderEntity(Unit.posToPixel(x), Unit.posToPixel(y), this);

        }
    }

    @Override
    public boolean collide(Entity e) {
        if(e instanceof Bomb) {
            broken = true;
        }
        return false;
    }
}
