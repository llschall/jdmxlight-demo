package org.llschall.jdmxlight.demo.view;

import javax.swing.*;
import java.awt.*;

class DemoSlider extends JPanel {

    DemoSlider() {

        JSlider slider = new JSlider();
        slider.setOrientation(JSlider.NORTH);
        slider.setMinimum(1);
        slider.setMinimum(512);

        setLayout(new BorderLayout());
        add(slider, BorderLayout.CENTER);
    }
}
