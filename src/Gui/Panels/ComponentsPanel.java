package Gui.Panels;

import Gui.Labels.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class ComponentsPanel extends JPanel implements KeyListener, ActionListener {

    private final JLabel gameOver;
    private final Timer rocketTimer;
    private final Timer monsterTimer;
    private final Timer shootCommandTimer;
    private final Timer checkColisionTimer;

    private final RocketLabel rocketLabel;
    private final Runnable restartGame;
    private final JLabel counterPoints;
    private int points = 0;
    public ComponentsPanel(Runnable restartGame) {
        this.restartGame = restartGame;
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        addKeyListener(this);
        setFocusable(true);

        // add labels
        this.rocketLabel = new RocketLabel();
        this.add(rocketLabel);

        gameOver = new JLabel();
        gameOver.setFont(new Font("Arial", Font.BOLD, 40));
        gameOver.setBounds(66, 0, 450, 450);
        gameOver.setForeground(Color.WHITE);
        gameOver.setText("GAME OVER");
        this.add(gameOver);
        gameOver.setVisible(false);

        counterPoints = new JLabel();
        counterPoints.setFont(new Font("Arial", Font.BOLD, 15));
        counterPoints.setBounds(270, 10, 100, 40);
        counterPoints.setText(String.format("POINTS: %d", points));
        counterPoints.setForeground(Color.WHITE);
        this.add(counterPoints);

        rocketTimer = new Timer(2, this);
        rocketTimer.setActionCommand("ROCKET");

        monsterTimer = new Timer(300, this);
        monsterTimer.setActionCommand("MONSTER");

        shootCommandTimer = new Timer(100, this);
        shootCommandTimer.setActionCommand("SHOOT");

        checkColisionTimer = new Timer(1, this);
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
            case "CHECKCOLISION" -> checkCollision();
        }
    }

    // keys for controls(rocket at the moment)
    private boolean up, down, left, right, j, z;

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
        if (e.getKeyCode() == KeyEvent.VK_Z) {
            restartGame.run();
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
        if (up) rocketLabel.setLocation(rocketLabel.getX(), rocketLabel.getY() - 2);
        if (down) rocketLabel.setLocation(rocketLabel.getX(), rocketLabel.getY() + 2);
        if (left) rocketLabel.setLocation(rocketLabel.getX() - 2, rocketLabel.getY());
        if (right) rocketLabel.setLocation(rocketLabel.getX() + 2, rocketLabel.getY());
    }

    public void spawnMonster() {
        Random random = new Random();
        int x = random.nextInt(-200, 500);
        int y = random.nextInt(10, 90);

        MonsterLabel monsterLabel = new MonsterLabel();
        monsterLabel.rocket = rocketLabel;
        monsterLabel.setBounds(x, -y, 40, 33);

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

    private final ArrayList<MonsterLabel> monsters = new ArrayList<>();
    private final ArrayList<Shot> shots = new ArrayList<>();
    // shots that dont collision no one object
    private final ArrayList<Shot> shotsPending = new ArrayList<>();

    public void checkCollision() {
        // verify collision
        for (MonsterLabel monster : this.monsters) {
            for (Shot shot : shots) {
                if (shot.getBounds().intersects(monster.getBounds())) {
                    monster.stop();
                    this.remove(monster);
                    this.monsters.remove(monster);

                    shot.stop();
                    this.remove(shot);
                    this.shots.remove(shot);

                    for (Shot shotsPending : shotsPending) {
                        this.shots.remove(shotsPending);
                    }

                    points += 1;
                    counterPoints.setText(String.format("POINTS: %d", points));
                    this.add(counterPoints);

                    repaint();
                    revalidate();
                    return;
                }
                if (shot.getY() < -this.getHeight()) {
                    this.remove(shot);
                    shot.stop();
                    shotsPending.add(shot);
                }
            }

            // game over
            if (monster.getBounds().intersects(rocketLabel.getBounds())) {
                gameOver.setVisible(true);

                rocketTimer.stop();
                monsterTimer.stop();
                for (MonsterLabel stopMonster : monsters) {
                    stopMonster.stop();
                }
                shootCommandTimer.stop();

                return;
            }
        }
    }

    public void dispose() {
        rocketTimer.stop();
        monsterTimer.stop();
        shootCommandTimer.stop();
        checkColisionTimer.stop();

        removeKeyListener(this);

        for (MonsterLabel monster : monsters) {
            monster.stop();
        }
        for (Shot shot : shots) {
            shot.stop();
        }

        monsters.clear();
        shots.clear();
        shotsPending.clear();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}