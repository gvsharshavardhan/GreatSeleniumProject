package com.rp.reports;

import com.rp.enums.ConfigProperties;
import com.rp.utilities.PropertiesUtil;
import com.rp.utilities.ScreenShotUtil;

public final class ExtentLogger {


    private ExtentLogger() {

    }

    public static void pass(String message) {
        ExtentReportManager.getTest().pass(message);
    }

    public static void fail(String message) {
        ExtentReportManager.getTest().fail(message);
    }

    public static void skip(String message) {
        ExtentReportManager.getTest().skip(message);
    }

    public static void info(String message) {
        ExtentReportManager.getTest().info(message);
    }

    public static void pass(String message, boolean isScreenShotRequired) throws Exception {
        if (PropertiesUtil.getPropertyValue(ConfigProperties.PASSEDSCREENSHOT).equalsIgnoreCase("yes") && isScreenShotRequired) {
            ExtentReportManager.getTest().pass(message, ScreenShotUtil.takeScreenShot());
        } else {
            pass(message);
        }
    }

    public static void fail(String message, boolean isScreenShotRequired) throws Exception {
        if (isScreenShotRequired &&
                PropertiesUtil.getPropertyValue(ConfigProperties.FAILEDSCREENSHOT).equalsIgnoreCase("yes")) {
            ExtentReportManager.getTest().fail(message, ScreenShotUtil.takeScreenShot());
        } else {
            fail(message);
        }
    }

    public static void skip(String message, boolean isScreenShotRequired) throws Exception {
        if (isScreenShotRequired &&
                PropertiesUtil.getPropertyValue(ConfigProperties.SKIPPEDSCREENSHOT).equalsIgnoreCase("yes")) {
            ExtentReportManager.getTest().skip(message, ScreenShotUtil.takeScreenShot());
        } else {
            skip(message);
        }
    }

    public static void info(String message, boolean isScreenShotRequired) {
        if (isScreenShotRequired) {
            ExtentReportManager.getTest().info(message, ScreenShotUtil.takeScreenShot());
        } else {
            info(message);
        }
        ExtentReportManager.getTest().info(message);
    }

}