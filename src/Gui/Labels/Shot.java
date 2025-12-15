package Gui.Labels;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Shot extends JLabel implements ActionListener{
    private static Shot instance;
    BufferedImage imageBuffer;
    ImageIcon imageicon;
    int x;
    int y;
    Timer timer;
    public boolean shot;

    public Shot() {
        instance = this;
        x = RocketLabel.getInstance().getX()+35;
        y = RocketLabel.getInstance().getY();

        try {
            this.imageBuffer = ImageIO.read(new File("C:\\Users\\PICHAU\\Documents\\Projects\\JustShot\\JustShot\\src\\Elements\\projetil.png"));
        } catch (Exception e) {
            System.out.println("image not found");
        }
        imageicon = new ImageIcon(imageBuffer);
        this.setIcon(imageicon);

        this.setBounds(x, y, 20, 40);
//        this.setVisible(false);
        timer = new Timer(1, this);
        timer.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x = RocketLabel.getInstance().getX()+35;
        y-=1;
        this.setLocation(x,y);
        if(y == -10){
            System.out.println(y);
            System.out.println("stop");
            timer.stop();
            this.setIcon(null);
        }
    }

    public static Shot getInstance() {
        return instance;
    }

}
