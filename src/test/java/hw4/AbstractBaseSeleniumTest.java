package hw4;

import hw3.DriverManager;
import hw4.steps.ActionStep;
import hw4.steps.AssertionStep;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class AbstractBaseSeleniumTest {
    protected WebDriver driver;
    protected String login;
    protected String pass;
    protected String user;
    protected String title;
    protected String wrongpass;
    ActionStep actionStep;
    AssertionStep assertionStep;

    @BeforeClass
    public void setUp(ITestContext testContext) {

        Properties property = new Properties();
        String fileName = "hw3/loginPage.properties";
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
             InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {
            property.load(reader);
            login = property.getProperty("site.login");
            pass = property.getProperty("site.password");
            user = property.getProperty("site.user");
            title = property.getProperty("site.title");
            wrongpass = property.getProperty("site.wrongpass");
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver = DriverManager.getChromeDriver();
        actionStep = new ActionStep(driver);
        assertionStep = new AssertionStep(driver);
        testContext.setAttribute("driver", driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
