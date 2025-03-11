package org.llschall.jdmxlight.demo.view;

import org.llschall.jdmxlight.demo.controller.DemoController;
import org.llschall.jdmxlight.demo.model.DemoModel;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import java.awt.BorderLayout;

class BasicPanel extends JPanel {

    final DemoModel model;

    BasicPanel(DemoController controller, DemoModel model) {
        this.model = model;

        String libraryName = model.createLibraryName();

        NorthPanel northPnl = new NorthPanel(controller, model, libraryName);
        CenterPanel centerPnl = new CenterPanel(controller, model);


        JPanel[] panels = {northPnl, centerPnl};
        for (JPanel pnl : panels) {
            pnl.setBorder(BorderFactory.createRaisedBevelBorder());
        }

        setLayout(new BorderLayout());
        add(northPnl, BorderLayout.NORTH);
        add(centerPnl, BorderLayout.CENTER);

        addKeyListener(controller);

        setFocusable(true);
        requestFocus();
    }
}
