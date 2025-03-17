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
        centerPnl.addTab("#32", new RawPanel(32, 8));
        centerPnl.addTab("#64", new RawPanel(64, 8));
        centerPnl.addTab("#128", new RawPanel(128, 16));
        centerPnl.addTab("#256", new RawPanel(256, 16));
        centerPnl.addTab("#512", new RawPanel(512, 32));

        centerPnl.addTab("Demo", new DemoPanel(controller, model));

        SouthPanel southPnl = new SouthPanel(controller);

        setLayout(new BorderLayout());
        add(centerPnl, BorderLayout.CENTER);
        add(southPnl, BorderLayout.SOUTH);

        addKeyListener(controller);

        setFocusable(true);
        requestFocus();
    }
}
