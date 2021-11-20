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

    public void renderEntity(int xp, int yp, Entity entity) {
        for (int y = 0; y < entity.getSprite().getSize(); y++) {
            int ya = y + yp;
            for (int x = 0; x < entity.getSprite().getSize(); x++) {
                int xa = x + xp;
                if (xa < -entity.getSprite().getSize() || xa >= WIDTH || ya < 0 || ya >= HEIGHT)
                    break;
                if (xa < 0) xa = 0;
                int color = entity.getSprite().getPixel(x + y * entity.getSprite().getSize());
                if (color != backgroundColor) pixels[xa + ya * WIDTH] = color;
            }
        }
    }
}


