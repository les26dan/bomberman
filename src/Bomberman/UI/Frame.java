package Bomberman.UI;

import Bomberman.Game;
import Bomberman.graphics.Sprite;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

  public GamePanel gamePanel;
  private JPanel headPanel;
  private Game game;

  public Frame() {
    Sprite.init();
    headPanel = new JPanel(new BorderLayout());
    gamePanel = new GamePanel();
    headPanel.add(gamePanel, BorderLayout.PAGE_END);
    add(headPanel);
    game = gamePanel.getGame();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Bomberman");
    setResizable(false);
    pack();
    setVisible(true);
    setLocationRelativeTo(null);
    game.start();
  }

}
