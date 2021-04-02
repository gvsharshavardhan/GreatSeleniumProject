package com.rp.tests;

import com.rp.driver.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Map;

public class BaseTest {

    protected BaseTest() {

    }

    //object array is coming from @test methods parameters, @test methods parameters will come as object array.
    @BeforeMethod
    protected void setUp(Object[] data) {
        Map<String, String> map = (Map<String, String>) data[0];
        System.out.println(map.get("browser"));
        DriverFactory.initDriver(map.get("browser"));
    }

    @AfterMethod
    protected void tearDown() {
        DriverFactory.quitDriver();
    }
}