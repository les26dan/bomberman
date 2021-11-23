package Bomberman.graphics;

public class Sprite {

  private SpriteLoader sheet;
  public final int SIZE;
  private int x, y;
  public int[] pixels;

  public static Sprite player_up = new Sprite(16, 0, 0, SpriteLoader.origin);
  public static Sprite player_down = new Sprite(16, 2, 0, SpriteLoader.origin);
  public static Sprite player_left = new Sprite(16, 3, 0, SpriteLoader.origin);
  public static Sprite player_right = new Sprite(16, 1, 0, SpriteLoader.origin);

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
