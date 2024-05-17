package org.llschall.jdmxlight.demo.view;

import org.llschall.jdmxlight.demo.controller.DemoController;

import javax.swing.*;
import java.awt.*;

import static org.llschall.jdmxlight.demo.controller.DemoController.*;

class CenterPanel extends JPanel {

    CenterPanel(DemoController controller) {

        setLayout(new GridLayout(1, 0));

        add(new DemoSlider(ROTATION, controller));
        add(new DemoSlider(INCLINATION, controller));
        add(new DemoSlider("-", controller));
        add(new DemoSlider(COLOR, controller));
        add(new DemoSlider("-", controller));
    }
}
