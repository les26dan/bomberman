package Bomberman.graphics;

public class Sprite {

    private SpriteLoader sheet;
    public final int SIZE;
    private int x, y;
    public int[] pixels;

    public static Sprite[] bomber_up = new Sprite[3];
    public static Sprite[] bomber_down = new Sprite[3];
    public static Sprite[] bomber_left = new Sprite[3];
    public static Sprite[] bomber_right = new Sprite[3];

    public static Sprite[] balloom_left = new Sprite[3];
    public static Sprite[] balloom_right = new Sprite[3];
    public static Sprite balloom_dead;

    public static Sprite grass = new Sprite(16, 6, 0, SpriteLoader.origin);
    public static Sprite brick = new Sprite(16, 7, 0, SpriteLoader.origin);
    public static Sprite wall = new Sprite(16, 5, 0, SpriteLoader.origin);
    public static Sprite portal = new Sprite(16, 4, 0, SpriteLoader.origin);

    public Sprite(int size, int x, int y, SpriteLoader sheet) {
        this.SIZE = size;
        this.x = x * SIZE;
        this.y = y * SIZE;
        this.sheet = sheet;
        pixels = new int[SIZE * SIZE];
        load();
    }

    public static void init() {
        bomber_up[0] = new Sprite(16, 0, 0, SpriteLoader.origin);
        bomber_up[1] = new Sprite(16, 0, 1, SpriteLoader.origin);
        bomber_up[2] = new Sprite(16, 0, 2, SpriteLoader.origin);
        bomber_down[0] = new Sprite(16, 2, 0, SpriteLoader.origin);
        bomber_down[1] = new Sprite(16, 2, 1, SpriteLoader.origin);
        bomber_down[2] = new Sprite(16, 2, 2, SpriteLoader.origin);

        bomber_left[0] = new Sprite(16, 3, 0, SpriteLoader.origin);
        bomber_left[1] = new Sprite(16, 3, 1, SpriteLoader.origin);
        bomber_left[2] = new Sprite(16, 3, 2, SpriteLoader.origin);

        bomber_right[0] = new Sprite(16, 1, 0, SpriteLoader.origin);
        bomber_right[1] = new Sprite(16, 1, 1, SpriteLoader.origin);
        bomber_right[2] = new Sprite(16, 1, 2, SpriteLoader.origin);

        balloom_left[0]= new Sprite(16, 9, 0, SpriteLoader.origin);
        balloom_left[1]= new Sprite(16, 9, 1, SpriteLoader.origin);
        balloom_left[2]= new Sprite(16, 9, 2, SpriteLoader.origin);

        balloom_right[0]= new Sprite(16, 10, 0, SpriteLoader.origin);
        balloom_right[1]= new Sprite(16, 10, 1, SpriteLoader.origin);
        balloom_right[2]= new Sprite(16, 10, 2, SpriteLoader.origin);
        balloom_dead = new Sprite(16, 9, 3, SpriteLoader.origin);

    }

    private void load() {
        for (int u = 0; u < SIZE; u++)
            for (int v = 0; v < SIZE; v++)
                pixels[u + v * SIZE] = sheet.pixels[(u + x) + (v + y) * sheet.SIZE];
    }

    public int getSize() {
        return SIZE;
    }

    public int getPixel(int i) {
        return pixels[i];
    }

}
