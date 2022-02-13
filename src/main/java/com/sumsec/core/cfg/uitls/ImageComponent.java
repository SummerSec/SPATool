package com.sumsec.core.cfg.uitls;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

public class ImageComponent extends JComponent {

    final BufferedImage img;

    public ImageComponent(String path) throws IOException {
        img = ImageIO.read(new File(path));
        setZoom(1);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension dim = getPreferredSize();
        g.drawImage(img, 0, 0, dim.width, dim.height, this);
    }

    public void setZoom(double zoom) {
        int w = (int) (zoom * img.getWidth());
        int h = (int) (zoom * img.getHeight());
        setPreferredSize(new Dimension(w, h));
        revalidate();
        repaint();
    }
}