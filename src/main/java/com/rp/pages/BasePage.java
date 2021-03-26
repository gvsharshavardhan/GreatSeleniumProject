package com.rp.pages;

import com.rp.driver.DriverManager;
import com.rp.enums.WaitStrategy;
import com.rp.factories.ExplicitWaitFactory;
import com.rp.reports.ExtentLogger;
import org.openqa.selenium.By;

public class BasePage {

    protected void goToPage(String url) {
        DriverManager.getDriver().get(url);
        ExtentLogger.info("Landed on to orange hrm page!");
    }

    protected void click(By by, WaitStrategy waitStrategy, String elementName) {
        ExplicitWaitFactory.performExplicitWait(waitStrategy, by).click();
        ExtentLogger.info("clicked " + elementName + "!");
    }

    protected void sendKeys(By by, String value, WaitStrategy waitStrategy) {
        ExplicitWaitFactory.performExplicitWait(waitStrategy, by).sendKeys(value);
        ExtentLogger.info("Entered " + value + "!");
    }

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle().trim();
    }

    protected void explicitlyWaitForPageTitleIsVisible(By by) {
        ExplicitWaitFactory.performExplicitWait(WaitStrategy.VISIBLE, by);
    }
}