package com.rp.utilities;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import com.rp.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ScreenShotUtil {

    private ScreenShotUtil() {
    }

    public static Media takeScreenShot() {

        return MediaEntityBuilder
                .createScreenCaptureFromBase64String(((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64)).build();
    }
}
