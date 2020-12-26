package hw3.ex1;

import hw3.AbstractBaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.hw3.HomePage;

public class Ex1Test extends AbstractBaseTest {

    @Test
    protected void ex1Test() {
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(driver);
        softAssert.assertTrue(homePage.openPage());                 //1. open site
        softAssert.assertEquals(homePage.headTitleText(), title);   //2. Browser title equals "Home Page"

        TestSteps ts = new TestSteps(softAssert, homePage);
        ts.login(login, pass);                                      //3. Perform login
        ts.checkUserName(user);                                     //4. check user name on page after authorization
        ts.checkFourHeaderElementsNameAndVisibility();              //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        ts.checkBenefitIconVisibility();                            //6. four images on Index page are displayed
        ts.checkDescriptionUnderBenefitIconsAndVisibility();        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        ts.checkFrameButtonIntoIframe();                            //8.Assert that there is the iframe with “Frame Button” exist
        ts.checkFrameButtonExist();                                 //9.Switch to the iframe and check that there is “Frame Button” in the iframe
        homePage.switchBackFromFrame();                             //10.Switch to original window back
        ts.checkFiveItemsFromLeftMenuForNameAndVisibility();        //11.Assert that there are 5 items in the Left Section are displayed and they have proper text

        softAssert.assertAll();
    }

}

