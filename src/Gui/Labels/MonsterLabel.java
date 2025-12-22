package Gui.Labels;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.image.BufferedImage;

public class MonsterLabel extends JLabel implements ActionListener {
    private BufferedImage imageBuffer;
    private final Timer timer;

    public MonsterLabel() {
        try {
            this.imageBuffer = ImageIO.read(new File("C:\\Users\\PICHAU\\Documents\\Projects\\JustShot\\JustShot\\src\\Elements\\MonsterLabel2.png"));
        } catch (Exception e) {
            System.out.println("image not found");
        }
        ImageIcon imageicon = new ImageIcon(imageBuffer);
        this.setIcon(imageicon);
        this.setBounds(155, 73, 40, 33);

        timer = new Timer(30, this);
        timer.start();
    }

    public RocketLabel rocket;
    @Override
    public void actionPerformed(ActionEvent e) {
        int x = this.getX();
        int y = this.getY();

        if (x < this.rocket.getX() + 20) x += 3;
        if (y > this.rocket.getY()) y -= 3;
        if (x > this.rocket.getX() + 20) x -= 3;
        if (y < this.rocket.getY()) y += 3;
        this.setLocation(x, y);

        if (this.getBounds().intersects(rocket.getBounds())) {
            System.out.println("Game Over");
            this.setIcon(null);
            timer.stop();
        }
    }
}
