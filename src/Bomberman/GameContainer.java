package Bomberman;

import Bomberman.Entities.Dynamic.Bomber;
import Bomberman.Entities.Entity;
import Bomberman.Keyboard.Keyboard;
import Bomberman.graphics.Screen;

public class GameContainer {

  protected Game game;
  protected Keyboard input;
  protected Screen screen;
  public Bomber player = new Bomber(16,32,this);

  public GameContainer(Game game, Keyboard input, Screen screen) {
    this.game = game;
    this.input = input;
    this.screen = screen;
  }

  public void render(Screen screen) {
    renderMobs(screen);
  }
  protected void renderMobs(Screen screen) {
    player.render(screen);
  }

}
