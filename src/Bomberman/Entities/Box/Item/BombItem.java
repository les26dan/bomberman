package Bomberman.Entities.Box.Item;

import Bomberman.Entities.Dynamic.Bomber;
import Bomberman.Entities.Entity;
import Bomberman.graphics.Sprite;

public class BombItem extends Item {
    public BombItem(int x, int y) {
        super(x, y);
        sprite = Sprite.bombItem;
    }
    @Override
    public boolean collide(Entity e) {
        if(e instanceof Bomber) {
            if(!remove) ((Bomber) e).addBombItem();
            remove = true;
            return true;
        }
        return true;
    }
}
