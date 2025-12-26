package Gui.Window;

import Gui.Panels.ComponentsPanel;

import javax.swing.JFrame;

public class WindowsFrame extends JFrame {
    ComponentsPanel componentsPanel;

    public WindowsFrame() {
        this.setSize(400, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        startGame();
        this.setVisible(true);
    }

    public void startGame() {
        if (componentsPanel != null) {
            componentsPanel.dispose();
            this.remove(componentsPanel);
        }

        componentsPanel = new ComponentsPanel(this::startGame);
        this.add(componentsPanel);

        revalidate();
        repaint();
        componentsPanel.requestFocusInWindow();
    }
}
