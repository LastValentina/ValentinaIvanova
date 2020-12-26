package pages.hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageEx2 extends AbstractPage {
    private static final String homeUrl = "https://jdi-testing.github.io/jdi-light/index.html";
    private HeaderMenu headerMenu;
    @FindBy(id = "user-icon")
    private WebElement userIcon;
    @FindBy(id = "name")
    private WebElement login;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(id = "user-name")
    private WebElement userName;

    public HomePageEx2(WebDriver driver) {
        super(driver);
        headerMenu = new HeaderMenu(driver);
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public HomePageEx2 openPage() {
        driver.get(homeUrl);
        waitClicableElement(userIcon);
        return this;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getUsername() {
        return userName.getText();
    }

    public HomePageEx2 login(String name, String password) {
        userIcon.click();
        waitVisibleElement(login);
        login.sendKeys(name);
        this.password.sendKeys(password);
        loginButton.click();
        waitVisibleElement(userName);
        return this;
    }

    public ServiceElementsPage clickServiceElementsPage() {
        getHeaderMenu().getListHeaders().get(2).click();
        getHeaderMenu().getListMenuService().get(7).click();
        return new ServiceElementsPage(driver);
    }

}
