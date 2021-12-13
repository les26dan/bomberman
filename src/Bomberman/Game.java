package Bomberman;

import Bomberman.Keyboard.Keyboard;
import Bomberman.Sound.Sound;
import Bomberman.UI.BoardPanel;
import Bomberman.UI.Frame;
import Bomberman.graphics.Screen;
import Bomberman.graphics.Sprite;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Game extends Canvas {

    private GameContainer gameContainer;
    private Screen screen;
    private Keyboard input;
    private Frame frame;
    private boolean running = false;

    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    public static final int BOX_SIZE = 16;
    public static final int WIDTH = BOX_SIZE * 31, HEIGHT = BOX_SIZE * 13;
    public static int SCALE = 3;


    public Game(Frame frame) {
        this.frame = frame;
        screen = new Screen(WIDTH, HEIGHT);
        input = new Keyboard();
        gameContainer = new GameContainer(this, input, screen);
        addKeyListener(input);
        Sprite.init();
    }


    private void renderGame() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
//        screen.clear();
        gameContainer.render(screen);
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = screen.pixels[i];
        }
        Graphics g = bs.getDrawGraphics();
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        gameContainer.renderDialog(g);
        g.dispose();
        bs.show();
    }

    void update() {
        input.update();
        gameContainer.update();
    }

    public void start() {
        running = true;
        final double rate = 64.0;
        long  lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        double cnt = 0;
        requestFocus();
        while (running) {
            long cur = System.nanoTime();
            cnt += (cur - lastTime) / (1000000000.0 / rate);
            lastTime = cur;
            while(cnt >= 1) {
                update();
                cnt--;
            }
            Sound.stageTheme.start();
            Sound.stageTheme.loop(Sound.stageTheme.LOOP_CONTINUOUSLY);
            renderGame();
            if(System.currentTimeMillis() - timer > 1000) { //once per second
                frame.setTime(gameContainer.getTime());
                frame.setPoints(gameContainer.getPoints());
//                boardPanel.setLives(gameContainer.getLives());
                timer += 1000;
            }
        }
    }

    public GameContainer getGameContainer() {
        return gameContainer;
    }
}
