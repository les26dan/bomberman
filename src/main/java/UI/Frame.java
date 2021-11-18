package UI;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
    private JPanel headPanal;
    public Frame() {
        headPanal = new JPanel(new BorderLayout());

        add(headPanal);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

}
