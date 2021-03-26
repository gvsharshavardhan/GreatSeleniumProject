package com.rp.pages;

import com.rp.driver.DriverManager;
import com.rp.enums.ConfigProperties;
import com.rp.enums.WaitStrategy;
import com.rp.utilities.PropertiesUtil;
import org.openqa.selenium.By;

public final class OrangeLoginPage extends BasePage {

    private final String CREDENTIALS_TEXT_XPATH = "//span[text()='( Username : Admin | Password : admin123 )']";
    private final String INPUT_FIELD_CSS_SELECTOR = "input[name='txtUsername']";
    private final String PASSWORD_FIELD_CSS_SELECTOR = "input[name='txtPassword']";
    private final String LOGIN_BUTTON_CSS_SELECTOR = "input[type='submit']";
    private final String FORGOT_PASSOWORD_LINK_TEXT = "Forgot your password?";


    public void goToOrangeLoginPage() throws Exception {
        goToPage(PropertiesUtil.get(ConfigProperties.URL));
    }

    private String getCredentialsFromCredentialText() {
        return DriverManager.getDriver().findElement(By.xpath(CREDENTIALS_TEXT_XPATH)).getText().trim();
    }

    public String getUserName() {
        return getCredentialsFromCredentialText().split("\\|")[0].split(":")[1].trim();
    }

    public String getPassword() {
        return getCredentialsFromCredentialText().split("\\|")[1].split(":")[1].substring(0, 9).trim();
    }

    public OrangeLoginPage enterUserName(String userName) {
        sendKeys(By.cssSelector(INPUT_FIELD_CSS_SELECTOR), userName, WaitStrategy.PRESENCE);
        return this;
    }

    public OrangeLoginPage enterPassword(String password) {
        sendKeys(By.cssSelector(PASSWORD_FIELD_CSS_SELECTOR), password, WaitStrategy.PRESENCE);
        return this;
    }

    public OrangeDashBoardPage clickLogin() {
        click(By.cssSelector(LOGIN_BUTTON_CSS_SELECTOR), WaitStrategy.CLICKABLE, "login button");
        return new OrangeDashBoardPage();
    }

    public void clickForgetPassword() {
        click(By.linkText(FORGOT_PASSOWORD_LINK_TEXT), WaitStrategy.CLICKABLE, "forget passowrd");
    }

    public String getTitle() {
        return getPageTitle();
    }
}