package Bomberman.Entities.Box.Item;

import Bomberman.graphics.Sprite;

public class BombItem extends Item {
    public BombItem(int x, int y) {
        super(x, y);
        sprite = Sprite.bombItem;
    }
}
