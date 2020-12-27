package hw4;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class SeleniumContainedErrorTest extends AbstractBaseSeleniumTest {

    @Feature(value = "IndexPage Test")
    @Story(value = "login with wrong value")
    @Test(description = "Login test")

    public void loginTest() {
        actionStep.openHomePage();                                             //1. open site
        assertionStep.homePageLoaded();
        assertionStep.homePageTitleIsRelevant(title);                          //2. Browser title equals "Home Page"
        actionStep.login(login, wrongpass);                                    //3. Perform login
        assertionStep.checkUserName(user);                                     //4. check user name on page after authorization
        assertionStep.totalAssert();                                           //softAssert.assertAll();
    }

}

