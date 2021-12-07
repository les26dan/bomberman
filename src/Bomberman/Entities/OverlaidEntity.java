package Bomberman.Entities;

import Bomberman.Entities.Box.Brick;
import Bomberman.graphics.Screen;

import java.util.ArrayDeque;

public class OverlaidEntity extends Entity {
    private ArrayDeque<Entity> entities;

    public OverlaidEntity(int x, int y, Entity... entities) {
        super(x, y);
        this.entities = new ArrayDeque<>();
        for (int i = 0; i < entities.length; ++i) {
            this.entities.addLast(entities[i]);
            if (entities[i] instanceof Brick) {
                ((Brick) entities[i]).setBelowEntity(entities[i + 1]);
            }
        }
    }

    @Override
    public Entity getEntity() {
        return entities.getFirst().getEntity();
    }

    @Override
    public void render(Screen screen) {
        entities.getFirst().render(screen);
    }

    @Override
    public void update() {
        Entity e = entities.getFirst();
        if (e.isRemoved()) {
            entities.removeFirst();
        }
        // Add check top of
        entities.getFirst().update();
    }

    @Override
    public boolean collide(Entity e) {
        return entities.getFirst().collide(e);
    }
}
