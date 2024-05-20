package org.llschall.jdmxlight.demo.model;

import org.llschall.jdmxlight.JDmxLight;
import org.llschall.jdmxlight.JDmxLightStarter;
import org.llschall.jdmxlight.demo.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DemoModel {

    final List<IChangeListener> listeners = new ArrayList<>();

    boolean started = false;

    public final AtomicInteger rotation = new AtomicInteger(50);
    public final AtomicInteger inclination = new AtomicInteger(50);
    final AtomicInteger color = new AtomicInteger();

    final JDmxLightStarter starter = new JDmxLightStarter();

    public void addListener(IChangeListener listener) {
        listeners.add(listener);
    }

    public void fireLocationMoved(int x, int y) {
        rotation.set(x);
        inclination.set(y);
        for (IChangeListener listener : listeners) {
            listener.modelChanged();
        }
    }

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
