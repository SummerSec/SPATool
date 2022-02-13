package com.sumsec.core.cfg.uitls;

import java.awt.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.event.*;

public class ImageViewer extends JComponent {
    final JSlider slider;
    final ImageComponent image;
    final JScrollPane scrollPane;

    public ImageViewer(String path) throws IOException {
        slider = new JSlider(0, 1000, 500);
        image = new ImageComponent(path);
        scrollPane = new JScrollPane(image);

        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                image.setZoom(2. * slider.getValue() / slider.getMaximum());
            }
        });

        this.setLayout(new BorderLayout());
        this.add(slider, BorderLayout.NORTH);
        this.add(scrollPane);
    }
}