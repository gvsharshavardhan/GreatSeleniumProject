package com.rp.tests;

import com.rp.pages.OrangeDashBoardPage;
import com.rp.pages.OrangeLoginPage;
import org.testng.annotations.Test;

/*
i don't want other to create object and should not be able to extends this class
 */
public final class LoginPageTests extends BaseTest {

    private LoginPageTests() {

    }

    @Test(enabled = false)
    public void loginLogoutTest10() {
        OrangeLoginPage olp = new OrangeLoginPage();
        OrangeDashBoardPage odbp = olp.enterUserName(olp.getUserName()).enterPassword(olp.getPassword()).clickLogin();
        odbp.clickWelcomeLink().clickLogoutLink();
    }

}