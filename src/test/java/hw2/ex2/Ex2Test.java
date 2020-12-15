package hw2.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Ex2Test {
    private WebDriver driver;
    String url = "https://jdi-testing.github.io/jdi-light/index.html";
    String url2 = "https://jdi-testing.github.io/jdi-light/different-elements.html";
    String login = "Roman";
    String pass = "Jdi1234";
    String user = "ROMAN IOVLEV";
    String[][] elementsTest = {{"Water", "cbox"}, {"Wind", "cbox"}, {"Selen", "radio"}, {"Yellow", "dd"}};

    @BeforeTest
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

        //5.Open through the header menu Service -> Different Elements Page
        WebElement elNavbar = driver.findElement(By.cssSelector("header div.uui-header.dark-gray ul.uui-navigation.nav.navbar-nav.m-l8"));
        elNavbar.findElement(By.cssSelector("a.dropdown-toggle")).click();
        elNavbar.findElement(By.cssSelector("ul.dropdown-menu"))
                .findElement(By.xpath("//a[text()='Different elements']")).click();
        softAssert.assertEquals(driver.getCurrentUrl(), url2); //Page is opened

        //6.Select checkboxes
        List<WebElement> chBox = driver.findElements(By.cssSelector("input[type=checkbox]"));
        chBox.get(0).click();
        softAssert.assertTrue(chBox.get(0).isSelected(), "Water is not ticked");
        chBox.get(2).click();
        softAssert.assertTrue(chBox.get(2).isSelected(), "Wind is not ticked");

        //7.Select radio
        WebElement radioBtn = driver.findElements(By.cssSelector("input[type=radio]")).get(3);
        radioBtn.click();
        softAssert.assertTrue(radioBtn.isSelected(), "Selen isn't selected");

        //8.Select in dropdown
        Select drp = new Select(driver.findElement(By.cssSelector("select.uui-form-element")));
        drp.selectByVisibleText(elementsTest[3][0]);
        softAssert.assertEquals(drp.getFirstSelectedOption().getText(), elementsTest[3][0]);

        //9.Assert for Log
        List<WebElement> listLog = driver.findElement(By.cssSelector("ul.panel-body-list.logs"))
                .findElements(By.tagName("li"));
        softAssert.assertEquals(listLog.size(), elementsTest.length); //check number of items in Log
        for (int i = 0; i < elementsTest.length; i++) {
            int counterLog = listLog.size() - i - 1;
            boolean actualContElement = listLog.get(counterLog).getText().contains(elementsTest[i][0]);
            boolean actualContent;
            if (elementsTest[i][1].equals("cbox")) {
                actualContent = listLog.get(counterLog).getText().contains("condition changed to true");
            } else {
                actualContent = listLog.get(counterLog).getText().contains("value changed to");
            }
            softAssert.assertTrue(actualContElement & actualContent, "Log for defined element doesn't relevanl");
        }
        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown() {
        //10. Close Browser
        driver.quit();
    }
}
