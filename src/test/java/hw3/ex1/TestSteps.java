package hw3.ex1;

import org.testng.asserts.SoftAssert;
import pages.hw3.ElementNameVisibility;
import pages.hw3.HomePage;

public class TestSteps {
    protected SoftAssert softAssert;
    private HomePage homePage;
    protected final static String[] header = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
    protected final static String[] left = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
    protected String[] keyWord = new String[4];

    public TestSteps(SoftAssert softAssert, HomePage homePage) {
        this.softAssert = softAssert;
        this.homePage = homePage;
    }

    protected void checkFiveItemsFromLeftMenuForNameAndVisibility() {
        int i = 0;
        for (ElementNameVisibility env : homePage.listOfLeftBlockTextAndVisibility()) {
            softAssert.assertTrue(env.getVisible(), "element is not displayed");
            softAssert.assertEquals(env.getName(), left[i]);
            i++;
        }
    }

    protected void checkDescriptionUnderBenefitIconsAndVisibility() {
        int i;
        i = 0;
        for (ElementNameVisibility env : homePage.listOfBenefitDescTextAndVisibility()) {
            softAssert.assertTrue(env.getVisible(), "benefit-description under icor is not displayed");
            softAssert.assertTrue(env.getName().contains(keyWord[i]), "the text below Image doesn't contain the proper word");
            i++;
        }
    }

    protected void checkBenefitIconVisibility() {
        int i = 0;
        for (ElementNameVisibility env : homePage.listOfPicturesTextAndVisibility()) {
            softAssert.assertTrue(env.getVisible(), "benefit-icon is not displayed");
            keyWord[i] = env.getName();             // array keyWord is used for assert from step7
            i++;
        }
    }

    protected void checkFourHeaderElementsNameAndVisibility() {
        int i = 0;
        for (ElementNameVisibility env : homePage.getHeaderMenu().listHeadersNameAndVisibility()) {
            softAssert.assertTrue(env.getVisible(), "element is not displayed");
            softAssert.assertEquals(env.getName(), header[i]);
            i++;
        }
    }

    protected void login(String login, String pass) {
        homePage.clickUserIcon();
        homePage.login(login, pass);

    }

    protected void checkUserName(String user) {
        softAssert.assertEquals(homePage.getUserName(), user);
    }

    protected void checkFrameButtonIntoIframe() {
        softAssert.assertTrue(homePage.numberIframesWithFrameButton() > 0,
                "there is not frame with Frame Button");
    }

    protected void checkFrameButtonExist() {
        softAssert.assertTrue(homePage.frameButtonExist(),
                "there isn't element Frame Button");
    }
}
