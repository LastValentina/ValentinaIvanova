package hw3.ex1;

import hw3.AbstractBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.hw3.HomePage;

public class AdditionalLoginTest extends AbstractBaseTest {

    @Test
    protected void negativeLoginTest() {
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(driver);
        softAssert.assertTrue(homePage.openPage());
        softAssert.assertEquals(homePage.headTitleText(), title);
        homePage.clickUserIcon();
        homePage.differentLogin(login, wrongpass);
        Assert.assertTrue(homePage.loginTxtVisibility());
        homePage.differentLogin(login, pass);
        softAssert.assertEquals(homePage.getUserName(), user);
        Assert.assertFalse(homePage.loginTxtVisibility());
        softAssert.assertAll();
    }

}

