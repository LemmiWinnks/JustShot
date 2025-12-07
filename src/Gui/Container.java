package Gui;

import Gui.Labels.RocketLabel;

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

public class Container extends JPanel{

    RocketLabel rocketLabel = new RocketLabel();

    public Container() {
        this.setLayout(null);
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        this.add(rocketLabel);
    }
}
