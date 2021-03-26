package com.rp.reports;

import com.aventstack.extentreports.ExtentTest;

import java.util.Objects;

public final class ExtentReportManager {

    private ExtentReportManager() {
    }

    private static ThreadLocal<ExtentTest> tl = new ThreadLocal();

    static void setTest(ExtentTest test) {
        if (Objects.nonNull(test))
            tl.set(test);
    }

    static ExtentTest getTest() {
        return tl.get();
    }

    public static void unloadTest() {
        tl.remove();
    }
}
