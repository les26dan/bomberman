package Bomberman.Entities.Box.Item;

import Bomberman.graphics.Sprite;

public class FlameItem extends Item {
    public FlameItem(int x, int y) {
        super(x, y);
        sprite = Sprite.flameItem;
    }
}
