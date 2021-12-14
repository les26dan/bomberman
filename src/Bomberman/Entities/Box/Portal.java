package Bomberman.Entities.Box;

import Bomberman.Entities.Dynamic.Bomber;
import Bomberman.Entities.Entity;
import Bomberman.GameContainer;
import Bomberman.graphics.Sprite;

public class Portal extends Box {
    public Portal(int x, int y, GameContainer gameContainer) {
        super(x, y);
        sprite = Sprite.portal;
        this.gameContainer = gameContainer;
    }

    @Override
    public boolean collide(Entity e) {

        if (e instanceof Bomber) {

            if (!gameContainer.allEnemiesDead())
                return false;

            if (e.posX() == getX() && e.posY() == getY()) {
                e.remove();
                gameContainer.setNextLevelTime(4);
            }

            return true;
        }

        return false;
    }
}
