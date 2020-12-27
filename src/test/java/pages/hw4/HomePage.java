package pages.hw4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.hw3.AbstractPage;
import pages.hw3.ElementNameVisibility;
import pages.hw3.HeaderMenu;
import pages.hw3.ServiceElementsPage;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AbstractPage {
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
    @FindBy(css = "div.row.clerafix.benefits span.icons-benefit")
    private List<WebElement> listBenefitIcons;
    @FindBy(css = "div.row.clerafix.benefits span.benefit-txt")
    private List<WebElement> listBenefitDesc;
    @FindBy(tagName = "iframe")
    private List<WebElement> listIframes;
    @FindBy(css = "input[value='Frame Button']")
    private List<WebElement> frameButton;
    @FindBy(css = "ul.sidebar-menu>li>a>span")  //(xpath = "//ul[@class='sidebar-menu']/li/a/span")
    private List<WebElement> sideBarMenu;
    @FindBy(css = "span.login-txt")
    private WebElement wrongLogin;

    public HomePage(WebDriver driver) {
        super(driver);
        headerMenu = new HeaderMenu(driver);
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public boolean openPage() {
        driver.get(homeUrl);
        waitClicableElement(userIcon);
        return true;
    }

    public void clickUserIcon() {
        userIcon.click();
        waitVisibleElement(login);
    }

    public void login(String name, String password) {
        login.sendKeys(name);
        this.password.sendKeys(password);
        loginButton.click();
//        waitVisibleElement(userName);
    }

    public void differentLogin(String name, String password) {
        login.clear();
        login.sendKeys(name);
        this.password.clear();
        this.password.sendKeys(password);
        loginButton.click();
    }


    public void clearLoginField() {
        login.clear();
    }

    public String getUserName() {
        return userName.getText();
    }

    public String headTitleText() {
        return driver.getTitle();
    }

    public List<ElementNameVisibility> listOfPicturesTextAndVisibility() {
        List<ElementNameVisibility> list = new ArrayList<>();
        list.add(new ElementNameVisibility(listBenefitIcons.get(0).getAttribute("class").substring(19, 25),
                listBenefitIcons.get(0).isDisplayed()));
        for (int i = 1; i < 4; i++) {
            list.add(new ElementNameVisibility(listBenefitIcons.get(i).getAttribute("class").substring(19),
                    listBenefitIcons.get(i).isDisplayed()));
        }
        return list;
    }

    public List<ElementNameVisibility> listOfBenefitDescTextAndVisibility() {
        List<ElementNameVisibility> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(new ElementNameVisibility(listBenefitDesc.get(i).getAttribute("innerHTML"),
                    listBenefitDesc.get(i).isDisplayed()));
        }
        return list;
    }

    public int numberIframesWithFrameButton() {
        int counterFramesWithFrameButton = 0;
        for (int i = 0; i < listIframes.size(); i++) {
            driver.switchTo().frame(i);
            if (frameButton.size() > 0) {
                counterFramesWithFrameButton++;
            }
            switchBackFromFrame();
        }
        return counterFramesWithFrameButton;
    }

    public boolean frameButtonExist() {
        driver.switchTo().frame("frame");
        return frameButton.get(0).isEnabled();
    }

    public void switchBackFromFrame() {
        driver.switchTo().defaultContent();
    }

    public List<ElementNameVisibility> listOfLeftBlockTextAndVisibility() {
        List<ElementNameVisibility> listLeftMenu = new ArrayList<>();
        for (WebElement el : sideBarMenu) {
            listLeftMenu.add(new ElementNameVisibility(el.getText(), el.isDisplayed()));
        }
        return listLeftMenu;
    }

    public boolean loginTxtVisibility() {
        return wrongLogin.isDisplayed();
    }

    public ServiceElementsPage clickServiceElementsPage() {
        getHeaderMenu().getListHeaders().get(2).click();
        getHeaderMenu().getListMenuService().get(7).click();
        return new ServiceElementsPage(driver);
    }
}
