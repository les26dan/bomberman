package Bomberman.graphics;
import Bomberman.Entities.Dynamic.Bomber;
import Bomberman.Entities.Entity;
import Bomberman.Game;
import Bomberman.GameContainer;

import java.awt.*;


public class Screen {
    protected int WIDTH, HEIGHT;
    public int[] pixels;
    private int backgroundColor = 0xffff00ff;
    public static int addX = 0;

    public Screen(int width, int height) {
        WIDTH = width;
        HEIGHT = height;
        pixels = new int[width * height];
    }


    public void renderEntity(int x, int y, Entity entity) {
        x -= addX;
        for (int v = 0; v < entity.getSprite().getSize(); v++) {
            int yy = v + y;
            for (int u = 0; u < entity.getSprite().getSize(); u++) {
                int xx = u + x;
                if (yy < 0 || yy >= HEIGHT  || xx >= WIDTH || xx < -entity.getSprite().getSize())
                    break;
                if (xx < 0) xx = 0;
                int color = entity.getSprite().getPixel(u + v * entity.getSprite().getSize());
                if (color != backgroundColor)
                    pixels[xx + yy * WIDTH] = color;
            }
        }
    }

    public static int checkCameraPosition(GameContainer gameContainer, Bomber bomber) {
        if(bomber == null) return 0;
        int res = addX;
        double bomberPosition = bomber.getX() / Game.BOX_SIZE;
        double addition = 0.5;
        int left = gameContainer.getWidth() / 4 + 3;
        int right = gameContainer.getWidth() - left;

        if( bomberPosition > left + addition && bomberPosition < right - addition) {
            res = (int)bomber.getX()  - (Game.WIDTH / 2);
        }

        return res;
    }
    public void drawWinGame(Graphics g, int points) {
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH* Game.SCALE, HEIGHT*Game.SCALE);

        Font font = new Font("Lucida Console", Font.PLAIN, 20 * Game.SCALE);
        g.setFont(font);
        g.setColor(Color.white);
        drawCenteredString("YOU WIN", WIDTH* Game.SCALE, HEIGHT*Game.SCALE, g);

        font = new Font("Lucida Console", Font.PLAIN, 10 * Game.SCALE);
        g.setFont(font);
        g.setColor(Color.yellow);
        drawCenteredString("POINTS: " + points, WIDTH* Game.SCALE, HEIGHT*Game.SCALE + (Game.BOX_SIZE * 4) * Game.SCALE, g);

        font = new Font("Lucida Console", Font.PLAIN, 10 * Game.SCALE);
        g.setFont(font);
        g.setColor(Color.gray);
        drawCenteredString("Press any key to start new game", WIDTH* Game.SCALE, HEIGHT*Game.SCALE + (Game.BOX_SIZE * 6) * Game.SCALE, g);
    }
    public void drawChangeLevel(Graphics g, int level) {
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH* Game.SCALE, HEIGHT*Game.SCALE);

        Font font = new Font("Lucida Console", Font.PLAIN, 20 * Game.SCALE);
        g.setFont(font);
        g.setColor(Color.white);
        drawCenteredString("LEVEL " + level, WIDTH* Game.SCALE, HEIGHT*Game.SCALE, g);
    }
    public void drawCenteredString(String s, int w, int h, Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        int x = (w - fm.stringWidth(s)) / 2;
        int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
        g.drawString(s, x, y);
    }
}


