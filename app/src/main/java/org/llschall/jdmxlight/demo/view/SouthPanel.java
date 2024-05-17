package org.llschall.jdmxlight.demo.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

class SouthPanel extends JPanel {

    SouthPanel(ActionListener listener) {

        JButton exitBtn = new JButton("Exit");
        exitBtn.addActionListener(listener);

        setLayout(new FlowLayout());
        add(exitBtn);

    }
}
