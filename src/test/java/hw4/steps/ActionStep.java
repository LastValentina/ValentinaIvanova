package hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ActionStep extends AbstractStep {

    public ActionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Open home page JDI-testing")
    public void openHomePage() {
        homePage.openPage();
    }

    @Step("perform login with login={login} and password={pass}")
    public void login(String login, String pass) {
        homePage.clickUserIcon();
        homePage.login(login, pass);
        homePage.waitElementUserName();
    }

    @Step("switch from Frame back to Index page")
    public void swichFromFrame() {
        homePage.switchBackFromFrame();
    }

    @Step("open through the header menu Service -> Different Elements Page")
    public void chooseMenuServicelements() {
        homePage.clickServiceElementsPage()
                .waitLoadPage();
    }

    @Step("select items into check-boxes")
    public void selectCheckBoxes(int[] box) {
        for (int i = 0; i < box.length; i++) {
            if (box[i] == 1) {
                serviceElementsPage.clickCheckBox(i);
            }
        }
    }

    @Step("select radio-button number {i}")
    public void selectRadio(int i) {
        serviceElementsPage.clickRadio(i);
    }

    @Step("select {item} in dropdown ")
    public void selectDropDown(String item) {
        serviceElementsPage.selectFromDropDown(item);
    }

    @Step("open home page and login")
    public void loginFluent(String login, String pass) {
        homePageEx2
                .openPage()
                .login(login, pass);
    }

    @Step("perform login")
    public void loginN(String login, String pass) {
        homePage.clickUserIcon();
        homePage.login(login, pass);
        homePage.waitElementLoginFaild();
    }
}
