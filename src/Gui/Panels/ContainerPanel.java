package Gui.Panels;

import Gui.Labels.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ContainerPanel extends JPanel implements KeyListener, ActionListener {

    // labels objects
    private final RocketLabel rocketLabel;
    private Shot shot;

    public ContainerPanel() {
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        addKeyListener(this);
        setFocusable(true);

        // add labels
        this.rocketLabel =  new RocketLabel();
        this.add(rocketLabel);

        Timer rocketTimer = new Timer(2, this);
        rocketTimer.setActionCommand("ROCKET");

        Timer monsterTimer = new Timer(800, this);
        monsterTimer.setActionCommand("MONSTER");

        rocketTimer.start();
        monsterTimer.start();
    }

    // keys for controls(rocket at the moment)
    private boolean
            up,
            down,
            left,
            right;

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch(code) {
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command) {
            case "ROCKET" -> moveRocket();
            case "MONSTER" -> spawnMonster();
        }
    }

    public void moveRocket() {
        if (up) rocketLabel.setLocation(rocketLabel.getX(), rocketLabel.getY() - 1);
        if (down) rocketLabel.setLocation(rocketLabel.getX(), rocketLabel.getY() + 1);
        if (left) rocketLabel.setLocation(rocketLabel.getX() - 1, rocketLabel.getY());
        if (right) rocketLabel.setLocation(rocketLabel.getX() + 1, rocketLabel.getY());
    }

    public void spawnMonster() {
        MonsterLabel monsterLabel = new MonsterLabel();
        monsterLabel.rocket = rocketLabel;
        this.add(monsterLabel);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch(code) {
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                break;
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}
}
