package pages.hw3;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HeaderMenu {
    //   WebDriver driver;
    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8 li")
    private List<WebElement> preliminaryListHeaders;
    @FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8 [href='metals-colors.html']")
    private WebElement header4;

    public List<ElementNameVisibility> listOfHeadersTextAndVisibility() {
        WebElement header1 = preliminaryListHeaders.get(0);
        WebElement header2 = preliminaryListHeaders.get(1);
        WebElement header3 = preliminaryListHeaders.get(2);

        List<ElementNameVisibility> listHeaderCondition = new ArrayList<>();
        listHeaderCondition.add(new ElementNameVisibility(header1.getText(), header1.isDisplayed()));
        listHeaderCondition.add(new ElementNameVisibility(header2.getText(), header2.isDisplayed()));
        listHeaderCondition.add(new ElementNameVisibility(header3.getText(), header3.isDisplayed()));
        listHeaderCondition.add(new ElementNameVisibility(header4.getText(), header4.isDisplayed()));

        return listHeaderCondition;
    }

    public String getTest() {
        return header4.getText();
    }

}
