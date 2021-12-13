package Bomberman.graphics;
import Bomberman.Entities.Entity;
import Bomberman.Game;

import java.awt.*;


public class Screen {
    protected int WIDTH, HEIGHT;
    public int[] pixels;
    private int backgroundColor = 0xffff00ff;

    public Screen(int width, int height) {
        WIDTH = width;
        HEIGHT = height;
        pixels = new int[width * height];
    }

    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

    public void renderEntity(int x, int y, Entity entity) {
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
        drawCenteredString("Press any key to continue", WIDTH* Game.SCALE, HEIGHT*Game.SCALE + (Game.BOX_SIZE * 6) * Game.SCALE, g);
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


