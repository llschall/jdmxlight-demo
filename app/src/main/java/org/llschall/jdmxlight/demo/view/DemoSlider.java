package org.llschall.jdmxlight.demo.view;

import org.llschall.jdmxlight.demo.controller.DemoController;

import javax.swing.*;
import java.awt.*;

class DemoSlider extends JPanel {

    DemoSlider(String name, DemoController controller) {

        JSlider slider = new JSlider(0, 255);
        slider.setOrientation(JSlider.NORTH);
        slider.setValue(0);
        slider.setPaintTicks(true);

        JLabel valueLbl = new JLabel();
        valueLbl.setText("0");

        slider.addMouseWheelListener(e -> {
            int rotation = e.getWheelRotation();
            int value = slider.getValue() - rotation;
            slider.setValue(value);
        });

        slider.addChangeListener(e -> {
            int value = slider.getValue();
            valueLbl.setText("" + value);
            controller.fireValueChanged(name, value);
        });

        setBorder(BorderFactory.createRaisedBevelBorder());

        JPanel southPnl = new JPanel();
        JLabel nameLbl = new JLabel(name);

        nameLbl.setFont(nameLbl.getFont().deriveFont(Font.BOLD, 20));

        southPnl.setLayout(new GridLayout(0, 1));
        southPnl.add(valueLbl);
        southPnl.add(nameLbl);

        setLayout(new BorderLayout());
        add(slider, BorderLayout.CENTER);
        add(southPnl, BorderLayout.SOUTH);

    }
}
