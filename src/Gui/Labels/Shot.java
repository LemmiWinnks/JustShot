
//not ready yet

package Gui.Labels;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.awt.image.BufferedImage;

public class Shot extends JLabel{
    BufferedImage imageBuffer;
    ImageIcon imageicon;
    int x, y; // need be in the same location of rocket
    public boolean shot;

    public Shot() {
        try {
            this.imageBuffer = ImageIO.read(new File("C:\\Users\\PICHAU\\Documents\\Projects\\JustShot\\JustShot\\src\\Elements\\projetil.png"));
        } catch (Exception e) {
            System.out.println("image not found");
        }
        imageicon = new ImageIcon(imageBuffer);
        this.setIcon(imageicon);

        this.setBounds(x, y, 20, 40);
    }
}
