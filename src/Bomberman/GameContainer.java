package Bomberman;

import Bomberman.Entities.Box.Wall;
import Bomberman.Entities.Dynamic.Bomber;
import Bomberman.Entities.Dynamic.DynamicEntity;
import Bomberman.Entities.Entity;
import Bomberman.Keyboard.Keyboard;
import Bomberman.graphics.Screen;
import Bomberman.level.Level;

import java.io.IOException;

public class GameContainer {

    protected Game game;
    protected Keyboard input;
    protected Screen screen;
    protected Level level;
    public Bomber bomber;
    public Entity[] entities;

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
        renderMobs(screen);
    }

    protected void renderMobs(Screen screen) {
        bomber.render(screen);
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
            bomber = new Bomber(16,32,this);
        }
        catch (IOException e) {
            System.out.println("");
        }
    }

    public void addEntitie(int pos, Entity entity) {
        entities[pos] = entity;
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
        bomber.update();
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
