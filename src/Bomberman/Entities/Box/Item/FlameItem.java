package Bomberman.Entities.Box.Item;

import Bomberman.Entities.Dynamic.Bomber;
import Bomberman.Entities.Entity;
import Bomberman.Sound.Sound;
import Bomberman.Sound.SoundController;
import Bomberman.graphics.Sprite;

public class FlameItem extends Item {
    public FlameItem(int x, int y) {
        super(x, y);
        sprite = Sprite.flameItem;
    }
    @Override
    public boolean collide(Entity e) {
        if(e instanceof Bomber) {
            if(!remove) {
                ((Bomber) e).addFlameItem();
                Sound sound = new Sound(SoundController.EAT_ITEM);
                sound.play();
            }
            remove = true;
            return true;
        }
        return true;
    }
}
