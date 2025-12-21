package Gui.Labels;


import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.image.BufferedImage;

public class MonsterLabel extends JLabel implements ActionListener {
    BufferedImage imageBuffer;
    ImageIcon imageicon;
    public int x, y;
    public RocketLabel rocket;
    Timer timer;

    public MonsterLabel() {
        try {
            this.imageBuffer = ImageIO.read(new File("C:\\Users\\PICHAU\\Documents\\Projects\\JustShot\\JustShot\\src\\Elements\\MonsterLabel2.png"));
        } catch (Exception e) {
            System.out.println("image not found");
        }
        imageicon = new ImageIcon(imageBuffer);
        this.setIcon(imageicon);
        this.setBounds(155, 73, 40, 33);

        timer = new Timer(30, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.x = this.getX();
        this.y = this.getY();

        if (this.x < this.rocket.getX() + 20) this.x += 3;
        if (this.y > this.rocket.getY()) this.y -= 3;
        if (this.x > this.rocket.getX() + 20) this.x -= 3;
        if (this.y < this.rocket.getY()) this.y += 3;

        this.setLocation(this.x, this.y);

        if (this.getBounds().intersects(rocket.getBounds())) {
            System.out.println("Game Over");
            this.setIcon(null);
            timer.stop();
        }
    }
}
