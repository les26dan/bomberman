package Bomberman.graphics;
import Bomberman.Entities.Entity;

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
}


