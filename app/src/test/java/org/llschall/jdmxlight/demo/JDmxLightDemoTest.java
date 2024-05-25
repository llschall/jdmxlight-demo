package org.llschall.jdmxlight.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.llschall.jdmxlight.JDmxLight;
import org.llschall.jdmxlight.demo.model.DemoModel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JDmxLightDemoTest {

    @Test
    public void testSetup() {
        assertEquals("0.0.2", JDmxLight.VERSION);
        assertEquals(1002, JDmxLight.VERSION_INT);
    }


    @Test
    public void testModel() {
        DemoModel model = new DemoModel();
        String title = model.createLibraryName();
        Assertions.assertFalse(title.isBlank());
    }


}
