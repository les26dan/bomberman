package Bomberman.Entities.Box;

import Bomberman.Entities.Entity;
import Bomberman.graphics.Unit;
import Bomberman.graphics.Screen;

public abstract class Box extends Entity {
    public Box(int x, int y) {
        super(x,y);
    }

    @Override
    public void update() {
    }

    @Override
    public void render(Screen screen) {
        screen.renderEntity( Unit.posToPixel(x), Unit.posToPixel(y), this);
    }
}
