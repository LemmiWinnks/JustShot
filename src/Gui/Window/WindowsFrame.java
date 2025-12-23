package Gui.Window;

import Gui.Panels.ComponentsPanel;

import javax.swing.JFrame;

public class WindowsFrame extends JFrame {
    public WindowsFrame() {
        ComponentsPanel componentsPanel = new ComponentsPanel();

        this.setSize(400, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        //add panels
        this.add(componentsPanel);
        componentsPanel.requestFocusInWindow();
    }
}
