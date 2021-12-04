package Bomberman.Entities.Dynamic.Enemy.AI;

public class AILow extends AI {

    @Override
    public int calculateDirection() {
        return random.nextInt(4);
    }
}
