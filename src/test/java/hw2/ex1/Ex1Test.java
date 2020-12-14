package hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Ex1Test {
    private WebDriver driver;

    @Test
    public void ex1Test() throws InterruptedException {
        String url = "https://jdi-testing.github.io/jdi-light/index.html";
        String login = "Roman";
        String pass = "Jdi1234";
        String user = "ROMAN IOVLEV";
        String[] header = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
        String[] left = {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};

        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

        //1. open site
        driver.get(url);
        softAssert.assertEquals(driver.getCurrentUrl(), url);

        //2. Browser title equals "Home Page"
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //3. Perform login
        driver.findElement(By.cssSelector("header div[class='uui-header dark-gray'"))
                .findElement(By.cssSelector("ul[class='uui-navigation navbar-nav navbar-right'"))
                .findElement(By.cssSelector("a[class='dropdown-toggle']"))
                .click();
        driver.findElement(By.xpath("//input[@id='name' and @class='uui-form-element']"))
                .sendKeys(login);
        driver.findElement(By.xpath("//input[@id='password' and @class='uui-form-element']"))
                .sendKeys(pass);
        driver.findElement(By.xpath("//button[@id='login-button' and @class='uui-button dark-blue btn-login']"))
                .click();

        //4. check user name on page after authorization
        softAssert.assertEquals(driver.findElement(By.xpath("//span[@id='user-name' and @ui='label']")).getText(), user);

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> lsHeader = driver.findElement(By.cssSelector("ul[class='uui-navigation nav navbar-nav m-l8']"))
                .findElements(By.cssSelector("li"));
        for (int i = 0; i < 3; i++) {
            String actualText = lsHeader.get(i).getText();
            softAssert.assertEquals(actualText, header[i]);  //5.1# check 1-3 items of header
        }
        String actText = driver.findElement(By.cssSelector("ul[class='uui-navigation nav navbar-nav m-l8']"))
                .findElement(By.cssSelector("[href='metals-colors.html']")).getText();
        softAssert.assertEquals(actText, header[3]);  //5.2# check 4th items of header

        //6. four images on Index page are displayed
        String keyWord[] = new String[4];
        List<WebElement> ls6 = driver.findElement(By.cssSelector("div[class='row clerafix benefits'"))
                .findElements(By.cssSelector("span[class*='icons-benefit']"));
        for (int i6 = 0; i6 < 4; i6++) {
            softAssert.assertTrue(ls6.get(i6).isDisplayed(), "Image on Index page is not displayed");
            keyWord[i6] = (ls6.get(i6).getAttribute("class")).substring(19); // key-words for step7
        }

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper textAssert that there are 4 texts on the Index Page under icons and they have proper text
        // text would be compared with array keyWord - see step6
        List<WebElement> ls7 = driver.findElement(By.cssSelector("div[class='row clerafix benefits'"))
                .findElements(By.cssSelector("span[class='benefit-txt']"));
        for (int i7 = 0; i7 < 4; i7++) {
            softAssert.assertTrue(ls7.get(i7).isDisplayed(), "the text below Image is not displayed");
            if (i7 == 0) {
                continue;
            }
            String textBelowImage = ls7.get(i7).getAttribute("innerHTML");
            boolean checkProperText = textBelowImage.contains(keyWord[i7]);
            softAssert.assertTrue(checkProperText, "the text below Image doesn't contain the proper word");
        }

        //8.Assert that there is the iframe with “Frame Button” exist
        List<WebElement> ls8 = driver.findElements(By.tagName("iframe"));
        int counterFramesWithFrameButton = 0;
        for (int i8 = 0; i8 < ls8.size(); i8++) {
            driver.switchTo().frame(i8);
            List<WebElement> ls8_2 = driver.findElements(By.cssSelector("[value='Frame Button']"));
            if (ls8_2.size() > 0) {
                counterFramesWithFrameButton++;
            }
            driver.switchTo().defaultContent();
        }
        softAssert.assertTrue(counterFramesWithFrameButton > 0, "there is not frame with Frame Button");

        //9.Switch to the iframe and check that there is “Frame Button” in the iframe
        driver.switchTo().frame("frame");
        List<WebElement> ls9 = driver.findElements(By.cssSelector("[value='Frame Button']"));
        softAssert.assertEquals(ls9.size(), 1);

        //10.Switch to original window back
        driver.switchTo().defaultContent();

        //11.Assert that there are 5 items in the Left Section are displayed and they have proper text
        WebElement el11 = driver.findElement(By.cssSelector("ul[class='sidebar-menu'"));
        for (int i11 = 0; i11 < left.length; i11++) {
            String path11 = "//span[text()=" + "\'" + left[i11] + "\'" + "]";
            List<WebElement> actualEl11 = el11.findElements(By.xpath(path11));
            softAssert.assertEquals(actualEl11.size(), 1);
        }
        softAssert.assertAll();

        //12. Close Browser
        driver.quit();
    }

}
