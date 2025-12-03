package Gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
//import javax.swing.border.Border;


// mudar nome da classe rocket -> container
public class Container extends JPanel implements ActionListener, KeyListener {
    //JPanel panel;
    BufferedImage imageBuffer;
    JLabel label;
    Timer timer;
    int x = 0, y = 0;
    boolean up, down, left, right;


    // criar uma classe para as labels
    public Container() {
        //this.new JPanel();
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        try{
            this.imageBuffer = ImageIO.read(new File("C:\\Users\\PICHAU\\Documents\\Projects\\JustShot\\JustShot\\src\\Elements\\rocketBlackWhiteResize2.png"));
            this.label = new JLabel(new ImageIcon(imageBuffer));
        } catch(Exception e) {
            System.out.println("Image not found");
        }
        this.label.setBounds(x, y, 400, 600);
        this.setLayout(null);
        this.add(label);

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        timer = new Timer(2, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x = this.label.getX();
        y = this.label.getY();

        if (up) y -= 1;
        if (down) y += 1;
        if (left) x -= 1;
        if (right) x += 1;

        this.label.setLocation(x, y);
    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch(code) {
            case KeyEvent.VK_UP: up = true;break;
            case KeyEvent.VK_DOWN: down = true;break;
            case KeyEvent.VK_LEFT: left = true;break;
            case KeyEvent.VK_RIGHT: right = true;break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch(code) {
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
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
