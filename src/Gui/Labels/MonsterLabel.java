package Gui.Labels;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.image.BufferedImage;

public class MonsterLabel extends JLabel implements ActionListener {
    private BufferedImage imageBuffer;
    public Timer timer;

    public MonsterLabel() {
        try {
            this.imageBuffer = ImageIO.read(new File("C:\\Users\\PICHAU\\Documents\\Projects\\JustShot\\JustShot\\src\\Elements\\MonsterLabel2.png"));
        } catch (Exception e) {
            System.out.println("image not found");
        }
        ImageIcon imageicon = new ImageIcon(imageBuffer);
        this.setIcon(imageicon);


        timer = new Timer(10, this);
        timer.start();
    }

    public RocketLabel rocket;
    public int vx = 1, vy = 2;
    @Override
    public void actionPerformed(ActionEvent e) {
        int x = this.getX();
        int y = this.getY();
        if (x < this.rocket.getX() + 20) x += vx;
        if (y > this.rocket.getY()) y -= vy;
        if (x > this.rocket.getX() + 20) x -= vx;
        if (y < this.rocket.getY()) y += vy;
        this.setLocation(x, y);
    }

    public void stop(){
        timer.stop();
    }

}
