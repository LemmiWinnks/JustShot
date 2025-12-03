package Gui;

import javax.swing.JFrame;

public class Window extends JFrame {
    private Container container;

    public Window() {
        this.setSize(400, 600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.addPanels();
    }

    // Options
    public void showElements() {
        this.setVisible(true);
    }

    public void addPanels() {
        container = new Container();
        this.add(container);
    }
}
