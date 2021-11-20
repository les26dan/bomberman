package Bomberman;

import Bomberman.Keyboard.Keyboard;
import Bomberman.graphics.Screen;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Game extends Canvas {

  private GameContainer gameContainer;
  private Screen screen;
  private Keyboard input;
  private boolean running = false;

  private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
  private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();

  public static final int WIDTH = 240, HEIGHT = 208;
  public static int SCALE = 3;


  public Game() {
    screen = new Screen(WIDTH, HEIGHT);
    input = new Keyboard();
    gameContainer = new GameContainer(this, input, screen);
    addKeyListener(input);
  }


  private void renderGame() {
    BufferStrategy bs = getBufferStrategy();
    if(bs == null) {
      createBufferStrategy(3);
      return;
    }
//    screen.clear();
    gameContainer.render(screen);
    for (int i = 0; i < pixels.length; i++) {
      pixels[i] = screen.pixels[i];
    }
    Graphics g = bs.getDrawGraphics();
    g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    g.dispose();
    bs.show();
  }

  public void start() {
      running = true;
      while(running) {
        renderGame();
      }
  }

}
