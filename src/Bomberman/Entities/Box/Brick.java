package Bomberman.Entities.Box;

import Bomberman.graphics.Sprite;

public class Brick extends Box {
    public Brick(int x, int y) {
        super(x, y);
        this.sprite = Sprite.brick;
        block = true;
    }

}
