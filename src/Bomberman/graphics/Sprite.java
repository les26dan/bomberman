package Bomberman.graphics;

public class Sprite {

  private SpriteLoader sheet;
  public final int SIZE;
  private int x, y;
  public int[] pixels;
  protected int readWidth;
  protected int realHeight;

  public static Sprite player_up = new Sprite(16, 0, 0, SpriteLoader.origin, 12, 16);
  public static Sprite player_down = new Sprite(16, 2, 0, SpriteLoader.origin, 12, 15);
  public static Sprite player_left = new Sprite(16, 3, 0, SpriteLoader.origin, 10, 15);
  public static Sprite player_right = new Sprite(16, 1, 0, SpriteLoader.origin, 10, 16);

  public Sprite(int size, int x, int y, SpriteLoader sheet, int realWidth, int realHeight) {
    this.SIZE = size;
    this.x = x * SIZE;
    this.y = y * SIZE;
    this.readWidth = realWidth;
    this.realHeight = realHeight;
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
