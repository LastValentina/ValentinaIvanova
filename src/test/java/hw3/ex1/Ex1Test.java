package hw3.ex1;

import hw3.AbstractBaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.hw3.ElementNameVisibility;
import pages.hw3.HomePage;

public class Ex1Test extends AbstractBaseTest {
    protected final static String[] header = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
    protected final static String[] left = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};

    @Test
    protected void loginTest() {
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        softAssert.assertTrue(homePage.openPage());                 //1. open site
        softAssert.assertEquals(homePage.headTitleText(), title);   //2. Browser title equals "Home Page"
        softAssert.assertEquals(homePage.login(login, pass), user); //3. Perform login //4. check user name on page after authorization

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        int i = 0;
        for (ElementNameVisibility env : homePage.getHeaderMenu().listHeadersNameAndVisibility()) {
            softAssert.assertTrue(env.getVisible(), "element is not displayed");
            softAssert.assertEquals(env.getName(), header[i]);
            i++;
        }

        //6. four images on Index page are displayed
        String[] keyWord = new String[4];
        i = 0;
        for (ElementNameVisibility env : homePage.listOfPicturesTextAndVisibility()) {
            softAssert.assertTrue(env.getVisible(), "benefit-icon is not displayed");
            keyWord[i] = env.getName();             // array keyWord is used for assert from step7
            i++;
        }

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        i = 0;
        for (ElementNameVisibility env : homePage.listOfBenefitDescTextAndVisibility()) {
            softAssert.assertTrue(env.getVisible(), "benefit-description under icor is not displayed");
            softAssert.assertTrue(env.getName().contains(keyWord[i]), "the text below Image doesn't contain the proper word");
            i++;
        }

        //8.Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(homePage.numberIframesWithFrameButton() > 0, "there is not frame with Frame Button");

        //9.Switch to the iframe and check that there is “Frame Button” in the iframe
        softAssert.assertTrue(homePage.frameButtonExist(), "there isn't element Frame Button");
        homePage.switchBackFromFrame();         //10.Switch to original window back

        //11.Assert that there are 5 items in the Left Section are displayed and they have proper text
        i = 0;
        for (ElementNameVisibility env : homePage.listOfLeftBlockTextAndVisibility()) {
            softAssert.assertTrue(env.getVisible(), "element is not displayed");
            softAssert.assertEquals(env.getName(), left[i]);
            i++;
        }
        softAssert.assertAll();
    }
}

