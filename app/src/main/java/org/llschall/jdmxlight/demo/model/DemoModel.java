package org.llschall.jdmxlight.demo.model;

import org.llschall.jdmxlight.DefaultUsbSelector;
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

    final ConcurrentHashMap<Integer, Integer> rawMap = new ConcurrentHashMap<>();

    final JDmxLightStarter starter = new JDmxLightStarter(32);

    boolean isRaw;

    public DemoModel() {
        for (int i = 1; i <= 32; i++) {
            rawMap.put(i, 0);
        }

        map.put(COLOR, 0);
        map.put(ROTATION, 25);
        map.put(INCLINATION, 50);
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

    public void fireDmxValueChanged(int channel, int value) {
        rawMap.put(channel, value);
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

    public void start(boolean isRaw) {

        this.isRaw = isRaw;

        starter.start(new DefaultUsbSelector());
        started = true;
        update();
    }

    void update() {
        if (!started) {
            Logger.get().msg("No data sent as Ardwloop is not started.");
            return;
        }

        if (isRaw) {
            rawMap.forEach(this::sendDmx);
            return;
        }

        starter.update(1, map.get(ROTATION));
        starter.update(2, map.get(INCLINATION));
        starter.update(6, map.get(COLOR));

        starter.update(7, 255); // frequence obturateur
        starter.update(8, 30); // gradateur electronique
        starter.update(9, map.get(GOBOS));
        starter.update(14, map.get(NETTETE));
    }

    void sendDmx(int channel, int value) {
        if (isRaw) {
            starter.update(channel, value);
        }
    }

}
