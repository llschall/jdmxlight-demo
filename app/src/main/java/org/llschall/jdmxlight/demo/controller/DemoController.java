package org.llschall.jdmxlight.demo.controller;

import org.llschall.jdmxlight.demo.model.DemoModel;
import org.llschall.jdmxlight.demo.view.DemoView;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DemoController {

    public void start() {

        DemoModel model = new DemoModel();
        DemoView view = new DemoView(model);

        view.addKeyListener(createKeyListener());
        view.display();
    }

    KeyListener createKeyListener() {
        return new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                if (code == 27) {
                    System.exit(0);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
    }
}
