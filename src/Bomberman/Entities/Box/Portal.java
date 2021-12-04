package Bomberman.Entities.Box;

import Bomberman.graphics.Sprite;

public class Portal extends Box {
    public Portal(int x, int y) {
        super(x, y);
        sprite = Sprite.portal;
        block = true;
    }
}
