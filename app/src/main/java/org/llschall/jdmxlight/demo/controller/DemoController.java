package org.llschall.jdmxlight.demo.controller;

import org.llschall.jdmxlight.demo.Logger;
import org.llschall.jdmxlight.demo.model.DemoModel;
import org.llschall.jdmxlight.demo.view.DemoView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DemoController implements ActionListener, KeyListener {

    public static final String ROTATION = "Rotation";
    public static final String INCLINATION = "Inclinaison";
    public static final String COLOR = "Couleur";
    public static final String GOBOS = "Gobos";
    public static final String NETTETE = "Netteté";

    final DemoModel model = new DemoModel();
    private DemoView view;

    public void display() {
        view = new DemoView(this, model);
        view.display();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean isRaw = view.isCurrentTabRaw();

        String cmd = e.getActionCommand();
        switch (cmd) {
            case "Start":
                model.start(isRaw);
                return;
            case "Exit":
                fireExitEvent();
                return;
            default:
                Logger.get().msg("Ignored command: " + cmd);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // do nothing
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        Logger.get().msg("Key Event " + code);

        if (code == 27) {
            fireExitEvent();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // do nothing
    }

    void fireExitEvent() {
        System.exit(0);
    }
}
