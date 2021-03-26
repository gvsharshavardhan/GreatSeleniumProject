package com.rp.factories;

import com.rp.constants.FrameWorkConstants;
import com.rp.driver.DriverManager;
import com.rp.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class ExplicitWaitFactory {

    private ExplicitWaitFactory() {

    }

    public static WebElement performExplicitWait(WaitStrategy waitStrategy, By by) {
        WebElement ele = null;
        if (waitStrategy == WaitStrategy.CLICKABLE) {
            //        wait.until(e->DriverManager.getDriver().findElement(LOGOUT_LINK).isEnabled());
            //        above code can be used - java 8 features.
            ele = new WebDriverWait(DriverManager.getDriver(), FrameWorkConstants.getExplicitwait())
                    .until(ExpectedConditions.elementToBeClickable(by));
        } else if (waitStrategy == WaitStrategy.PRESENCE) {
            ele = new WebDriverWait(DriverManager.getDriver(), FrameWorkConstants.getExplicitwait())
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        } else if (waitStrategy == WaitStrategy.VISIBLE) {
            ele = new WebDriverWait(DriverManager.getDriver(), FrameWorkConstants.getExplicitwait())
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        } else if (waitStrategy == WaitStrategy.NONE) {
            ele = DriverManager.getDriver().findElement(by);
        }
        return ele;
    }
}