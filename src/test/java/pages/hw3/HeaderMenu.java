package pages.hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HeaderMenu extends AbstractPage {
    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8>li>a")
    private List<WebElement> listFourHeaders;
    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']//ul[@class='dropdown-menu']/li/a")
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

}
