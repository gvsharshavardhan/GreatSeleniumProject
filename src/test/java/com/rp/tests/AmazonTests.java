package com.rp.tests;

import com.rp.annotations.FrameworkAnnotation;
import com.rp.enums.CategoryType;
import com.rp.pages.AmazonHomePage;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Map;

public class AmazonTests extends BaseTest {

    @FrameworkAnnotation(author = {"harsha", "ramcharan"}, groups = {CategoryType.REGRESSION, CategoryType.SMOKE})
    @Test
    public void testLaptopsPage(Map<String, String> map) throws Exception {
        AmazonHomePage amazonHomePage = new AmazonHomePage();
        String title = amazonHomePage.goToAmazonHomePage()
                .clickHamburgerMenu()
                .clickLinkMobilesAndComputers()
                .clickLinkSubMenuXpath(map.get("menuname"))
                .getPageHeader();
        Assertions.assertThat(title)
                .isNotNull()
                .isNotBlank();
    }
}