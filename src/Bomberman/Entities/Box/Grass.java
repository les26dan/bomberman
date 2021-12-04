package Bomberman.Entities.Box;


import Bomberman.Entities.Entity;
import Bomberman.graphics.Sprite;

public class Grass extends Box {

    public Grass(int x, int y) {
        super(x, y);
        sprite = Sprite.grass;
    }
    public boolean collide(Entity e) {
        return true;
    }
}
