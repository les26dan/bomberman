package Bomberman.UI;

import Bomberman.Game;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

  private Game game;

  public GamePanel() {
    setLayout(new BorderLayout());
    setPreferredSize(new Dimension(Game.WIDTH * Game.SCALE, Game.HEIGHT * Game.SCALE));
    System.out.println(Game.WIDTH * Game.SCALE+ " " + Game.HEIGHT * Game.SCALE);
    game = new Game();
    add(game);
    game.setVisible(true);
    setVisible(true);
    setFocusable(true);
  }

  public Game getGame() {
    return game;
  }

}
