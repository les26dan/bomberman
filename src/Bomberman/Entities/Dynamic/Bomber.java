package Bomberman.Entities.Dynamic;

import Bomberman.Entities.Bomb.Bomb;
import Bomberman.Entities.Bomb.Flame;
import Bomberman.Entities.Dynamic.Enemy.Enemy;
import Bomberman.Entities.Entity;
import Bomberman.Game;
import Bomberman.GameContainer;
import Bomberman.Keyboard.Keyboard;
import Bomberman.Sound.Sound;
import Bomberman.Sound.SoundController;
import Bomberman.graphics.Unit;
import Bomberman.graphics.Screen;
import Bomberman.graphics.Sprite;

import java.util.Iterator;
import java.util.List;

public class Bomber extends DynamicEntity {
    protected int numBomb = 1;
    protected int numPlantedBomb = 0;
    protected int flameSize = 1;
    protected Keyboard input;
    protected int delayBombTime;
    public List<Bomb> bombs;

    public Bomber(double x, double y, GameContainer gameContainer) {
        super(x, y);
        this.gameContainer = gameContainer;
        this.delayBombTime = 0;
        this.input = gameContainer.getInput();
        this.bombs = gameContainer.getBombs();
        this.speed = 1;
    }

    @Override
    public void update() {
        frame = (frame + 1) % 1000;
        clearBombs();
        if (delayBombTime < -1000) delayBombTime = -1;
        else delayBombTime--;
        if (dead) {
            if (deadTime > 0)
                deadTime--;
            else {
                Sound sound = new Sound(SoundController.LIFE_LOST);
                sound.play();
                //gameContainer.getSoundController().changeMusic(SoundController.LIFE_LOST);
                remove = true;
                gameContainer.restartLevel();
            }
        } else {
            move();
            plantBoom();
        }
    }

    @Override
    public void render(Screen screen) {
        Screen.addX = Screen.checkCameraPosition(gameContainer, this);
        if (dead) {
            sprite = Sprite.bomber_dead[0];
            if(deadTime <= 20) sprite = Sprite.bomber_dead[1];
            if(deadTime <= 10) sprite = Sprite.bomber_dead[2];
        } else {
            loadSprite();
        }
        screen.renderEntity((int) x, (int) y - sprite.SIZE, this);
    }

    protected void plantBoom() {
        if (input.space && numPlantedBomb < numBomb && delayBombTime < 0) {
            int posX = Unit.pixelToPos(x + sprite.getSize() / 2.0);
            int posY = Unit.pixelToPos(y + sprite.getSize() / 2.0 - sprite.SIZE);
            Entity e = gameContainer.getEntity(posX, posY, this);
            if (!(e instanceof Bomb)) {
                Sound sound = new Sound(SoundController.SET_BOMB);
                sound.play();
                delayBombTime = 15;
                gameContainer.addBomb(new Bomb(Unit.posToPixel(posX), Unit.posToPixel(posY),flameSize, gameContainer));
                numPlantedBomb++;
            }
        }
    }

    @Override
    protected void move() {
        double u = x;
        double v = y;
        if (input.up) {
            direction = 0;
            v -= 1 * speed;

        }
        if (input.down) {
            direction = 2;
            v += 1 * speed;

        }
        if (input.left) {
            direction = 3;
            u -= 1 * speed;

        }
        if (input.right) {
            direction = 1;
            u += 1 * speed;

        }
        moving = u != x || v != y;
        if (canMove(u, v)) {
            x = u;
            y = v;
        }
    }

    @Override
    protected boolean canMove(double x, double y) {
        for (int d = 0; d < 4; d++) {
            int posX = (int) ((x + d % 2 * 11) * 1.0 / Game.BOX_SIZE * 1.0);
            int posY = (int) ((y + d / 2 * 12 - 13) * 1.0 / Game.BOX_SIZE * 1.0);
            Entity e = gameContainer.getEntity(posX, posY, this);
            if (!e.collide(this)) return false;
        }
        return true;
    }

    private void clearBombs() {
        Iterator<Bomb> bombList = bombs.iterator();
        Bomb b;
        while (bombList.hasNext()) {
            b = bombList.next();
            if (b.isRemoved()) {
                numPlantedBomb--;
                for(Flame flame: b.getFlameList()) {
                    if(flame.posX() == b.posX() && flame.posY() == b.posY()) continue;
                    gameContainer.setExistedFlame(flame.posX(),flame.posY() + 1,-1);
                }
                bombList.remove();
            }
        }
    }

    @Override
    public boolean collide(Entity e) {
        if(e instanceof Flame) {
            dead = true;
            return true;
        }
        if(e instanceof Bomb) {
            dead = true;
            return true;
        }

        if(e instanceof Enemy) {
            dead = true;
            return true;
        }
        return true;
    }

    private void loadSprite() {
        int _frame = (frame / 5) % 3;
        switch (direction) {
            case 0:
                sprite = Sprite.bomber_up[0];
                if (moving) {
                    sprite = Sprite.bomber_up[_frame];
                    if(_frame == 0) {
                        SoundController.move2.setFramePosition(0);
                        SoundController.move2.start();
                    }
                }
                break;
            case 1:
                sprite = Sprite.bomber_right[0];
                if (moving) {
                    sprite = Sprite.bomber_right[_frame];
                    if(_frame == 0) {
                        SoundController.move1.setFramePosition(0);
                        SoundController.move1.start();
                    }
                }
                break;
            case 2:
                sprite = Sprite.bomber_down[0];
                if (moving) {
                    sprite = Sprite.bomber_down[_frame];
                    if(_frame == 0) {
                        SoundController.move2.setFramePosition(0);
                        SoundController.move2.start();
                    }
                }
                break;
            case 3:
                sprite = Sprite.bomber_left[0];
                if (moving) {
                    sprite = Sprite.bomber_left[_frame];
                    if(_frame == 0) {
                        SoundController.move1.setFramePosition(0);
                        SoundController.move1.start();
                    }
                }

                break;
            default:
                sprite = Sprite.bomber_right[0];
                if (moving) {
                    sprite = Sprite.bomber_right[_frame];
                }
                break;
        }
    }
    public void addBombItem() {
        numBomb = Math.min(5,numBomb + 1);
    }
    public void addFlameItem() {
        flameSize = Math.min(5,flameSize + 1);
    }
    public void addSpeedItem() {
        speed = Math.min(speed + 0.1 , 2.0);
    }
}
