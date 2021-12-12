package Bomberman.UI;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BoardPanel extends JPanel {

    private JLabel timeLabel;
    private JLabel pointsLabel;
    private JLabel livesLabel;
    private BufferedImage image;

    public BoardPanel() {
//        try{
//        image = ImageIO.read(this.getClass().getResource("/images/image.png"));}
//        Image scaledImage = image.getScaledInstance(jPanel.getWidth(),jPanel.getHeight(),Image.SCALE_SMOOTH);
//        catch (IOException e) {
//        }

//        timeLabel = new JLabel("Time: " + 10);
//        timeLabel.setForeground(Color.white);
//        timeLabel.setHorizontalAlignment(JLabel.CENTER);
//
//        pointsLabel = new JLabel("Points: " + 20);
//        pointsLabel.setForeground(Color.white);
//        pointsLabel.setHorizontalAlignment(JLabel.CENTER);
//
//        livesLabel = new JLabel("Lives: " + 30);
//        livesLabel.setForeground(Color.white);
//        livesLabel.setHorizontalAlignment(JLabel.CENTER);
//
//        add(timeLabel);
//        add(pointsLabel);
//        add(livesLabel);
//
//
        setBackground(Color.black);
        setPreferredSize(new Dimension(1600, 100));
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}
