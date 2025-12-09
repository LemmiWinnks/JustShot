package Gui;

import Gui.Labels.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Container extends JPanel implements ActionListener {
    RocketLabel rocketLabel = new RocketLabel();
    MonsterLabel monsterLabel;
    Shot shot = new Shot();
    Timer timer;
    int x = 0;

    public Container() {
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        this.add(rocketLabel);
        this.add(shot);

        timer = new Timer(1000, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        monsterLabel = new MonsterLabel();
        this.add(monsterLabel);
    }
}
