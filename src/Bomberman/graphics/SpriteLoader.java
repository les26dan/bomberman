package Bomberman.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class SpriteLoader {
  public int[] pixels;
  public final int SIZE;
  private String path;

  public static SpriteLoader origin = new SpriteLoader("/images/image.png", 256);

  public SpriteLoader(String path, int size) {
    this.path = path;
    SIZE = size;
    pixels = new int[SIZE * SIZE];
    load();
  }

  private void load() {
    try {
      URL a = SpriteLoader.class.getResource(path);
      BufferedImage image = ImageIO.read(a);
      int w = image.getWidth();
      int h = image.getHeight();
      image.getRGB(0, 0, w, h, pixels, 0, w);
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(0);
    }
  }
}
