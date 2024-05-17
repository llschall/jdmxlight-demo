package org.llschall.jdmxlight.demo.view;

import javax.swing.*;
import java.awt.*;

class NorthPanel extends JPanel {

    NorthPanel(String libraryName) {
        setLayout(new FlowLayout());
        add(new JLabel("Featuring " + libraryName));
    }
}
