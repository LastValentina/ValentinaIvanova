package hw4.steps;

import org.openqa.selenium.WebDriver;
import pages.hw3.HomePage;
import pages.hw3.HomePageEx2;
import pages.hw3.ServiceElementsPage;

public class AbstractStep {
    HomePage homePage;
    HomePageEx2 homePageEx2;
    ServiceElementsPage serviceElementsPage;

    protected AbstractStep(WebDriver driver) {
        homePage = new HomePage(driver);
        serviceElementsPage = new ServiceElementsPage(driver);
        homePageEx2 = new HomePageEx2(driver);
    }

}
