package Bomberman.UI;

import Bomberman.Game;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BoardPanel extends JPanel {

    private JLabel timeLabel;
    private JLabel pointsLabel;
    private JLabel livesLabel;

    public BoardPanel(Game game) {
        setLayout(new GridLayout());
        timeLabel = new OutlineLabel("Time: ",3);
        timeLabel.setForeground(Color.white);
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setFont(new Font("Lucida Console", Font.BOLD, 50));

        pointsLabel = new OutlineLabel("Points: ",3);
        pointsLabel.setForeground(Color.white);
        pointsLabel.setHorizontalAlignment(JLabel.CENTER);
        pointsLabel.setFont(new Font("Lucida Console", Font.BOLD, 50));

        livesLabel = new OutlineLabel("Lives: ",3);
        livesLabel.setForeground(Color.white);
        livesLabel.setHorizontalAlignment(JLabel.CENTER);
        livesLabel.setFont(new Font("Lucida Console", Font.BOLD, 50));


        add(timeLabel);
        add(pointsLabel);
        add(livesLabel);


        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(0, 100));
    }
}

class OutlineLabel extends JLabel {

    private static final long serialVersionUID = 1L;

    private Color outlineColor = Color.black;

    private boolean isPaintingOutline = false;
    private boolean forceTransparent = false;

    private final int thickness;

    public OutlineLabel(String text, int thickness) {
        super(text);
        this.thickness = thickness;
        setBorder(thickness);
    }

    private void setBorder(int thickness) {
        Border border = getBorder();
        Border margin = new EmptyBorder(thickness, thickness + 3,
                thickness, thickness + 3);
        setBorder(new CompoundBorder(border, margin));
    }

    @Override
    public Color getForeground() {
        if (isPaintingOutline) {
            return outlineColor;
        } else {
            return super.getForeground();
        }
    }

    @Override
    public boolean isOpaque() {
        if (forceTransparent) {
            return false;
        } else {
            return super.isOpaque();
        }
    }

    @Override
    public void paint(Graphics g) {
        String text = getText();
        if (text == null || text.length() == 0) {
            super.paint(g);
            return;
        }

        // 1 2 3
        // 8 9 4
        // 7 6 5

        if (isOpaque()) {
            super.paint(g);
        }

        forceTransparent = true;
        isPaintingOutline = true;
        g.translate(-thickness, -thickness);
        super.paint(g); // 1
        g.translate(thickness, 0);
        super.paint(g); // 2
        g.translate(thickness, 0);
        super.paint(g); // 3
        g.translate(0, thickness);
        super.paint(g); // 4
        g.translate(0, thickness);
        super.paint(g); // 5
        g.translate(-thickness, 0);
        super.paint(g); // 6
        g.translate(-thickness, 0);
        super.paint(g); // 7
        g.translate(0, -thickness);
        super.paint(g); // 8
        g.translate(thickness, 0); // 9
        isPaintingOutline = false;

        super.paint(g);
        forceTransparent = false;
    }
}