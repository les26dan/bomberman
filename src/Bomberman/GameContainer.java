package Bomberman;

import Bomberman.Entities.Bomb.Bomb;
import Bomberman.Entities.Dynamic.Bomber;
import Bomberman.Entities.Dynamic.DynamicEntity;
import Bomberman.Entities.Dynamic.Enemy.Enemy;
import Bomberman.Entities.Entity;
import Bomberman.Keyboard.Keyboard;
import Bomberman.graphics.Screen;
import Bomberman.graphics.Unit;
import Bomberman.level.Level;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameContainer {

    protected Game game;
    protected Keyboard input;
    protected Screen screen;
    protected Level level;
    public Entity[] entities;
    public List<DynamicEntity> dynamicEntities = new ArrayList<>();
    public List<Bomb> bombs = new ArrayList<>();
    protected boolean[] plantedBomb;
    protected int[] existedFlame;

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
        renderBombs(screen);
        renderDynamicEntity(screen);
    }

    protected void renderDynamicEntity(Screen screen) {
        for (DynamicEntity d : dynamicEntities)
            d.render(screen);
    }

    protected void renderBombs(Screen screen) {
        for (Bomb d : bombs)
            d.render(screen);
    }

    protected void renderEntities(Screen screen) {
        for (int i = 0; i < level.getHeight(); i++)
            for (int j = 0; j < level.getWidth(); j++)
                entities[i * level.getWidth() + j].render(screen);
    }

    public void changeLevel(int num) {
        try {
            level = new Level("levels/Level" + 1 + ".txt", this);
            entities = new Entity[level.getHeight() * level.getWidth()];
            plantedBomb = new boolean[level.getHeight() * level.getWidth()];
            existedFlame = new int[level.getHeight() * level.getWidth()];
            level.createEntities();
        } catch (IOException e) {
        }
    }

    public void addEntity(int pos, Entity entity) {
        entities[pos] = entity;
    }

    public void addDynamicEntity(DynamicEntity d) {
        dynamicEntities.add(d);
    }

    public void addBomb(Bomb b) {
        bombs.add(b);
        plantedBomb[Unit.pixelToPos(b.getX()) + Unit.pixelToPos(b.getY()) * level.getWidth()] = true;
    }
    public void setExistedFlame(int posX,int posY,int add) {
        existedFlame[posX + posY * level.getWidth()] += add;
    }
    public int getExistedFlame(int posX,int posY) {
        return existedFlame[posX + posY * level.getWidth()];
    }
    void update() {
        updateEntities();
        updateDynamic();
        updateBombs();
        for (int i = 0; i < dynamicEntities.size(); i++) {
            DynamicEntity a = dynamicEntities.get(i);
            if (a.isRemoved()) dynamicEntities.remove(i);
        }
    }

    void updateEntities() {
        for (Entity e : entities) {
            e.update();
        }
    }

    void updateDynamic() {
        for (DynamicEntity d : dynamicEntities) {
            d.update();
        }
    }

    void updateBombs() {
        for (Bomb b : bombs) {
            b.update();
        }
    }

    public Keyboard getInput() {
        return input;
    }

    public List<Bomb> getBombs() {
        return bombs;
    }

    public Entity getEntity(int posX, int posY, DynamicEntity except) {
        if (plantedBomb[posX + posY * level.getWidth()]) {
                for (Bomb b : bombs) {
                    if (Unit.pixelToPos(b.getX()) == posX && Unit.pixelToPos(b.getY()) == posY)
                        return b;
                }
            }
        for (DynamicEntity cur : dynamicEntities) {
            if (cur == except) continue;
            if (cur.posX() == posX && cur.posY() == posY) {
                return cur;
            }
        }
            return entities[posX + posY * level.getWidth()].getEntity();
    }

    public Bomber getBomber() {
        for (DynamicEntity dynamicEntity : dynamicEntities) {
            if (dynamicEntity instanceof Bomber) {
                return (Bomber) dynamicEntity;
            }
        }
        return null;
    }
    public boolean allEnemiesDead() {
        int res = 0;
        for (DynamicEntity dynamicEntity: dynamicEntities) {
            if(dynamicEntity instanceof Enemy)
                ++res;
        }
        return (res == 0);
    }

}
