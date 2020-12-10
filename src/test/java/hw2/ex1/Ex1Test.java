package hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class Ex1Test {
    @Test
    public void ex1Test() throws InterruptedException {
        String url="https://jdi-testing.github.io/jdi-light/index.html";
        String username="Roman";
        String pass="Jdi1234";

        SoftAssert softAssert=new SoftAssert();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.MILLISECONDS);
        driver.get(url);
        //Browser title equals "Home Page"

        WebElement actualElement=driver.findElement(By.name("main-title"));
        softAssert.assertEquals(actualElement.getText(),"EPAM framework Wishes…");


//        softAssert.assertEquals(actual,expected,delta);
         softAssert.assertAll();
        Thread.sleep(2000);
        driver.quit();
    }
}
