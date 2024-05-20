package org.llschall.jdmxlight.demo.view;

import org.llschall.jdmxlight.demo.controller.DemoController;
import org.llschall.jdmxlight.demo.model.DemoModel;
import org.llschall.jdmxlight.demo.model.IChangeListener;

import javax.swing.*;
import java.awt.*;

class DemoSlider extends JPanel implements IChangeListener {

    final String name;

    final DemoController controller;
    final DemoModel model;

    final JSlider slider = new JSlider(0, 255);
    final JLabel valueLbl = new JLabel();

    DemoSlider(String name, DemoController controller, DemoModel model) {
        this.name = name;
        this.controller = controller;
        this.model = model;

        model.addListener(this);

        int start = model.getDmxValue(name);

        slider.setOrientation(JSlider.NORTH);
        slider.setValue(start);
        slider.setPaintTicks(true);

        valueLbl.setText(Integer.toString(start));

        slider.addMouseWheelListener(e -> {
            int rotation = e.getWheelRotation();
            int value = slider.getValue() - rotation;
            model.fireDmxValueChanged(name, value);
        });

        slider.addChangeListener(e -> {
            int value = slider.getValue();
            model.fireDmxValueChanged(name, value);
        });

        setBorder(BorderFactory.createRaisedBevelBorder());

        JPanel southPnl = new JPanel();
        JLabel nameLbl = new JLabel(name);

        nameLbl.setFont(nameLbl.getFont().deriveFont(Font.BOLD, 20));

        southPnl.setLayout(new GridLayout(0, 1));
        southPnl.add(valueLbl);
        southPnl.add(nameLbl);

        setLayout(new BorderLayout());
        add(slider, BorderLayout.CENTER);
        add(southPnl, BorderLayout.SOUTH);
    }

    @Override
    public void modelChanged() {
        int value = model.getDmxValue(name);
        valueLbl.setText("" + value);
        slider.setValue(value);
    }
}
