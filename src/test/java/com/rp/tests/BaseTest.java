package com.rp.tests;

import com.rp.driver.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected BaseTest() {

    }

    @BeforeMethod
    protected void setUp() {
        DriverFactory.initDriver();
    }

    @AfterMethod
    protected void tearDown() {
        DriverFactory.quitDriver();
    }
}