package org.llschall.jdmxlight.demo.model;

import org.llschall.jdmxlight.JDmxLight;
import org.llschall.jdmxlight.JDmxLightStarter;
import org.llschall.jdmxlight.demo.Logger;

import java.util.concurrent.atomic.AtomicInteger;

public class DemoModel {

    boolean started = false;

    final AtomicInteger rotation = new AtomicInteger();
    final AtomicInteger inclination = new AtomicInteger();
    final AtomicInteger color = new AtomicInteger();

    final JDmxLightStarter starter = new JDmxLightStarter();

    public String createLibraryName() {

        String version = JDmxLight.VERSION;
        return "JDmxLight " + version;
    }

    public void start() {
        starter.start();
        started = true;
    }

    public void setRotation(int i) {
        rotation.set(i);
        update();
    }

    public void setInclination(int i) {
        inclination.set(i);
        update();
    }

    public void setColor(int i) {
        color.set(i);
        update();
    }

    void update() {
        if (!started) {
            Logger.get().msg("No data sent as Ardwloop is not started.");
            return;
        }
        starter.update(rotation.get(), inclination.get(), color.get());
    }

}
