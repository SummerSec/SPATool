package com.sumsec.core.cfg.uitls;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @ClassName: Image
 * @Description: TODO
 * @Author: Summer
 * @Date: 2022/2/8 17:06
 * @Version: v1.0.0
 * @Description:
 **/
public class Images extends JFrame {

    public static ImageViewer imageView = null;
    public Images(File file) throws IOException {
        setSize(900,900);
        imageView = new ImageViewer(file.getAbsolutePath());
        add(imageView);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("ImageViewer Test");

        ImageViewer viewer = new ImageViewer("G:\\GitHubProject\\SPATool\\datas\\result\\ast\\8076713468000\\8150093082300.png");
        frame.add(viewer);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(900, 900);
        frame.setVisible(true);


    }


}
