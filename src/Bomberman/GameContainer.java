package Bomberman;

import Bomberman.Entities.Box.Wall;
import Bomberman.Entities.Dynamic.Bomber;
import Bomberman.Entities.Dynamic.DynamicEntity;
import Bomberman.Entities.Entity;
import Bomberman.Keyboard.Keyboard;
import Bomberman.graphics.Screen;
import Bomberman.level.Level;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class GameContainer {

    protected Game game;
    protected Keyboard input;
    protected Screen screen;
    protected Level level;
    public Entity[] entities;
    public List<DynamicEntity> dynamicEntities = new ArrayList<>();

    public GameContainer(Game game, Keyboard input, Screen screen) {
        this.game = game;
        this.input = input;
        this.screen = screen;
        changeLevel(1);
    }

    public void newGame() {
    }

    public void render(Screen screen) {
        renderEntities(screen);
        renderDynamicEntity(screen);
    }

    protected void renderDynamicEntity(Screen screen) {
        for(DynamicEntity d: dynamicEntities)
            d.render(screen);
    }
    protected void renderEntities(Screen screen) {
        for(int i = 0; i < level.getHeight(); i++)
            for(int j = 0; j < level.getWidth(); j++)
                entities[i * level.getWidth() + j].render(screen);
    }
    public void changeLevel(int num)  {
        try {
            level = new Level("levels/Level" + num + ".txt", this);
            entities = new Entity[level.getHeight() * level.getWidth()];
            level.createEntities();
        }
        catch (IOException e) {
            System.out.println("");
        }
    }

    public void addEntitie(int pos, Entity entity) {
        entities[pos] = entity;
    }
    public void addDynamicEntity(DynamicEntity d) {
        if(dynamicEntities.size() < 2) dynamicEntities.add(d);
    }
    void update() {
        updateEntities();
        updateDynamic();
    }
    void updateEntities() {
        for(Entity e: entities){
            e.update();
        }
    }
    void updateDynamic() {
        for(DynamicEntity d: dynamicEntities){
            d.update();
        }
    }

    public Keyboard getInput() {
        return input;
    }
    public Entity getEntity(int posX, int posY, DynamicEntity dynamic) {

        Entity entity = getEntityAt(posX, posY);
        return entity;
    }
    public Entity getEntityAt(int posX , int posY) {
        return entities[posX + posY * level.getWidth()];
    }
}
