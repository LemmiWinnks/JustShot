package Gui.Labels;

import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.image.BufferedImage;

public class MonsterLabel extends JLabel implements ActionListener {
    private static MonsterLabel instance;
    BufferedImage imageBuffer;
    ImageIcon imageicon;
    public int x = 0, y = 0;
    double distance = 0;
    Timer timer;


    public MonsterLabel() {
//        instance = this;
        try {
            this.imageBuffer = ImageIO.read(new File("C:\\Users\\PICHAU\\Documents\\Projects\\JustShot\\JustShot\\src\\Elements\\MonsterLabel2.png"));
        } catch (Exception e) {
            System.out.println("image not found");
        }
        imageicon = new ImageIcon(imageBuffer);
        this.setIcon(imageicon);
        this.setBounds(155, 73, 40, 33);

        timer = new Timer(16, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.x = this.getX();
        this.y = this.getY();

        if (this.x < RocketLabel.x + 20) this.x += 3;
        if (this.y > RocketLabel.y) this.y -= 3;
        if (this.x > RocketLabel.x + 20) this.x -= 3;
        if (this.y < RocketLabel.y) this.y += 3;

        this.setLocation(this.x, this.y);

        if (this.getBounds().intersects(RocketLabel.getInstance().getBounds())) {
            System.out.println("Game Over");
            timer.stop();
            this.setIcon(null);
        }
        if (this.getBounds().intersects(Shot.getInstance().getBounds())) {
            timer.stop();
            this.setIcon(null);
        }
    }

    public static MonsterLabel getInstance() {
        if (instance == null) {
            instance = new MonsterLabel();
        }
        return instance;
    }

}
