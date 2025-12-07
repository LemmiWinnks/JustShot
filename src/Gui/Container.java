package Gui;

import Gui.Labels.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
//import javax.swing.border.Border;

public class Container extends JPanel implements ActionListener{
    RocketLabel rocketLabel = new RocketLabel();
    MonsterLabel monsterLabel;
    Timer timer;
    int x = 0;
    public Container() {
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        this.add(rocketLabel);

        timer = new Timer(1000, this);
        timer.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        monsterLabel = new MonsterLabel();
        this.add(monsterLabel);
    }
}
