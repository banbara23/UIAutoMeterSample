
package com.ikmr.banbara23.uiautometersample;

import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.UiAutomatorInstrumentationTestRunner;
import android.support.test.uiautomator.UiDevice;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UITest extends UiAutomatorInstrumentationTestRunner {

    private UiDevice device;

    @Before
    public void setUp() throws Exception {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        device.pressHome();
    }

    @Test
    public void Hello_worldが表示されること() {
        Assert.assertThat(device, CoreMatchers.is(CoreMatchers.notNullValue()));
    }
}
