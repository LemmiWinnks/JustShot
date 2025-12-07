package Gui.Labels;

import Gui.Container;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class MonsterLabel extends JLabel implements ActionListener {
   BufferedImage imageBuffer;
   ImageIcon imageicon;
    public int x = 0, y = 0;
    double distance = 0;
    Timer timer;


    public MonsterLabel() {
        try {
            this.imageBuffer = ImageIO.read(new File("C:\\Users\\PICHAU\\Documents\\Projects\\JustShot\\JustShot\\src\\Elements\\MonsterLabel2.png"));
        } catch(Exception e) {
            System.out.println("image not found");
        }
        imageicon = new ImageIcon(imageBuffer);
        this.setIcon(imageicon);
        this.setBounds(170, -247, 400, 600);

        timer = new Timer(30, this);
        timer.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.x = this.getX();
        this.y = this.getY();

        if (this.x < RocketLabel.coordinateX() + 20) this.x += 2;
        if (this.y < RocketLabel.coordinateY() + 20) this.y += 2;
        if (this.x > RocketLabel.coordinateX() + 20) this.x -= 2;
        if (this.y > RocketLabel.coordinateY() + 20) this.y -= 2;

        this.setLocation(this.x, this.y);
    }

}
