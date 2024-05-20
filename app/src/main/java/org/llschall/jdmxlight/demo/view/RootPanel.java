package org.llschall.jdmxlight.demo.view;

import org.llschall.jdmxlight.demo.controller.DemoController;
import org.llschall.jdmxlight.demo.model.DemoModel;

import javax.swing.*;
import java.awt.*;

class RootPanel extends JPanel {

    final DemoModel model;

    RootPanel(DemoController controller, DemoModel model) {
        this.model = model;

        String libraryName = model.createLibraryName();

        NorthPanel northPnl = new NorthPanel(controller, model, libraryName);
        CenterPanel centerPnl = new CenterPanel(controller);
        SouthPanel southPnl = new SouthPanel(controller);

        JPanel[] panels = {northPnl, centerPnl, southPnl};
        for (JPanel pnl : panels) {
            pnl.setBorder(BorderFactory.createRaisedBevelBorder());
        }

        setLayout(new BorderLayout());
        add(northPnl, BorderLayout.NORTH);
        add(centerPnl, BorderLayout.CENTER);
        add(southPnl, BorderLayout.SOUTH);

        addKeyListener(controller);

        setFocusable(true);
        requestFocus();
    }
}
