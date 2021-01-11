package hw4;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class SeleniumVoidPageObjectTest extends AbstractBaseSeleniumTest {
    private final static String[] HEADER = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
    private final static String[] LEFT = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};

    @Feature(value = "IndexPage Test")
    @Story(value = "login and check benefit icons")
    @Test(description = "Login test. Check visibility of elements on IndexPage")
    public void voidPOTest() {

        actionStep.openHomePage();                                             //1. open site
        assertionStep.homePageLoaded();
        assertionStep.homePageTitleIsRelevant(title);                          //2. Browser title equals "Home Page"
        actionStep.login(login, pass);                                         //3. Perform login
        assertionStep.checkUserName(user);                                     //4. check user name on page after authorization
        assertionStep.checkFourHeaderElementsNameAndVisibility(HEADER);        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        assertionStep.checkBenefitIconVisibility();                            //6. four images on Index page are displayed
        assertionStep.checkDescriptionUnderBenefitIconsAndVisibility();        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertionStep.checkFrameButtonIntoIframe();                            //8.Assert that there is the iframe with “Frame Button” exist
        assertionStep.checkFrameButtonExist();                                 //9.Switch to the iframe and check that there is “Frame Button” in the iframe
        actionStep.swichFromFrame();                                            //10.Switch to original window back
        assertionStep.checkFiveItemsFromLeftMenuForNameAndVisibility(LEFT);    //11.Assert that there are 5 items in the Left Section are displayed and they have proper text
        assertionStep.totalAssert();                                           //softAssert.assertAll();

    }

}

