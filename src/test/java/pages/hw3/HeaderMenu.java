package pages.hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HeaderMenu extends AbstractPage {
    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8>li>a")
    private List<WebElement> listFourHeaders;
    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8 ul.dropdown-menu>li>a")
    private List<WebElement> listMenuService;

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public List<ElementNameVisibility> listHeadersNameAndVisibility() {
        List<ElementNameVisibility> lsthead = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            lsthead.add(new ElementNameVisibility(listFourHeaders.get(i).getText(),
                    listFourHeaders.get(i).isDisplayed()));
        }
        return lsthead;
    }

    public String getHeader1Name() {
        return listFourHeaders.get(0).getText();
    }

    public List<WebElement> getListHeaders() {
        return listFourHeaders;
    }

    public List<WebElement> getListMenuService() {
        return listMenuService;
    }

    public void clickButtonByName(String button) {
        switch (button) {
            case "Home": {
                listFourHeaders.get(0).click();
                break;
            }
            case "Contact Form": {
                listFourHeaders.get(1).click();
                break;
            }
            case "Service": {
                listFourHeaders.get(2).click();
                break;
            }
            case "Metals & Colors": {
                listFourHeaders.get(3).click();
                break;
            }
        }
    }

    public void clickButtonByNameInMenuService(String button) {
        switch (button) {
            case "Support":
                listMenuService.get(0).click();
                break;
            case "Dates":
                listMenuService.get(1).click();
                break;
            case "Search":
                listMenuService.get(2).click();
                break;
            case "Complex Table":
                listMenuService.get(3).click();
                break;
            case "Simple Table":
                listMenuService.get(4).click();
                break;
            case "User Table":
                listMenuService.get(5).click();
                break;
            case "Table with pages":
                listMenuService.get(6).click();
                break;
            case "Different Elements":
                listMenuService.get(7).click();
                break;
            case "Performance":
                listMenuService.get(8).click();
                break;
        }
    }
}
