package Bomberman.UI;

import Bomberman.Game;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {
  BoardPanel boardPanel;

  public Frame() {
    JPanel headPanel = new JPanel(new BorderLayout());
    GamePanel gamePanel = new GamePanel(this);
    boardPanel = new BoardPanel(gamePanel.getGame());
    Game game = gamePanel.getGame();
    headPanel.add(boardPanel, BorderLayout.PAGE_START);
    headPanel.add(gamePanel, BorderLayout.PAGE_END);
    add(headPanel);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Bomberman");
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
    game.start();
  }

  public void setTime(int time) {
    boardPanel.setTime(time);
  }

  public void setLives(int lives) {
    boardPanel.setLives(lives);
  }

  public void setPoints(int points) {
    boardPanel.setPoints(points);
  }
}