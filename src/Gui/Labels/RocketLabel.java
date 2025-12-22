package Gui.Labels;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class RocketLabel extends JLabel {
    public RocketLabel() {
        try {
            BufferedImage imageBuffer = ImageIO.read(new File("C:\\Users\\PICHAU\\Documents\\Projects\\JustShot\\JustShot\\src\\Elements\\rocketBlackWhiteResize2.png"));
            this.setIcon(new ImageIcon(imageBuffer));
        } catch (Exception e) {
            System.out.println("Image not found");
        }
        this.setBounds(143, 458, 80, 86);
    }
}
