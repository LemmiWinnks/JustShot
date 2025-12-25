
//not ready yet

package Gui.Labels;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.image.BufferedImage;

public class Shot extends JLabel implements ActionListener {
    BufferedImage imageBuffer;
    ImageIcon imageicon;
    public Timer timer;
    public Shot() {
        try {
            this.imageBuffer = ImageIO.read(new File("C:\\Users\\PICHAU\\Documents\\Projects\\JustShot\\JustShot\\src\\Elements\\projetil.png"));
        } catch (Exception e) {
            System.out.println("image not found");
        }
        imageicon = new ImageIcon(imageBuffer);
        this.setIcon(imageicon);

        timer = new Timer(2, this);
        timer.start();
    }

    public Rectangle rectangle = new Rectangle();
    @Override
    public void actionPerformed(ActionEvent e) {
        this.setLocation(this.getX(), this.getY() - 5);
    }

    public void stop(){
        timer.stop();
    }
}
