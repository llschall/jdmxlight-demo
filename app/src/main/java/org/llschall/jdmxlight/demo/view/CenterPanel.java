package org.llschall.jdmxlight.demo.view;

import org.llschall.jdmxlight.demo.controller.DemoController;
import org.llschall.jdmxlight.demo.model.DemoModel;

import javax.swing.*;
import java.awt.*;

import static org.llschall.jdmxlight.demo.controller.DemoController.*;

class CenterPanel extends JPanel {

    CenterPanel(DemoController controller, DemoModel model) {

        setLayout(new GridLayout(1, 0));

        add(new DemoSlider(ROTATION, controller, model));
        add(new DemoSlider(INCLINATION, controller, model));
        add(new DemoSlider(GOBOS, controller, model));
        add(new DemoSlider(COLOR, controller, model));
        add(new DemoSlider(NETTETE, controller, model));
    }
}
