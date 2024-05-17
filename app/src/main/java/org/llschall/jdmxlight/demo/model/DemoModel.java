package org.llschall.jdmxlight.demo.model;

import org.llschall.jdmxlight.JDmxLight;

public class DemoModel {

    public String createTitle() {

        String version = JDmxLight.VERSION;
        return "JDmxLight "+ version+" Demo";
    }

}
