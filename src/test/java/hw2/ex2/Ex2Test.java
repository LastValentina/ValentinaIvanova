package hw2.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Ex2Test {
    private WebDriver driver;

    @Test
    public void ex1Test() throws InterruptedException {
        String url = "https://jdi-testing.github.io/jdi-light/index.html";
        String login = "Roman";
        String pass = "Jdi1234";
        String user = "ROMAN IOVLEV";
        String[][] elementsTest = {{"Water", "cbox"}, {"Wind", "cbox"}, {"Selen", "radio"}, {"Yellow", "dd"}};

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
        driver.findElement(By.xpath("//input[@id='name' and @class='uui-form-element']")).sendKeys(login);
        driver.findElement(By.xpath("//input[@id='password' and @class='uui-form-element']")).sendKeys(pass);
        driver.findElement(By.xpath("//button[@id='login-button' and @class='uui-button dark-blue btn-login']")).click();

        //4. check user name on page after authorization
        softAssert.assertEquals(driver.findElement(By.xpath("//span[@id='user-name' and @ui='label']")).getText(), user);

        //5.Open through the header menu Service -> Different Elements Page
        WebElement el5 = driver.findElement(By.cssSelector("header div[class='uui-header dark-gray'"))
                .findElement(By.cssSelector("ul[class='uui-navigation nav navbar-nav m-l8'"));
        el5.findElement(By.cssSelector("a[class='dropdown-toggle']")).click();
        el5.findElement(By.cssSelector("ul[class='dropdown-menu']"))
                .findElement(By.xpath("//a[text()='Different elements']")).click();

        //6.Select checkboxes
        List<WebElement> chBox = driver.findElements(By.cssSelector("input[type='checkbox']"));
        chBox.get(0).click();
        softAssert.assertTrue(chBox.get(0).isSelected(), "Water is not ticked");
        chBox.get(2).click();
        softAssert.assertTrue(chBox.get(0).isSelected(), "Wind is not ticked");

        //7.Select radio
        WebElement radioBtn = driver.findElements(By.cssSelector("input[type='radio']")).get(3);
        radioBtn.click();
        softAssert.assertTrue(radioBtn.isSelected(), "Selen isn't selected");

        //8.Select in dropdown
        Select drp = new Select(driver.findElement(By.cssSelector("select[class='uui-form-element']")));
        drp.selectByVisibleText(elementsTest[3][0]);
        softAssert.assertEquals(drp.getFirstSelectedOption().getText(), elementsTest[3][0]);

        //9.Assert for Log
        List<WebElement> ls9 = driver.findElement(By.cssSelector("ul[class='panel-body-list logs']"))
                .findElements(By.tagName("li"));
        softAssert.assertEquals(ls9.size(), elementsTest.length); //check number of items in Log
        for (int i9 = 0; i9 < elementsTest.length; i9++) {
            int counterLog = ls9.size() - i9 - 1;
            boolean actualContElement = ls9.get(counterLog).getText().contains(elementsTest[i9][0]);
            boolean actualContent;
            if (elementsTest[i9][1].equals("cbox")) {
                actualContent = ls9.get(counterLog).getText().contains("condition changed to true");
            } else {
                actualContent = ls9.get(counterLog).getText().contains("value changed to");
            }
            softAssert.assertTrue(actualContElement & actualContent, "Log for defined element doesn't relevanl");
        }
        softAssert.assertAll();

        //10. Close Browser
        driver.quit();
    }

}
