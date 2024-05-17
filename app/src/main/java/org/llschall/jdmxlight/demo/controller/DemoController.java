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

    final DemoModel model = new DemoModel();

    public void display() {

        DemoView view = new DemoView(this, model);
        view.display();
    }

    public void start() {
        model.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch (cmd) {
            case "Start":
                model.start();
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

    public void fireValueChanged(String name, int i) {
        switch (name) {
            case COLOR -> model.setColor(i);
            case ROTATION -> model.setRotation(i);
            case INCLINATION -> model.setInclination(i);
            default -> Logger.get().msg("Ignored value: " + name);
        }
    }

    void fireExitEvent() {
        System.exit(0);
    }
}
