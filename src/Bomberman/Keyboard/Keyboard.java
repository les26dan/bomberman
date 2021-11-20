package Bomberman.Keyboard;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
    public boolean up;
    public boolean down;
    public boolean left;
    public boolean right;
    public boolean space;
    private boolean[] status = new boolean[120];

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        status[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        status[e.getKeyCode()] = false;
    }

    public void update() {
        up = status[KeyEvent.VK_UP]  || status[KeyEvent.VK_W];
        down = status[KeyEvent.VK_DOWN]  || status[KeyEvent.VK_S];
        left = status[KeyEvent.VK_LEFT]  || status[KeyEvent.VK_A];
        right = status[KeyEvent.VK_RIGHT]  || status[KeyEvent.VK_D];
        space = status[KeyEvent.VK_SPACE];
    }
}
