package org.llschall.jdmxlight.demo.view;

import org.llschall.jdmxlight.demo.model.DemoModel;

import javax.swing.*;


public class DemoView extends JFrame {

    public DemoView(DemoModel model) {

        setTitle("JDmxLight Demo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        getContentPane().add(new RootPanel(model));
    }

    public void display() {
        setSize(800, 600);
        setVisible(true);
    }
}
