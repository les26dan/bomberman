package Bomberman;

import Bomberman.Entities.Bomb.Bomb;
import Bomberman.Entities.Dynamic.Bomber;
import Bomberman.Entities.Dynamic.DynamicEntity;
import Bomberman.Entities.Dynamic.Enemy.Enemy;
import Bomberman.Entities.Entity;
import Bomberman.Keyboard.Keyboard;
import Bomberman.Sound.SoundController;
import Bomberman.UI.Dialog;
import Bomberman.graphics.Screen;
import Bomberman.graphics.Unit;
import Bomberman.level.Level;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameContainer {

    protected Game game;
    protected Keyboard input;
    protected Screen screen;
    private SoundController soundController;
    protected Level level;
    protected Entity[] entities;
    protected List<DynamicEntity> dynamicEntities = new ArrayList<>();
    protected List<Bomb> bombs = new ArrayList<>();
    protected List<Dialog> dialogs = new ArrayList<>();
    protected boolean[] plantedBomb;
    protected int[] existedFlame;
    protected int time;
    protected int points;
    protected int lastPoints;
    protected int pauseTime;
    protected int nextLevelTime;
    protected int screenType;
    private boolean killedEnemy = false;

    public GameContainer(Game game, Keyboard input, Screen screen, SoundController soundController) {
        this.game = game;
        this.input = input;
        this.screen = screen;
        this.soundController = soundController;
        newGame();
    }

    public void render(Screen screen) {
        renderEntities(screen);
        renderBombs(screen);
        renderDynamicEntity(screen);
    }

    protected void renderDynamicEntity(Screen screen) {
        for (int i = 0; i < dynamicEntities.size(); i++)
            dynamicEntities.get(i).render(screen);
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

    public void renderDialog(Graphics g) {
        for (Dialog cur : dialogs) {
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.setColor(Color.yellow);
            g.drawString(cur.getDialog(), (int) cur.getX() - Screen.addX * Game.SCALE, (int) cur.getY());
        }
    }

    public void nextLevel() {
        changeLevel(level.getLevel() + 1);
        lastPoints = points;
    }

    public void restartLevel() {
        changeLevel(level.getLevel());
        points = lastPoints;
    }

    public void newGame() {
        changeLevel(1);
        points = 0;
    }

    public void changeLevel(int num) {
        dynamicEntities = new ArrayList<>();
        bombs = new ArrayList<>();
        time = 200;
        Screen.addX = 0;
        killedEnemy = false;
        if (num != 6) {
            screenType = 1;
            pauseTime = 2;
        } else {
            screenType = 2;
            pauseTime = 9999;
            return;
        }
        try {
            level = new Level("levels/Level" + num + ".txt", this);
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

    public void addDialog(Dialog dialog) {
        dialogs.add(dialog);
    }

    public void setExistedFlame(int posX, int posY, int add) {
        existedFlame[posX + posY * level.getWidth()] += add;
    }

    public int getExistedFlame(int posX, int posY) {
        return existedFlame[posX + posY * level.getWidth()];
    }

    void update() {
        if (time < 0) {
            restartLevel();
            return;
        }
        updateEntities();
        updateDynamic();
        updateBombs();
        updateDialogs();
        for (int i = 0; i < dynamicEntities.size(); i++) {
            DynamicEntity a = dynamicEntities.get(i);
            if (a.isRemoved()) {
                dynamicEntities.remove(i);
            }
        }
    }

    void updateEntities() {
        for (Entity e : entities) {
            e.update();
        }
    }

    void updateDynamic() {

        for (int i = 0; i < dynamicEntities.size(); i++) {
            dynamicEntities.get(i).update();
        }
    }

    void updateBombs() {
        for (Bomb b : bombs) {
            b.update();
        }
    }

    protected void updateDialogs() {
        for (int i = 0; i < dialogs.size(); i++) {
            Dialog cur = dialogs.get(i);
            int time = cur.getTime();
            cur.setTime(Math.max(0, --time));
            if (time == 0) dialogs.remove(i);
        }
    }

    public void setNextLevelTime(int nextLevelTime) {
        this.nextLevelTime = nextLevelTime;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setPauseTime(int pauseTime) {
        this.pauseTime = pauseTime;
    }

    public Keyboard getInput() {
        return input;
    }

    public List<Bomb> getBombs() {
        return bombs;
    }

    public int getNextLevelTime() {
        return nextLevelTime;
    }

    public int getTime() {
        return time--;
    }

    public int getPoints() {
        return points;
    }

    public Entity getEntity(int posX, int posY, DynamicEntity except) {
        if (plantedBomb[posX + posY * level.getWidth()]) {
            for (Bomb b : bombs) {
                if (Unit.pixelToPos(b.getX()) == posX && Unit.pixelToPos(b.getY()) == posY)
                    return b;
            }
        }
        for (int i = 0; i < dynamicEntities.size(); i++) {
            if (dynamicEntities.get(i) == except) continue;
            if (dynamicEntities.get(i).posX() == posX && dynamicEntities.get(i).posY() == posY) {
                return dynamicEntities.get(i);
            }
        }
        return entities[posX + posY * level.getWidth()].getEntity();
    }

    public int getPauseTime() {
        return pauseTime;
    }

    public Bomber getBomber() {
        for (int i = 0; i < dynamicEntities.size(); i++) {
            if (dynamicEntities.get(i) instanceof Bomber) {
                return (Bomber) dynamicEntities.get(i);
            }
        }
        return null;
    }

    public int getWidth() {
        return level.getWidth();
    }

    public int getHeight() {
        return level.getHeight();
    }

    public boolean allEnemiesDead() {
        int res = 0;
        for (int i = 0; i < dynamicEntities.size(); i++) {
            if (dynamicEntities.get(i) instanceof Enemy)
                ++res;
        }
        return (res == 0);
    }

    public void drawScreen(Graphics g) {
        if (screenType == 2)
            screen.drawWinGame(g, points);
        if (screenType == 1) screen.drawChangeLevel(g, level.getLevel());
    }

    public boolean isKilledEnemy() {
        return killedEnemy;
    }

    public void setKilledEnemy(boolean killedEnemy) {
        this.killedEnemy = killedEnemy;
    }

    public SoundController getSoundController() {
        return soundController;
    }
}
