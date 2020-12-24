package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManagerSingle {
    private static WebDriver driver;

    public static synchronized WebDriver getWebDriverInstance() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static void closeWebDriver() {
        if (driver != null) {
            driver.quit();
        }
        driver = null;
    }

}
