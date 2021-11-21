package Bomberman;

import Bomberman.Entities.Box.Wall;
import Bomberman.Entities.Dynamic.Bomber;
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
    public Bomber player;
    public Entity[] entities;

    public GameContainer(Game game, Keyboard input, Screen screen) {
        this.game = game;
        this.input = input;
        this.screen = screen;
        changeLevel(1);
    }

    public void newGame() {
        player = new Bomber(16, 32, this);
    }

    public void render(Screen screen) {
        renderEntities(screen);
        renderMobs(screen);
    }

    protected void renderMobs(Screen screen) {
        player.render(screen);
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
        }
    }

    public void addEntitie(int pos, Entity entity) {
        System.out.println(pos);
        entities[pos] = entity;
    }
}
