package Bomberman.Entities.Box;


import Bomberman.graphics.Sprite;

public class Wall extends Box {

    public Wall(int x, int y) {
        super(x, y);
        sprite = Sprite.wall;
        block = true;
    }

}
