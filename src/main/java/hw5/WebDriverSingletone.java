package hw5;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class WebDriverSingletone {

    private static WebDriver driver;

    private WebDriverSingletone() {
    }

    public static WebDriver getDriver() {
        String browserName = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");
        if (Objects.isNull(driver)) {
            driver = WebDriverFactory.createWebDriver();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }

}