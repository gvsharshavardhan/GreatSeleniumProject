package com.rp.driver;

import com.rp.constants.FrameWorkConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class DriverFactory {

    private DriverFactory() {

    }

    public static void initDriver(String browser) {
        if (Objects.isNull(DriverManager.getDriver())) {
            if (browser.equalsIgnoreCase("chrome")) {
//                System.setProperty("webdriver.chrome.driver", FrameWorkConstants.getChromeDriverPath());
                WebDriverManager.chromedriver().setup();
                DriverManager.setDriver(new ChromeDriver());
            } else if (browser.equalsIgnoreCase("firefox")) {
//            System.setProperty("webdriver.chrome.driver", FrameWorkConstants.getChromeDriverPath());
                WebDriverManager.firefoxdriver().setup();
                DriverManager.setDriver(new FirefoxDriver());
            }
        }
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(FrameWorkConstants.getImplictWait(), TimeUnit.SECONDS);
    }


    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}