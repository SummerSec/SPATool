package com.sumsec.core.cfg.uitls;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * @ClassName: ImageBak
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/13 14:59
 * @Version: v1.0.0
 * @Description:
 **/
public class ImageBak extends JFrame {
    public static BufferedImage image = null;
    public ImageBak(int width, int height) {
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
