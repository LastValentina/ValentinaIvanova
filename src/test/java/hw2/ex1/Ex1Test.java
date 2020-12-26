package hw2.ex1;

import hw2.LoginTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Ex1Test extends LoginTest {
    final String[] header = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
    final String[] left = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
    protected String[] keyWord = new String[4];

    @Test
    public void ex1Test() {

        loginTest();

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> lsHeader = driver.findElements(By.cssSelector("ul.uui-navigation.nav.navbar-nav.m-l8 li"));
        for (int i = 0; i < 3; i++) {
            String actualText = lsHeader.get(i).getText();
            softAssert.assertEquals(actualText, header[i]);  //5.1# check 1-3 items of header
        }
        String actText = driver.findElement(By.cssSelector("ul.uui-navigation.nav.navbar-nav.m-l8 [href='metals-colors.html']"))
                .getText();
        softAssert.assertEquals(actText, header[3]);  //5.2# check 4th items of header

        //6. four images on Index page are displayed
        List<WebElement> listBenefitIcons = driver.findElements
                (By.cssSelector("div.row.clerafix.benefits span.icons-benefit"));
        for (int i = 0; i < 4; i++) {
            softAssert.assertTrue(listBenefitIcons.get(i).isDisplayed(), "Image on Index page is not displayed");
            keyWord[i] = (listBenefitIcons.get(i).getAttribute("class")).substring(19); // key-words for step7
        }

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        // text would be compared with array keyWord - see step6
        List<WebElement> listBenefitDesc = driver.findElements(By.cssSelector("div.row.clerafix.benefits span.benefit-txt"));
        for (int i = 0; i < 4; i++) {
            softAssert.assertTrue(listBenefitDesc.get(i).isDisplayed(), "the text below Image is not displayed");
            if (i == 0) {
                continue;
            }
            String textBelowImage = listBenefitDesc.get(i).getAttribute("innerHTML");
            softAssert.assertTrue(textBelowImage.contains(keyWord[i]), "the text below Image doesn't contain the proper word");
        }

        //8.Assert that there is the iframe with “Frame Button” exist
        List<WebElement> listIframes = driver.findElements(By.tagName("iframe"));
        int counterFramesWithFrameButton = 0;
        for (int i = 0; i < listIframes.size(); i++) {
            driver.switchTo().frame(i);
            List<WebElement> listElementsWithFrameButtonValue = driver.findElements(By.cssSelector("[value='Frame Button']"));
            if (listElementsWithFrameButtonValue.size() > 0) {
                counterFramesWithFrameButton++;
            }
            driver.switchTo().defaultContent();
        }
        softAssert.assertTrue(counterFramesWithFrameButton > 0, "there is not frame with Frame Button");

        //9.Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");
        List<WebElement> listFButton = driver.findElements(By.cssSelector("[value='Frame Button']"));
        softAssert.assertEquals(listFButton.size(), 1);

        //10.Switch to original window back
        driver.switchTo().defaultContent();

        //11.Assert that there are 5 items in the Left Section are displayed and they have proper text
        WebElement elSideberMenu = driver.findElement(By.cssSelector("ul.sidebar-menu"));
        for (String s : left) {
            String locatorSearchElementLeftSection = "//span[text()='" + s + "']";
            List<WebElement> searchElementLeftSection = elSideberMenu.findElements(By.xpath(locatorSearchElementLeftSection));
            softAssert.assertEquals(searchElementLeftSection.size(), 1);
        }
        softAssert.assertAll();
    }
}
