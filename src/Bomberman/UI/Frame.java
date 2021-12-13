package Bomberman.UI;
import Bomberman.Game;
import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

  public Frame() {
    JPanel headPanel = new JPanel(new BorderLayout());
    GamePanel gamePanel = new GamePanel();
    Game game = gamePanel.getGame();
    BoardPanel boardPanel = new BoardPanel(game);
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

}
