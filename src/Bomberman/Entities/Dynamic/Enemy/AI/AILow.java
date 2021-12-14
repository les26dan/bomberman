package Bomberman.Entities.Dynamic.Enemy.AI;

import Bomberman.Entities.Dynamic.Enemy.Enemy;
import Bomberman.Game;

public class AILow extends AI {
    Enemy enemy;
    public AILow(Enemy enemy) {
        this.enemy = enemy;
    }

    @Override
    public int calculateDirection() {
        if (enemy.getSteps() <= 0)
        {
            enemy.setSteps(Game.BOX_SIZE * 1.0 / enemy.getSpeed());
            return random.nextInt(4);
        }
        return enemy.getDirection();
    }
}
