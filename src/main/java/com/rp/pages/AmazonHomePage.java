package com.rp.pages;

import com.rp.driver.DriverManager;
import com.rp.enums.ConfigProperties;
import com.rp.enums.WaitStrategy;
import com.rp.utilities.PropertiesUtil;
import org.openqa.selenium.By;


public class AmazonHomePage extends BasePage {

    private final By HamburgerMenu = By.id("nav-hamburger-menu");

    public AmazonHomePage goToAmazonHomePage() throws Exception {
        DriverManager.getDriver().get(PropertiesUtil.getPropertyValue(ConfigProperties.AMAZONURL));
        return new AmazonHomePage();
    }

    public AmazonHamburgerPage clickHamburgerMenu() {
        click(HamburgerMenu, WaitStrategy.CLICKABLE, "Hamburger menu");
        return new AmazonHamburgerPage();
    }
}