package org.llschall.jdmxlight.demo.view;

import org.llschall.jdmxlight.demo.model.DemoModel;

import javax.swing.*;
import java.awt.*;

class RootPanel extends JPanel {

    final DemoModel model;

    RootPanel(DemoModel model) {
        this.model = model;

        String libraryName = model.createLibraryName();

        NorthPanel northPnl = new NorthPanel(libraryName);
        CenterPanel centerPnl = new CenterPanel();
        SouthPanel southPnl = new SouthPanel();

        JPanel[] panels = {northPnl, centerPnl, southPnl};
        for (JPanel pnl : panels) {
            pnl.setBorder(BorderFactory.createRaisedBevelBorder());
        }

        setLayout(new BorderLayout());
        add(northPnl, BorderLayout.NORTH);
        add(centerPnl, BorderLayout.CENTER);
        add(southPnl, BorderLayout.SOUTH);
    }
}
