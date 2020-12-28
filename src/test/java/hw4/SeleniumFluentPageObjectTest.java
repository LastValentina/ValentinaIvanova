package hw4;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class SeleniumFluentPageObjectTest extends AbstractBaseSeleniumTest {
    private final static String[][] ELEMENTS_TEST = {{"Water", "cbox"}, {"Wind", "cbox"}, {"Selen", "radio"}, {"Yellow", "dd"}};

    @Feature(value = "Service Elements Page Test")
    @Story(value = "check-box, radio, drop-down elements checking")
    @Test(description = "Check selection of elements & Log on DifferentElementsPage")
    public void exFluentPOTest() {
        actionStep.openHomePage();                                             //1. open site
        assertionStep.homePageTitleIsRelevant(title);                          //2. Browser title equals "Home Page"
        actionStep.login(login, pass);                                         //3. Perform login
        assertionStep.checkUserName(user);                                     //4. check user name on page after authorization
        actionStep.chooseMenuServicelements();                                  //5.Open through the header menu Service -> Different Elements Page
        actionStep.selectCheckBoxes(new int[]{1, 0, 1, 0});                     //6.Select checkboxes
        actionStep.selectRadio(3);                                         //7.Select radio
        actionStep.selectDropDown(ELEMENTS_TEST[3][0]);                        //8.Select in dropdown
        assertionStep.checkSelectedElements(ELEMENTS_TEST[3][0]);
        assertionStep.checkLog(ELEMENTS_TEST);                                  //9.Assert for Log
        assertionStep.totalAssert();
    }

}

