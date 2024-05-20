package org.llschall.jdmxlight.demo.model;

import org.llschall.jdmxlight.JDmxLight;
import org.llschall.jdmxlight.JDmxLightStarter;
import org.llschall.jdmxlight.demo.DemoException;
import org.llschall.jdmxlight.demo.Logger;
import org.llschall.jdmxlight.demo.controller.DemoController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import static org.llschall.jdmxlight.demo.controller.DemoController.*;

public class DemoModel {

    final List<IChangeListener> listeners = new ArrayList<>();

    boolean started = false;

    final ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

    final JDmxLightStarter starter = new JDmxLightStarter();

    public DemoModel() {
        map.put(COLOR, 0);
        map.put(INCLINATION, 50);
        map.put(ROTATION, 50);
        map.put(GOBOS, 0);
        map.put(NETTETE, 50);

    }

    public void addListener(IChangeListener listener) {
        listeners.add(listener);
    }

    public int getDmxValue(String name) {

        Integer i = map.get(name);
        if (i == null) {
            throw new DemoException("DMX value not found: [" + name + "]");
        }
        return i;
    }

    public void fireDmxValueChanged(String name, int value) {
        map.put(name, value);
        update();
        for (IChangeListener listener : listeners) {
            listener.modelChanged();
        }
    }

    public void fireLocationMoved(int x, int y) {
        map.put(DemoController.ROTATION, x);
        map.put(DemoController.INCLINATION, y);
        update();
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

    void update() {
        if (!started) {
            Logger.get().msg("No data sent as Ardwloop is not started.");
            return;
        }

        map.get(DemoController.ROTATION);

        starter.update(
                map.get(DemoController.ROTATION),
                map.get(DemoController.INCLINATION),
                map.get(DemoController.COLOR)
        );
    }

}
