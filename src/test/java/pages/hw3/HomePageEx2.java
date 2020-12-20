package pages.hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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

    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']/li/a")
    private List<WebElement> listHeaders;


    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']//ul[@class='dropdown-menu']/li/a")
    private List<WebElement> listMenuService;


    public HomePageEx2(WebDriver driver) {
        super(driver);
        //   headerMenu = new HeaderMenu();
    }

//    public HeaderMenu getHeaderMenu() {return headerMenu;}

    public HomePageEx2 openPage() {
        driver.get(homeUrl);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(userIcon));
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
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(login));
        login.sendKeys(name);
        this.password.sendKeys(password);
        loginButton.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(userName));
        return this;
    }

    public ServiceElementsPage clickServiceElementsPage() {
        listHeaders.get(2).click();
        listMenuService.get(7).click();
        return new ServiceElementsPage(driver);
    }

}
