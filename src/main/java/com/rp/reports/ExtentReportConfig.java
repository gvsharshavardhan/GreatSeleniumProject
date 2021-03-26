package com.rp.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static com.rp.constants.FrameWorkConstants.getExtentReportPath;

public final class ExtentReportConfig {
    private static ExtentReports extent;

    private ExtentReportConfig() {
    }

    public static void initReport() throws Exception {
        if (Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(getExtentReportPath());
            extent.attachReporter(spark);
            spark.config().setDocumentTitle("Great selenium report");
            spark.config().setTheme(Theme.DARK);
            spark.config().setReportName("Orange hrm report");
        }
    }

    public static void closeReport() throws Exception {
        if (Objects.nonNull(extent)) {
            extent.flush();
        }

        //this line, opens report in the browser.
        try {
            Desktop.getDesktop().browse(new File(getExtentReportPath()).toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createTest(String testName) {
        ExtentReportManager.setTest(extent.createTest(testName));
    }
}