package Gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class Window {
    private JFrame frame;

    public Window() {
        inicialize();
    }

    // basic config JFrame
    public void inicialize() {
        frame = new JFrame();
        this.frame.setSize(400, 600);
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);
    }

    // Options
    public void addContent(JPanel content) {
        this.frame.add(content);
    }

    public void showElements() {
        this.frame.setVisible(true);
    }

}
