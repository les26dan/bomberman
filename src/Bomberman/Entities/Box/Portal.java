package Bomberman.Entities.Box;

import Bomberman.Entities.Entity;
import Bomberman.graphics.Sprite;

public class Portal extends Box {
    public Portal(int x, int y) {
        super(x, y);
        sprite = Sprite.portal;
    }
    @Override
    public boolean collide(Entity e) {
        return true;
    }
}
