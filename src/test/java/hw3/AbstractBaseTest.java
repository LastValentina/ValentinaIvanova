package hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AbstractBaseTest {
    protected WebDriver driver;
    protected String login;
    protected String pass;
    protected String user;
    protected String title;

    @BeforeClass
    public void setUpLogin() {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/test/resources/hw3/loginPage.properties");
            property.load(fis);
            login = property.getProperty("field.login");
            pass = property.getProperty("field.password");
            user = property.getProperty("field.user");
            title = property.getProperty("field.title");
        } catch (IOException e) {
            System.err.println("Please check properties file");
        }

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();              //12. Close Browser
    }

}
