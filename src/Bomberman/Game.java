package Bomberman;

import Bomberman.Keyboard.Keyboard;
import Bomberman.Sound.Sound;
import Bomberman.UI.Frame;
import Bomberman.graphics.Screen;
import Bomberman.graphics.Sprite;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.concurrent.TimeUnit;

public class Game extends Canvas {

    private GameContainer gameContainer;
    private Screen screen;
    private Keyboard input;
    private Frame frame;
    private boolean running = false;

    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    public static final int BOX_SIZE = 16;
    public static final int WIDTH = BOX_SIZE * 21, HEIGHT = BOX_SIZE * 13;
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

    private void renderScreen() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

//        screen.clear();

        Graphics g = bs.getDrawGraphics();

        getGameContainer().drawScreen(g);

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
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        double cnt = 0;
        int dem = 0;
        int pauseTime = 0;
        requestFocus();
        while (running) {
            long cur = System.nanoTime();
            cnt += (cur - lastTime) / (1000000000.0 / rate);
            lastTime = cur;
            while (cnt >= 1) {
                if (pauseTime == 0)
                    update();
                cnt--;
            }
            Sound.stageTheme.start();
            Sound.stageTheme.loop(Sound.stageTheme.LOOP_CONTINUOUSLY);
            pauseTime = gameContainer.getPauseTime();
            if (pauseTime > 0) {
                renderScreen();
                if (pauseTime >= 1000) dem++;
            } else
                renderGame();
            if (System.currentTimeMillis() - timer > 1000) {
                if (pauseTime == 0) frame.setTime(gameContainer.getTime());
                frame.setPoints(gameContainer.getPoints());
                timer += 1000;
                gameContainer.setPauseTime(Math.max(0, pauseTime - 1));
            }
            if (dem == 2) {
                try {
                TimeUnit.SECONDS.sleep(1);
                    while(true) {
                        input.update();
                        if (input.anyKey) {
                            gameContainer.newGame();
                            timer = System.currentTimeMillis();
                            dem = 0;
                            break;
                        }
                    }
                } catch (Exception e) {
                }
            }
        }

    }

    public GameContainer getGameContainer() {
        return gameContainer;
    }
}
