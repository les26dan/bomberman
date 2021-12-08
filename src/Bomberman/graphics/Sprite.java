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
    public static Sprite[] bomber_dead = new Sprite[3];

    public static Sprite[] balloom_left = new Sprite[3];
    public static Sprite[] balloom_right = new Sprite[3];
    public static Sprite balloom_dead = new Sprite(16, 9, 3, SpriteLoader.origin);

    public static Sprite[] oneal_left = new Sprite[3];
    public static Sprite[] oneal_right = new Sprite[3];
    public static Sprite oneal_dead = new Sprite(16, 11, 3, SpriteLoader.origin);
    public static Sprite[] minvo_left= new Sprite[3];
    public static Sprite[] minvo_right= new Sprite[3];
    public static Sprite minvo_dead = new Sprite(16, 8, 8,SpriteLoader.origin);
    public static Sprite[] kondoria_left= new Sprite[3];
    public static Sprite[] kondoria_right= new Sprite[3];
    public static Sprite kondoria_dead = new Sprite(16, 10, 8,SpriteLoader.origin);
    public static Sprite[] doll_left = new Sprite[3];
    public static Sprite[] doll_right = new Sprite[3];
    public static Sprite doll_dead = new Sprite(16, 13, 3,SpriteLoader.origin);

    public static Sprite[] mob_dead = new Sprite[3];

    public static Sprite[] bomb = new Sprite[3];
    public static Sprite[] flame_vertical = new Sprite[3];
    public static Sprite[] flame_horizontal = new Sprite[3];
    public static Sprite[] flame_horizontal_left = new Sprite[3];
    public static Sprite[] flame_horizontal_right = new Sprite[3];
    public static Sprite[] flame_vertical_top = new Sprite[3];
    public static Sprite[] flame_vertical_bot = new Sprite[3];
    public static Sprite[] bomb_exploded = new Sprite[3];


    public static Sprite grass = new Sprite(16, 6, 0, SpriteLoader.origin);
    public static Sprite brick = new Sprite(16, 7, 0, SpriteLoader.origin);
    public static Sprite wall = new Sprite(16, 5, 0, SpriteLoader.origin);
    public static Sprite portal = new Sprite(16, 4, 0, SpriteLoader.origin);
    public static Sprite[] broken_brick = new Sprite[3];

    public static Sprite speedItem = new Sprite(16, 2, 10, SpriteLoader.origin);
    public static Sprite flameItem = new Sprite(16, 1, 10, SpriteLoader.origin);
    public static Sprite bombItem = new Sprite(16, 0, 10, SpriteLoader.origin);


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
        bomber_dead[0] = new Sprite(16, 4, 2, SpriteLoader.origin);
        bomber_dead[1] = new Sprite(16, 5, 2, SpriteLoader.origin);
        bomber_dead[2] = new Sprite(16, 6, 2, SpriteLoader.origin);

        bomber_left[0] = new Sprite(16, 3, 0, SpriteLoader.origin);
        bomber_left[1] = new Sprite(16, 3, 1, SpriteLoader.origin);
        bomber_left[2] = new Sprite(16, 3, 2, SpriteLoader.origin);

        bomber_right[0] = new Sprite(16, 1, 0, SpriteLoader.origin);
        bomber_right[1] = new Sprite(16, 1, 1, SpriteLoader.origin);
        bomber_right[2] = new Sprite(16, 1, 2, SpriteLoader.origin);

        bomb[0] = new Sprite(16, 0, 3, SpriteLoader.origin);
        bomb[1] = new Sprite(16, 1, 3, SpriteLoader.origin);
        bomb[2] = new Sprite(16, 2, 3, SpriteLoader.origin);

        balloom_left[0] = new Sprite(16, 9, 0, SpriteLoader.origin);
        balloom_left[1] = new Sprite(16, 9, 1, SpriteLoader.origin);
        balloom_left[2] = new Sprite(16, 9, 2, SpriteLoader.origin);

        balloom_right[0] = new Sprite(16, 10, 0, SpriteLoader.origin);
        balloom_right[1] = new Sprite(16, 10, 1, SpriteLoader.origin);
        balloom_right[2] = new Sprite(16, 10, 2, SpriteLoader.origin);
        balloom_dead = new Sprite(16, 9, 3, SpriteLoader.origin);

        oneal_left[0] = new Sprite(16, 11, 0, SpriteLoader.origin);
        oneal_left[1] = new Sprite(16, 11, 1, SpriteLoader.origin);
        oneal_left[2] = new Sprite(16, 11, 2, SpriteLoader.origin);

        oneal_right[0] = new Sprite(16, 12, 0, SpriteLoader.origin);
        oneal_right[1] = new Sprite(16, 12, 1, SpriteLoader.origin);
        oneal_right[2] = new Sprite(16, 12, 2, SpriteLoader.origin);

        doll_left[0] = new Sprite(16, 13, 0, SpriteLoader.origin);
        doll_left[1] = new Sprite(16, 13, 1, SpriteLoader.origin);
        doll_left[2] = new Sprite(16, 13, 2, SpriteLoader.origin);

        doll_right[0] = new Sprite(16, 14, 0, SpriteLoader.origin);
        doll_right[1] = new Sprite(16, 14, 1, SpriteLoader.origin);
        doll_right[2] = new Sprite(16, 14, 2, SpriteLoader.origin);

        minvo_left[0]= new Sprite(16, 8, 5, SpriteLoader.origin);
        minvo_left[1]= new Sprite(16, 8, 6, SpriteLoader.origin);
        minvo_left[2]= new Sprite(16, 8, 7, SpriteLoader.origin);

        minvo_right[0]= new Sprite(16, 9, 5, SpriteLoader.origin);
        minvo_right[1]= new Sprite(16, 9, 6, SpriteLoader.origin);
        minvo_right[2]= new Sprite(16, 9, 7, SpriteLoader.origin);

        kondoria_left[0]= new Sprite(16, 10, 5, SpriteLoader.origin);
        kondoria_left[1]= new Sprite(16, 10, 6, SpriteLoader.origin);
        kondoria_left[2]= new Sprite(16, 10, 7, SpriteLoader.origin);

        kondoria_right[0]= new Sprite(16, 11, 5, SpriteLoader.origin);
        kondoria_right[1]= new Sprite(16, 11, 6, SpriteLoader.origin);
        kondoria_right[2]= new Sprite(16, 11, 7, SpriteLoader.origin);

        mob_dead[0] = new Sprite(16, 15, 0, SpriteLoader.origin);
        mob_dead[1] = new Sprite(16, 15, 1, SpriteLoader.origin);
        mob_dead[2] = new Sprite(16, 15, 2, SpriteLoader.origin);

        broken_brick[0] = new Sprite(16, 7, 1, SpriteLoader.origin);
        broken_brick[1] = new Sprite(16, 7, 2, SpriteLoader.origin);
        broken_brick[2] = new Sprite(16, 7, 3, SpriteLoader.origin);

        bomb_exploded[0] = new Sprite(16, 0, 4, SpriteLoader.origin);
        bomb_exploded[1] = new Sprite(16, 0, 5, SpriteLoader.origin);
        bomb_exploded[2] = new Sprite(16, 0, 6, SpriteLoader.origin);

        flame_vertical[0] = new Sprite(16, 1, 5, SpriteLoader.origin);
        flame_vertical[1] = new Sprite(16, 2, 5, SpriteLoader.origin);
        flame_vertical[2] = new Sprite(16, 3, 5, SpriteLoader.origin);

        flame_horizontal[0] = new Sprite(16, 1, 7, SpriteLoader.origin);
        flame_horizontal[1] = new Sprite(16, 1, 8, SpriteLoader.origin);
        flame_horizontal[2] = new Sprite(16, 1, 9, SpriteLoader.origin);

        flame_horizontal_left[0] = new Sprite(16, 0, 7, SpriteLoader.origin);
        flame_horizontal_left[1] = new Sprite(16, 0, 8, SpriteLoader.origin);
        flame_horizontal_left[2] = new Sprite(16, 0, 9, SpriteLoader.origin);

        flame_horizontal_right[0] = new Sprite(16, 2, 7, SpriteLoader.origin);
        flame_horizontal_right[1] = new Sprite(16, 2, 8, SpriteLoader.origin);
        flame_horizontal_right[2] = new Sprite(16, 2, 9, SpriteLoader.origin);

        flame_vertical_top[0] = new Sprite(16, 1, 4, SpriteLoader.origin);
        flame_vertical_top[1] = new Sprite(16, 2, 4, SpriteLoader.origin);
        flame_vertical_top[2] = new Sprite(16, 3, 4, SpriteLoader.origin);

        flame_vertical_bot[0] = new Sprite(16, 1, 6, SpriteLoader.origin);
        flame_vertical_bot[1] = new Sprite(16, 2, 6, SpriteLoader.origin);
        flame_vertical_bot[2] = new Sprite(16, 3, 6, SpriteLoader.origin);
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
