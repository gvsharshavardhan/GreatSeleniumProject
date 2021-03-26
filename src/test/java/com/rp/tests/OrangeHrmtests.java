package com.rp.tests;

import com.rp.pages.OrangeDashBoardPage;
import com.rp.pages.OrangeLoginPage;
import com.rp.reports.ExtentLogger;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public final class OrangeHrmtests extends BaseTest {

    private OrangeHrmtests() {

    }

    @Test
    public void loginLogoutTest1() throws Exception {
        OrangeLoginPage olp = new OrangeLoginPage();
        olp.goToOrangeLoginPage();
        String title = olp.enterUserName(olp.getUserName())
                .enterPassword(olp.getPassword())
                .clickLogin()
                .clickWelcomeLink()
                .clickLogoutLink()
                .getTitle();
        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");
    }

    @Test
    public void loginLogoutTest2() throws Exception {
        OrangeLoginPage olp = new OrangeLoginPage();
        olp.goToOrangeLoginPage();
        String title = olp.enterUserName(olp.getUserName())
                .enterPassword(olp.getPassword())
                .clickLogin()
                .clickWelcomeLink()
                .clickLogoutLink()
                .getTitle();
        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");
        ExtentLogger.fail("failed for no reason!", true);
    }

    @Test(dependsOnMethods = "loginLogoutTest2")
    public void loginLogoutTest3() throws Exception {
        OrangeLoginPage olp = new OrangeLoginPage();
        olp.goToOrangeLoginPage();
        String title = olp.enterUserName(olp.getUserName())
                .enterPassword(olp.getPassword())
                .clickLogin()
                .clickWelcomeLink()
                .clickLogoutLink()
                .getTitle();
        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");
    }

    @Test
    public void loginLogoutTest4() throws Exception {
        OrangeLoginPage olp = new OrangeLoginPage();
        olp.goToOrangeLoginPage();
        String title = olp.enterUserName(olp.getUserName())
                .enterPassword(olp.getPassword())
                .clickLogin()
                .clickWelcomeLink()
                .clickLogoutLink()
                .getTitle();
        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");
    }

    @Test
    public void loginLogoutTest5() throws Exception {
        OrangeLoginPage olp = new OrangeLoginPage();
        olp.goToOrangeLoginPage();
        String title = olp.enterUserName(olp.getUserName())
                .enterPassword(olp.getPassword())
                .clickLogin()
                .clickWelcomeLink()
                .clickLogoutLink()
                .getTitle();
        Assertions.assertThat(title)
                .isEqualTo("OrangeHRM");
    }

    @Test(enabled = false)
    public void loginLogoutTest20() {
        OrangeLoginPage olp = new OrangeLoginPage();
        OrangeDashBoardPage odbp = olp.enterUserName(olp.getUserName()).enterPassword(olp.getPassword()).clickLogin();
        odbp.clickWelcomeLink().clickLogoutLink();
    }

    //parallel - runs multiple data set in parallel
    //to control control specify data-provider-thread-count at suite level in testng.xml file.
    @DataProvider(name = "datapump", parallel = true)
    Object[][] datapump() {
        Object[][] o = {{1, 3, 4}, {7, 8, 9}};
        return o;
    }
}