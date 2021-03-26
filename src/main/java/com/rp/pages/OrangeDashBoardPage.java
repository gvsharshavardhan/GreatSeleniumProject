package com.rp.pages;

import com.rp.driver.DriverManager;
import com.rp.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public final class OrangeDashBoardPage extends BasePage {
    private final String QUICK_LAUNCH_OPTIONS_CSS_SELECTOR = "table.quickLaungeContainer  span.quickLinkText";
    private final String DASHBOARD_PAGE_HEADER_XPATH = "//h1";
    private final By WELCOME_LINK = By.cssSelector("a#welcome");
    private final By LOGOUT_LINK = By.xpath("//a[.='Logout']");

    public List<String> getAllQuickLaunchOptions() {
        List<WebElement> optionElements = DriverManager.getDriver().findElements(By.cssSelector(QUICK_LAUNCH_OPTIONS_CSS_SELECTOR));
        List<String> options = new ArrayList<>();
        for (WebElement e : optionElements) {
            options.add(e.getText().trim());
        }
        return options;
    }

    public String getHeaderName() {
        return DriverManager.getDriver().findElement(By.xpath(DASHBOARD_PAGE_HEADER_XPATH)).getText().trim();
    }

    public void WaitUntilDashBoardPageTitleIsVisible() {
        explicitlyWaitForPageTitleIsVisible(By.xpath(DASHBOARD_PAGE_HEADER_XPATH));
    }

    public OrangeDashBoardPage clickWelcomeLink() {
        click(WELCOME_LINK, WaitStrategy.CLICKABLE, "welcome link");
        return this;
    }

    public OrangeLoginPage clickLogoutLink() {
//        below code can be used instead of thread.sleep(), it internally handles interrupted exceptions
//        this code snippet comes from "commons-lang3" module (check in pom.xml)
//        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);

        click(LOGOUT_LINK, WaitStrategy.CLICKABLE, "log out link");
        return new OrangeLoginPage();
    }
}