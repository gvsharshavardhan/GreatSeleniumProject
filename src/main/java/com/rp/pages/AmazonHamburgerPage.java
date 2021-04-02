package com.rp.pages;

import com.rp.enums.WaitStrategy;
import com.rp.utilities.DynamicXpathUtil;
import org.openqa.selenium.By;

public class AmazonHamburgerPage extends BasePage {

    private final By linkMobilesAndComputers = By.xpath("//div[contains(.,'Mobiles, Computers')]/parent::a");

    private String linkSubMenuXpath = "//a[.='%s']";

    public AmazonHamburgerPage clickLinkMobilesAndComputers() {
        click(linkMobilesAndComputers, WaitStrategy.CLICKABLE, "Mobiles and computers");
        return new AmazonHamburgerPage();
    }

    public AmazonLaptopsPage clickLinkSubMenuXpath(String menutext) {
        click(By.xpath(DynamicXpathUtil.getXpath(linkSubMenuXpath, menutext)), WaitStrategy.CLICKABLE, menutext);
        if (menutext.equalsIgnoreCase("laptops")) {
            return new AmazonLaptopsPage();
        }
        return new AmazonLaptopsPage();
    }
}