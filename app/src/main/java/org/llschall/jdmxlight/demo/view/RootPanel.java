package org.llschall.jdmxlight.demo.view;

import org.llschall.jdmxlight.demo.controller.DemoController;
import org.llschall.jdmxlight.demo.model.DemoModel;

import javax.swing.*;
import java.awt.*;

class RootPanel extends JPanel {

    final DemoModel model;

    RootPanel(DemoController controller, DemoModel model) {
        this.model = model;

        JTabbedPane centerPnl = new JTabbedPane();
        centerPnl.addTab("Basic", new BasicPanel(controller, model));
        centerPnl.addTab("Advanced", new AdvancedPanel());

        SouthPanel southPnl = new SouthPanel(controller);

        setLayout(new BorderLayout());
        add(centerPnl, BorderLayout.CENTER);
        add(southPnl, BorderLayout.SOUTH);

        addKeyListener(controller);

        setFocusable(true);
        requestFocus();
    }
}
