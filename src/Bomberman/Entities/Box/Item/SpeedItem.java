package Bomberman.Entities.Box.Item;

import Bomberman.Entities.Dynamic.Bomber;
import Bomberman.Entities.Entity;
import Bomberman.Sound.Sound;
import Bomberman.Sound.SoundController;
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
                Sound sound = new Sound(SoundController.EAT_ITEM);
                sound.play();
            }
            remove = true;
            return true;
        }
        return true;
    }
}
