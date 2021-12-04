package Bomberman.Entities.Box.Item;

import Bomberman.Entities.Entity;
import Bomberman.graphics.Sprite;

public class FlameItem extends Item {
    public FlameItem(int x, int y) {
        super(x, y);
        sprite = Sprite.flameItem;
    }
    @Override
    public boolean collide(Entity e) {
        return true;
    }
}
