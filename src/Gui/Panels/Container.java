package Gui.Panels;

import Gui.Labels.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Container extends JPanel implements ActionListener {
    private static Container instance;
    RocketLabel rocketLabel = new RocketLabel();
    MonsterLabel monsterLabel;
    MonsterLabel monsterLabel2;
    MonsterLabel monsterLabel3;
    public Shot shot;
    Timer timer;
    int x = 0;

    public Container() {
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        this.add(rocketLabel);

        timer = new Timer(2000, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        monsterLabel = new MonsterLabel();
        this.add(monsterLabel);
        shot = new Shot();
        this.add(shot);
        monsterLabel2 = new MonsterLabel();
        monsterLabel2.setBounds(20, 30, 40, 33);
        this.add(monsterLabel2);
        monsterLabel3 = new MonsterLabel();
        monsterLabel3.setBounds(300, 60, 40, 33);
        this.add(monsterLabel3);
    }

    public static Container getInstance(){
        if(instance == null){
            instance = new Container();
        }
        return instance;
    }
}
