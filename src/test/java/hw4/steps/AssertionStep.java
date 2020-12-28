package hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import pages.hw3.ElementNameVisibility;

import java.util.List;

public class AssertionStep extends AbstractStep {
    SoftAssert softAssert = new SoftAssert();
    protected String[] keyWord = new String[4];

    public AssertionStep(WebDriver driver) {
        super(driver);
    }

    @Step("check that Home page is loaded")
    public void homePageLoaded() {
        softAssert.assertTrue(homePage.openPage());
    }

    @Step("check that browser title equals {title}")
    public void homePageTitleIsRelevant(String title) {
        softAssert.assertEquals(homePage.headTitleText(), title);
    }

    @Step("check that field User Name equals {user}")
    public void checkUserName(String user) {
        softAssert.assertEquals(homePage.getUserName(), user);
    }

    @Step("assert that there are 4 items on the header section are displayed and they have proper texts")
    public void checkFourHeaderElementsNameAndVisibility(String[] header) {
        int i = 0;
        for (ElementNameVisibility env : homePage.getHeaderMenu().listHeadersNameAndVisibility()) {
            softAssert.assertTrue(env.getVisible(), "element is not displayed");
            softAssert.assertEquals(env.getName(), header[i]);
            i++;
        }
    }

    @Step("assert that number of iFrames with Frame Button not less than one")
    public void checkFrameButtonIntoIframe() {
        softAssert.assertTrue(homePage.numberIframesWithFrameButton() > 0,
                "there is not frame with Frame Button");
    }

    @Step("assert that there is element Frame Button into iFrame")
    public void checkFrameButtonExist() {
        softAssert.assertTrue(homePage.frameButtonExist(),
                "there isn't element Frame Button");
    }

    @Step("assert that there are 5 items in the Left Section are displayed and they have proper text")
    public void checkFiveItemsFromLeftMenuForNameAndVisibility(String[] left) {
        int i = 0;
        for (ElementNameVisibility env : homePage.listOfLeftBlockTextAndVisibility()) {
            softAssert.assertTrue(env.getVisible(), "element is not displayed");
            softAssert.assertEquals(env.getName(), left[i]);
            i++;
        }
    }

    @Step("assert that there are 4 texts on the Index Page under icons and they have proper text")
    public void checkDescriptionUnderBenefitIconsAndVisibility() {
        int i;
        i = 0;
        for (ElementNameVisibility env : homePage.listOfBenefitDescTextAndVisibility()) {
            softAssert.assertTrue(env.getVisible(), "benefit-description under icor is not displayed");
            softAssert.assertTrue(env.getName().contains(keyWord[i]), "the text below Image doesn't contain the proper word");
            i++;
        }
    }

    @Step("assert that four images on Index page are displayed")
    public void checkBenefitIconVisibility() {
        int i = 0;
        for (ElementNameVisibility env : homePage.listOfPicturesTextAndVisibility()) {
            softAssert.assertTrue(env.getVisible(), "benefit-icon is not displayed");
            keyWord[i] = env.getName();
            i++;
        }
    }

    @Step("assertion for selected elements")
    public void checkSelectedElements(String s) {
        softAssert.assertTrue(serviceElementsPage.checkBoxSelected(0), "Water is not ticked");
        softAssert.assertTrue(serviceElementsPage.checkBoxSelected(2), "Wind is not ticked");
        softAssert.assertTrue(!serviceElementsPage.checkBoxSelected(1), "Earth is ticked");
        softAssert.assertTrue(!serviceElementsPage.checkBoxSelected(3), "Fire is ticked");
        softAssert.assertTrue(serviceElementsPage.radioSelected(3), "Selen is not selected");
        softAssert.assertEquals(serviceElementsPage.dropDownSelected(), s);
    }

    @Step("assert Log")
    public void checkLog(String[][] log) {
        List<WebElement> listLog = serviceElementsPage.getLogs();
        softAssert.assertEquals(listLog.size(), log.length);   //check number of items in Log
        for (int i = 0; i < log.length; i++) {
            int counterLog = listLog.size() - i - 1;
            boolean actualContElement = listLog.get(counterLog).getText().contains(log[i][0]);
            boolean actualContent;
            if (log[i][1].equals("cbox")) {
                actualContent = listLog.get(counterLog).getText().contains("condition changed to true");
            } else {
                actualContent = listLog.get(counterLog).getText().contains("value changed to");
            }
            softAssert.assertTrue(actualContElement && actualContent, "Log for defined element doesn't relevanl");
        }
    }

    public void totalAssert() {
        softAssert.assertAll();
    }

}
