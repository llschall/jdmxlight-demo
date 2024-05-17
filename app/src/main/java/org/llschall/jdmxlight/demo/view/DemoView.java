package org.llschall.jdmxlight.demo.view;

import org.llschall.jdmxlight.demo.controller.DemoController;
import org.llschall.jdmxlight.demo.model.DemoModel;

import javax.swing.*;


public class DemoView extends JFrame {

    public DemoView(DemoController controller, DemoModel model) {

        setTitle("JDmxLight Demo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().add(new RootPanel(controller, model));
    }

    public void display() {
        setSize(800, 600);
        setVisible(true);
    }
}
