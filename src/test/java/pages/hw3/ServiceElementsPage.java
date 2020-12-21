package pages.hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ServiceElementsPage extends AbstractPage {
    //   private HeaderMenu headerMenu;
    @FindBy(css = "input[type=checkbox]")
    private List<WebElement> chBoxs;
    @FindBy(css = "input[type=radio]")
    private List<WebElement> radioBtn;
    @FindBy(css = "select.uui-form-element")
    private WebElement dropDowhList;
    @FindBy(css = "ul.panel-body-list.logs li")
    private List<WebElement> logs;

    public ServiceElementsPage(WebDriver driver) {
        super(driver);
    }

    public ServiceElementsPage ClickCheckBox(int k) {
        chBoxs.get(k).click();
        return this;
    }

    public boolean CheckBoxSelected(int k) {
        return chBoxs.get(k).isSelected();
    }

    public ServiceElementsPage ClickRadio(int k) {
        radioBtn.get(k).click();
        return this;
    }

    public boolean RadioSelected(int k) {
        return radioBtn.get(k).isSelected();
    }

    public ServiceElementsPage SelectFromDropDown(String color) {
        //       Select drp=new Select(dropDowhList);
        //       drp.selectByVisibleText(color);
        new Select(dropDowhList).selectByVisibleText(color);
        return this;
    }

    public String DropDownSelected() {
        return new Select(dropDowhList).getFirstSelectedOption().getText();
    }

    public List<WebElement> getLogs() {
        return logs;
    }

}
