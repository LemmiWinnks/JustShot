package Gui.Panels;

import Gui.Labels.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ComponentsPanel extends JPanel implements KeyListener, ActionListener {

    private final ArrayList<MonsterLabel> monsters = new ArrayList<>();
    private final ArrayList<Shot> shots = new ArrayList<>();

    // labels objects
    private final RocketLabel rocketLabel;

    public ComponentsPanel() {
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        addKeyListener(this);
        setFocusable(true);

        // add labels
        this.rocketLabel = new RocketLabel();
        this.add(rocketLabel);

        Timer rocketTimer = new Timer(2, this);
        rocketTimer.setActionCommand("ROCKET");

        Timer monsterTimer = new Timer(800, this);
        monsterTimer.setActionCommand("MONSTER");

        Timer shootCommandTimer = new Timer(60, this);
        shootCommandTimer.setActionCommand("SHOOT");

        Timer checkColisionTimer = new Timer(1, this);
        checkColisionTimer.setActionCommand("CHECKCOLISION");

        rocketTimer.start();
        monsterTimer.start();
        shootCommandTimer.start();
        checkColisionTimer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "ROCKET" -> moveRocket();
            case "MONSTER" -> spawnMonster();
            case "SHOOT" -> shootCommand();
            case "CHECKCOLISION" -> checkColision();
        }
    }

    // keys for controls(rocket at the moment)
    private boolean
            up,
            down,
            left,
            right,
            j;

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
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
            case KeyEvent.VK_J:
                j = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
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
            case KeyEvent.VK_J:
                j = false;
                break;
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
        this.monsters.add(monsterLabel);
        this.add(monsterLabel);
    }

    public void shootCommand() {
        if (j) {
            Shot shot = new Shot();
            shot.setBounds(rocketLabel.getX() + 20, rocketLabel.getY(), 20, 40);
            this.shots.add(shot);
            this.add(shot);
        }
    }

    public void checkColision() {
        for (MonsterLabel monster:this.monsters) {
            for(Shot shot:shots) {
                if(shot.getBounds().intersects(monster.getBounds())){
                    monster.timer.stop();
                    this.remove(monster);
                    this.monsters.remove(monster);

                    shot.timer.stop();
                    this.remove(shot);
                    this.shots.remove(shot);

                    repaint();
                    revalidate();
                    return;
                }
                if (shot.getY() > this.getHeight()) {
                    shot.timer.stop();
                    this.remove(shot);
                    this.shots.remove(shot);
                    System.out.println("teste");
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
