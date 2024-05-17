package org.llschall.jdmxlight.demo;

import org.llschall.jdmxlight.demo.controller.DemoController;

public class App {

    public static void main(String[] args) {
        new DemoController().start();
        Logger.get().msg("Demo started.");
    }

}
