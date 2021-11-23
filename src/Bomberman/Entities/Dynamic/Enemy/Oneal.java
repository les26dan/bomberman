package Bomberman.Entities.Dynamic.Enemy;

import Bomberman.graphics.Screen;

public class Oneal extends Enemy {

    public Oneal(int x, int y, int speed, int direction, int value) {
        super(x, y, speed, direction, value);
    }


    @Override
    public void update() {

    }
    @Override
    public void render(Screen screen) {
    }
    @Override
    protected void move(){

    }
    @Override
    protected boolean canMove(int x, int y){
        return true;
    }
}
