package Gui;

import javax.swing.JFrame;

public class Window extends JFrame {
    public Window() {
        Container container = new Container();

        this.setSize(400, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.add(container);
    }
}
