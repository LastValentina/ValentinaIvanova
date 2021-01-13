package hw5.steps;

import hw5.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import pages.hw3.HomePage;
import pages.hw3.ServiceElementsPage;
import pages.hw3.ServiceUserTablePage;

public class AbstractStepDef {
    HomePage homePage;
    ServiceElementsPage serviceElementsPage;
    ServiceUserTablePage serviceUserTablePage;

    protected AbstractStepDef() {
        WebDriver driver = WebDriverSingleton.getDriver();
        homePage = new HomePage(driver);
        serviceElementsPage = new ServiceElementsPage(driver);
        serviceUserTablePage = new ServiceUserTablePage(driver);
    }

}
