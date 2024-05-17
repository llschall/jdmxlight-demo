package org.llschall.jdmxlight.demo;

public class Logger {

    private final static Logger INSTANCE = new Logger();

    private Logger() {
        // Singleton pattern
    }

    public static Logger get() {
        return INSTANCE;
    }

    public void msg(String msg) {
        System.out.println("# " + msg);
    }
}
