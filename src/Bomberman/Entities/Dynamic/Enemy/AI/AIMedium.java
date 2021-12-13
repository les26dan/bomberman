package Bomberman.Entities.Dynamic.Enemy.AI;

import Bomberman.Entities.Dynamic.Bomber;
import Bomberman.Entities.Dynamic.Enemy.Enemy;

public class AIMedium extends AI {
    private Bomber bomber;
    private Enemy enemy;

    public AIMedium(Bomber bomber, Enemy enemy) {
        this.bomber = bomber;
        this.enemy = enemy;
    }

    @Override
    public int calculateDirection() {
        boolean horizontal = random.nextBoolean();
        if (horizontal) {
            int _direction = calculateHorizontalDirection();
            if(_direction != -1) {
                return _direction;
            } else {
                return calculateVerticalDirection();
            }
        } else {
            int _direction = calculateVerticalDirection();
            if(_direction != -1) {
                return _direction;
            } else {
                return calculateHorizontalDirection();
            }
        }
    }
   //  0 : up 1: right 2 down 3 left
    public int calculateHorizontalDirection() {
        if(bomber.getX() < enemy.getX()) {
            return 3;
        } else if(bomber.getX() > enemy.getX()){
            return 1;
        }
        return -1;
    }

    public int calculateVerticalDirection() {
        if(bomber.getY() < enemy.getY()) {
            return 0;
        } else if(bomber.getY() > enemy.getY()){
            return 2;
        }
        return -1;
    }
}
