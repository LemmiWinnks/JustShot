package Gui.Labels;

//import java.awt.*;
//import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class RocketLabel extends JLabel implements ActionListener, KeyListener {
    private static RocketLabel instance;
    BufferedImage imageBuffer;
    static int x = 0, y = 0;
    boolean up, down, left, right, tab, space;
    public boolean z;
    Timer timer;

    public RocketLabel() {
        instance = this;
        try {
            this.imageBuffer = ImageIO.read(new File("C:\\Users\\PICHAU\\Documents\\Projects\\JustShot\\JustShot\\src\\Elements\\rocketBlackWhiteResize2.png"));
            this.setIcon(new ImageIcon(imageBuffer));
        } catch (Exception e) {
            System.out.println("Image not found");
        }

        this.setBounds(143, 458, 80, 86);

        timer = new Timer(2, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        setFocusable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x = this.getX();
        y = this.getY();

        if (up) y -= 1;
        if (down) y += 1;
        if (left) x -= 1;
        if (right) x += 1;
        if (tab) System.out.println("X: " + x + " " + "Y:" + y);


        this.setLocation(x, y);

    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
            case KeyEvent.VK_TAB:
                tab = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch (code) {
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                break;
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
            case KeyEvent.VK_TAB:
                tab = false;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public static RocketLabel getInstance() {
        return instance;
    }

}
