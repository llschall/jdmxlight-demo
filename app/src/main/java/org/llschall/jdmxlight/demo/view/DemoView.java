package org.llschall.jdmxlight.demo.view;

import org.llschall.jdmxlight.demo.model.DemoModel;

import javax.swing.*;


public class DemoView extends JFrame {

    final DemoModel model;

    public DemoView(DemoModel model) {
        this.model = model;
        setTitle(model.createTitle());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void display() {
        setSize(800, 600);
        setVisible(true);
    }

}
