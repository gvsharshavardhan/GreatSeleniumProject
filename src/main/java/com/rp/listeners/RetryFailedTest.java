package com.rp.listeners;

import com.rp.enums.ConfigProperties;
import com.rp.utilities.PropertiesUtil;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTest implements IRetryAnalyzer {

    private int count = 0;

    @Override
    public boolean retry(ITestResult iTestResult) {
        boolean value = false;
        try {
            if (PropertiesUtil.getPropertyValue(ConfigProperties.RETRYFAILEDTEST).equalsIgnoreCase("yes")) {
                int retries = 1;
                value = count < retries;
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}