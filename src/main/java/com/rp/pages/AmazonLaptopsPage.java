package com.rp.pages;

import com.rp.enums.WaitStrategy;
import com.rp.factories.ExplicitWaitFactory;
import org.openqa.selenium.By;

public class AmazonLaptopsPage extends BasePage {
    private final By pageHeader = By.xpath("//h1");

    public String getPageHeader() {
        return ExplicitWaitFactory.performExplicitWait(WaitStrategy.VISIBLE, pageHeader).getText().trim();
    }
}