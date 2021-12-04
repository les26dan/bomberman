package Bomberman.Entities.Box.Item;

import Bomberman.Entities.Entity;
import Bomberman.graphics.Sprite;

public class SpeedItem extends Item {
    public SpeedItem(int x, int y) {
        super(x, y);
        sprite = Sprite.speedItem;
    }
    @Override
    public boolean collide(Entity e) {
        return true;
    }
}
