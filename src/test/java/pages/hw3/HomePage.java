package pages.hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    @FindBy(xpath = "//ul[@class='sidebar-menu']/li/a/span")
    private List<WebElement> sideBarMenu;

    public HomePage(WebDriver driver) {
        super(driver);
        headerMenu = new HeaderMenu(driver);
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public boolean openPage() {
        driver.get(homeUrl);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(userIcon));
        return true;
    }

    public String login(String name, String password) {
        userIcon.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(login));
        login.sendKeys(name);
        this.password.sendKeys(password);
        loginButton.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(userName));
        return userName.getText();
    }

    public String headTitleText() {
        return driver.getTitle();
    }

    public List<ElementNameVisibility> listOfPicturesTextAndVisibility() {
        List<ElementNameVisibility> list = new ArrayList<>();

        list.add(new ElementNameVisibility(listBenefitIcons.get(0).getAttribute("class").substring(19, 25),
                listBenefitIcons.get(0).isDisplayed()));
        list.add(new ElementNameVisibility(listBenefitIcons.get(1).getAttribute("class").substring(19),
                listBenefitIcons.get(1).isDisplayed()));
        list.add(new ElementNameVisibility(listBenefitIcons.get(2).getAttribute("class").substring(19),
                listBenefitIcons.get(2).isDisplayed()));
        list.add(new ElementNameVisibility(listBenefitIcons.get(3).getAttribute("class").substring(19),
                listBenefitIcons.get(3).isDisplayed()));
        return list;
    }

    public List<ElementNameVisibility> listOfBenefitDescTextAndVisibility() {
        List<ElementNameVisibility> list = new ArrayList<>();

        list.add(new ElementNameVisibility(listBenefitDesc.get(0).getAttribute("innerHTML"),
                listBenefitDesc.get(0).isDisplayed()));
        list.add(new ElementNameVisibility(listBenefitDesc.get(1).getAttribute("innerHTML"),
                listBenefitDesc.get(1).isDisplayed()));
        list.add(new ElementNameVisibility(listBenefitDesc.get(2).getAttribute("innerHTML"),
                listBenefitDesc.get(2).isDisplayed()));
        list.add(new ElementNameVisibility(listBenefitDesc.get(3).getAttribute("innerHTML"),
                listBenefitDesc.get(3).isDisplayed()));
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

}
