package Bomberman.UI;

import Bomberman.Entities.Entity;
import Bomberman.graphics.Screen;

public class Dialog extends Entity {

    protected String dialog;
    protected int time = 100;

    public Dialog(String dialog, double x, double y) {
        super(x,y);
        this.dialog = dialog;
    }
    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public String getDialog() {
        return dialog;
    }

    @Override
    public void update() {
    }

    @Override
    public void render(Screen screen) {
    }

    @Override
    public boolean collide(Entity e) {
        return true;
    }


}
