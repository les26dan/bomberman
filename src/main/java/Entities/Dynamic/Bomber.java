package Entities.Dynamic;

import Entities.Dynamic.DynamicEntity;

public class Bomber extends DynamicEntity {
    protected int hearts;
    protected int numBomb;
    protected int score;
    protected int sizeBomb;


    public Bomber(int x, int y, int speed, int direction, int hearts, int numBomb, int score, int sizeBomb) {
        super(x, y, speed, direction);
        this.hearts = hearts;
        this.numBomb = numBomb;
        this.score = score;
        this.sizeBomb = sizeBomb;
    }

    public int getHearts() {
        return hearts;
    }

    public void setHearts(int hearts) {
        this.hearts = hearts;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getNumBomb() {
        return numBomb;
    }

    public void setNumBomb(int numBomb) {
        this.numBomb = numBomb;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public void update() {

    }
}
