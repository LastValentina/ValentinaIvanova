package hw3;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class AbstractBaseTest {
    public WebDriver driver;
    protected String login;
    protected String pass;
    protected String user;
    protected String title;
    protected String wrongpass;

    @BeforeClass
    public void setUp() {
        Properties property = new Properties();
        String fileName = "hw3/loginPage.properties";

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
             InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {
            property.load(reader);
            login = property.getProperty("field.login");
            pass = property.getProperty("field.password");
            user = property.getProperty("field.user");
            title = property.getProperty("field.title");
            wrongpass = property.getProperty("field.wrongpass");
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver = new DriverManager().getDriver();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();      //12. Close Browser
    }
}
