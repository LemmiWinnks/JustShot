package Gui.Panels;

import Gui.Labels.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Container extends JPanel implements KeyListener, ActionListener {
    private RocketLabel rocketLabel;
    private MonsterLabel monsterLabel;
    private Shot shot;
    boolean up, down, left, right;
    Timer rocketTimer;
    Timer monsterTimer;

    public Container() {
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.setLayout(null);

        this.rocketLabel =  new RocketLabel();
        this.add(rocketLabel);

        addKeyListener(this);
        setFocusable(true);

        rocketTimer = new Timer(1, this);
        rocketTimer.setActionCommand("ROCKET");

        monsterTimer = new Timer(800, this);
        monsterTimer.setActionCommand("MONSTER");

        rocketTimer.start();
        monsterTimer.start();
    }

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
            case "ROCKET" -> movingRocket();
            case "MONSTER" -> addMonster();
        }
    }

    public void movingRocket() {
        if (up) rocketLabel.setLocation(rocketLabel.getX(), rocketLabel.getY() - 1);
        if (down) rocketLabel.setLocation(rocketLabel.getX(), rocketLabel.getY() + 1);
        if (left) rocketLabel.setLocation(rocketLabel.getX() - 1, rocketLabel.getY());
        if (right) rocketLabel.setLocation(rocketLabel.getX() + 1, rocketLabel.getY());
    }

    public void addMonster() {
        monsterLabel = new MonsterLabel();
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
    public void keyTyped(KeyEvent e) {

    }
}
