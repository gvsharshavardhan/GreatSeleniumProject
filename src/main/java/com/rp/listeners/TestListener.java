package com.rp.listeners;

import com.rp.reports.ExtentLogger;
import com.rp.reports.ExtentReportConfig;
import com.rp.reports.ExtentReportManager;
import lombok.SneakyThrows;
import org.testng.*;

public class TestListener implements ITestListener, ISuiteListener {
    @SneakyThrows
    @Override
    public void onStart(ISuite suite) {
        ExtentReportConfig.initReport();
    }


    @SneakyThrows
    @Override
    public void onFinish(ISuite suite) {
        ExtentReportConfig.closeReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReportConfig.createTest(result.getName());
        ExtentLogger.info(result.getName() + " started!");
    }


    @Override
    public void onTestSuccess(ITestResult result) {
        try {
            ExtentLogger.pass(result.getName() + " passed!", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onTestFailure(ITestResult result) {
        try {
            ExtentLogger.fail(result.getName() + " failed!", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        try {
            ExtentLogger.skip(result.getName() + " skipped!", true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {
        ExtentReportConfig.createTest(context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportManager.unloadTest();
    }
}