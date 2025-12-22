package Gui.Window;

import Gui.Panels.ContainerPanel;

import javax.swing.JFrame;

public class WindowFrame extends JFrame {
    public WindowFrame() {
        ContainerPanel containerPanel = new ContainerPanel();

        this.setSize(400, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

        //add panels
        containerPanel.requestFocusInWindow();
        this.add(containerPanel);
    }
}
