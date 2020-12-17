package hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.util.List;

public abstract class LoginTest {
    protected WebDriver driver;
    protected SoftAssert softAssert = new SoftAssert();
    final static String url = "https://jdi-testing.github.io/jdi-light/index.html";
    final static String login = "Roman";
    final static String pass = "Jdi1234";
    final static String user = "ROMAN IOVLEV";

    @BeforeClass
    public void setUpLogin() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
    }

    @AfterClass
    public void tearDown() {
        //12. Close Browser
        driver.quit();
    }

    protected void loginTest() {
        //1. open site
        driver.get(url);
        softAssert.assertEquals(driver.getCurrentUrl(), url);

        //2. Browser title equals "Home Page"
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //3. Perform login
        waitClicableElement(driver, By.id("user-icon")).click();
        waitPresenceElement(driver, By.id("name")).sendKeys(login);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.id("login-button")).click();

        //4. check user name on page after authorization
        softAssert.assertEquals(waitPresenceElement(driver, By.id("user-name")).getText(), user);
    }

    protected WebElement waitClicableElement(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    protected WebElement waitPresenceElement(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected List<WebElement> waitPresenceAllElements(WebDriver driver, By by) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
}
