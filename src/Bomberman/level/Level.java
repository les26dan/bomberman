package Bomberman.level;

import Bomberman.Entities.Box.Grass;
import Bomberman.Entities.Box.Wall;
import Bomberman.Entities.Dynamic.Bomber;
import Bomberman.Entities.Dynamic.Enemy.Balloon;
import Bomberman.Game;
import Bomberman.GameContainer;
import Bomberman.graphics.Coordinate;
import Bomberman.graphics.Sprite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.StringTokenizer;

public class Level {
    protected int level, width, height;
    protected String[] map;
    protected GameContainer gameContainer;

    public Level(String path, GameContainer gameContainer) throws IOException {
        load(path);
        this.gameContainer = gameContainer;
    }

    public void load(String path) throws IOException {

        URL url = Level.class.getResource("/" + path);

        BufferedReader inp = new BufferedReader(
                new InputStreamReader(url.openStream()));

        String data = inp.readLine();
        StringTokenizer str = new StringTokenizer(data);

        level = Integer.parseInt(str.nextToken());
        height = Integer.parseInt(str.nextToken());
        width = Integer.parseInt(str.nextToken());

        map = new String[height];

        for (int i = 0; i < height; ++i) {
            map[i] = inp.readLine().substring(0, width);
        }

        inp.close();
    }

    public void createEntities() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                char c = map[y].charAt(x);
                int pos = x + y * width;

                switch (c) {
                    case '#':
                        gameContainer.addEntitie(pos, new Wall(x, y));
                        break;
                    case '1':
                        gameContainer.addEntitie(pos, new Grass(x, y));
                        gameContainer.addDynamicEntity(new Balloon(Coordinate.posToPixel(x), Coordinate.posToPixel(y) + Game.BOX_SIZE, gameContainer));
                        break;
                    case 'p':
                        gameContainer.addDynamicEntity(new Bomber(Coordinate.posToPixel(x), Coordinate.posToPixel(y) + Game.BOX_SIZE, gameContainer));
                    default:
                        gameContainer.addEntitie(pos, new Grass(x, y));
                        break;
                }
            }
        }
    }

    public int getLevel() {
        return level;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
