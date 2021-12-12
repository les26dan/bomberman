package Bomberman.Entities.Box.Item;

import Bomberman.Entities.Dynamic.Bomber;
import Bomberman.Entities.Entity;
import Bomberman.Sound.Sound;
import Bomberman.graphics.Sprite;

public class SpeedItem extends Item {
    public SpeedItem(int x, int y) {
        super(x, y);
        sprite = Sprite.speedItem;
    }
    @Override
    public boolean collide(Entity e) {
        if(e instanceof Bomber) {
            if(!remove) {
                ((Bomber) e).addSpeedItem();
                Sound.eatItem.setFramePosition(0);
                Sound.eatItem.start();
            }
            remove = true;
            return true;
        }
        return true;
    }
}
