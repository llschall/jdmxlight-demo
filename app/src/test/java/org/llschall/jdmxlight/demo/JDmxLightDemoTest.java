package org.llschall.jdmxlight.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.llschall.jdmxlight.demo.model.DemoModel;

public class JDmxLightDemoTest {

    @Test
    public void testSetup() {

        DemoModel model = new DemoModel();
        String title = model.createTitle();
        Assertions.assertFalse(title.isBlank());
    }
}
