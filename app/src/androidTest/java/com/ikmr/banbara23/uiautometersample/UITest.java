
package com.ikmr.banbara23.uiautometersample;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiAutomatorInstrumentationTestRunner;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;

public class UITest extends UiAutomatorInstrumentationTestRunner {

    private static final int LAUNCH_TIMEOUT = 5000;
    private static final int UI_TIMEOUT = 5000;
    private UiDevice device;
    private static final String APP_PACKAGE = "com.ikmr.banbara23.uiautometersample";

    public static Intent createLaunchIntent(Context context, String packageName) {
        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(packageName);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

        return intent;
    }

    @Before
    public void setUp() throws Exception {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        device.pressHome();

        Context testContext = InstrumentationRegistry.getContext();
        Intent intent = createLaunchIntent(testContext, APP_PACKAGE);
        testContext.startActivity(intent);

        device.wait(Until.hasObject(By.pkg(APP_PACKAGE).depth(0)), LAUNCH_TIMEOUT);
    }

    @Test
    public void Hello_worldが表示されること() throws Exception {
        UiObject2 textView = device.wait(Until.findObject(By.text("Hello world")), UI_TIMEOUT);

        Assert.assertThat(textView.getText(), CoreMatchers.is("Hello world"));
    }
}
