package org.llschall.jdmxlight.demo.view;

import javax.swing.*;
import java.awt.*;

class CenterPanel extends JPanel {

    CenterPanel() {

        setLayout(new GridLayout(1, 0));

        add(new DemoSlider("Rotation"));
        add(new DemoSlider("Inclinaison"));
        add(new DemoSlider("-"));
        add(new DemoSlider("Gobos"));
        add(new DemoSlider("-"));
    }
}
