package com.sumsec.core.cfg.core;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @ClassName: Image
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/8 17:06
 * @Version: v1.0.0
 * @Description:
 **/
public class Image extends JFrame {
    public static BufferedImage image = null;
    public Image(int width, int height) {
        setSize(width,height);
        setVisible(true);
//        setIconImage();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(image,50,50,this);
    }
}
