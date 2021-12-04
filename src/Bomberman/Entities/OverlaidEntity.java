package Bomberman.Entities;

import Bomberman.graphics.Screen;

import java.util.ArrayDeque;

public class OverlaidEntity extends Entity {
    private ArrayDeque<Entity> entities;

    public OverlaidEntity(int x, int y, Entity ... entities){
        super(x, y);
        this.entities = new ArrayDeque<>();
        for(Entity entity : entities) {
            this.entities.addLast(entity);
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
        // Add check top of
        entities.getFirst().update();
    }
}
