package hw3.ex2;

import hw3.AbstractBaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.hw3.HomePageEx2;
import pages.hw3.ServiceElementsPage;

import java.util.List;

public class Ex2Test extends AbstractBaseTest {
    protected final static String[][] elementsTest = {{"Water", "cbox"}, {"Wind", "cbox"}, {"Selen", "radio"}, {"Yellow", "dd"}};

    @Test
    protected void loginTest() {
        SoftAssert softAssert = new SoftAssert();
        HomePageEx2 homePageEx2 = new HomePageEx2(driver)
                .openPage()                                         //1. open site
                .login(login, pass);                                //3. Perform login

        softAssert.assertEquals(homePageEx2.getTitle(), title);     //2. Browser title equals "Home Page"
        softAssert.assertEquals(homePageEx2.getUsername(), user);   //4. check user name on page after authorization

        ServiceElementsPage serviceElementsPage =
                homePageEx2.clickServiceElementsPage();             //5.Open through the header menu Service -> Different Elements Page
        serviceElementsPage.ClickCheckBox(0)                        //6.Select checkboxes
                .ClickCheckBox(2)
                .ClickRadio(3)                                      //7.Select radio
                .SelectFromDropDown(elementsTest[3][0]);            //8.Select in dropdown

        softAssert.assertTrue(serviceElementsPage.CheckBoxSelected(0), "Water is not ticked");
        softAssert.assertTrue(serviceElementsPage.CheckBoxSelected(2), "Wind is not ticked");
        softAssert.assertTrue(!serviceElementsPage.CheckBoxSelected(1), "Earth is ticked");
        softAssert.assertTrue(!serviceElementsPage.CheckBoxSelected(3), "Fire is ticked");
        softAssert.assertTrue(serviceElementsPage.RadioSelected(3), "Selen is not selected");
        softAssert.assertEquals(serviceElementsPage.DropDownSelected(), elementsTest[3][0]);

        //9.Assert for Log
        List<WebElement> listLog = serviceElementsPage.getLogs();
        softAssert.assertEquals(listLog.size(), elementsTest.length);   //check number of items in Log
        for (int i = 0; i < elementsTest.length; i++) {
            int counterLog = listLog.size() - i - 1;
            boolean actualContElement = listLog.get(counterLog).getText().contains(elementsTest[i][0]);
            boolean actualContent;
            if (elementsTest[i][1].equals("cbox")) {
                actualContent = listLog.get(counterLog).getText().contains("condition changed to true");
            } else {
                actualContent = listLog.get(counterLog).getText().contains("value changed to");
            }
            softAssert.assertTrue(actualContElement && actualContent, "Log for defined element doesn't relevanl");
        }
        softAssert.assertAll();
    }
}

