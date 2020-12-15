package hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Ex1Test {
    WebDriver driver;
    String url = "https://jdi-testing.github.io/jdi-light/index.html";
    String login = "Roman";
    String pass = "Jdi1234";
    String user = "ROMAN IOVLEV";
    String[] header = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
    String[] left = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
    String[] keyWord = new String[4];

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
    }

    @Test
    public void ex1Test() {
        SoftAssert softAssert = new SoftAssert();
        //1. open site
        driver.get(url);
        softAssert.assertEquals(driver.getCurrentUrl(), url);

        //2. Browser title equals "Home Page"
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //3. Perform login
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys(login);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.id("login-button")).click();

        //4. check user name on page after authorization
        softAssert.assertEquals(driver.findElement(By.id("user-name")).getText(), user);

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
                (By.cssSelector("div.row.clerafix.benefits span[class~=icons-benefit]"));
        for (int i = 0; i < 4; i++) {
            softAssert.assertTrue(listBenefitIcons.get(i).isDisplayed(), "Image on Index page is not displayed");
            keyWord[i] = (listBenefitIcons.get(i).getAttribute("class")).substring(19); // key-words for step7
        }

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper textAssert that there are 4 texts on the Index Page under icons and they have proper text
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
            String locatorSearchElementLeftSection = "//span[text()=" + "\'" + s + "\'" + "]";
            List<WebElement> searchElementLeftSection = elSideberMenu.findElements(By.xpath(locatorSearchElementLeftSection));
            softAssert.assertEquals(searchElementLeftSection.size(), 1);
        }
        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown() {
        //12. Close Browser
        driver.quit();
    }
}
