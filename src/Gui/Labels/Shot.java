package Gui.Labels;

import javax.swing.*;
import java.awt.*;

public class Shot extends JLabel {
    public Shot () {
        this.setBounds(0, 0, 100, 100);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, 10, 30);
    }
}
