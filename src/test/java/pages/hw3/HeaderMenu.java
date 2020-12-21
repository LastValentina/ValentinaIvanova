package pages.hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HeaderMenu extends AbstractPage {
    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']/li/a")
    private List<WebElement> listFourHeaders;
    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']//ul[@class='dropdown-menu']/li/a")
    private List<WebElement> listMenuService;

    public HeaderMenu(WebDriver driver) {
        super(driver);
    }

    public List<ElementNameVisibility> listHeadersNameAndVisibility() {
        List<ElementNameVisibility> lsthead = new ArrayList<>();
        lsthead.add(new ElementNameVisibility(listFourHeaders.get(0).getText(),
                listFourHeaders.get(0).isDisplayed()));
        lsthead.add(new ElementNameVisibility(listFourHeaders.get(1).getText(),
                listFourHeaders.get(1).isDisplayed()));
        lsthead.add(new ElementNameVisibility(listFourHeaders.get(2).getText(),
                listFourHeaders.get(2).isDisplayed()));
        lsthead.add(new ElementNameVisibility(listFourHeaders.get(3).getText(),
                listFourHeaders.get(3).isDisplayed()));
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
