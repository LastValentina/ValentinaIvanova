package pages.hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ServiceElementsPage extends AbstractPage {
    private HeaderMenu headerMenu;
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
        headerMenu = new HeaderMenu(driver);
    }

    public ServiceElementsPage clickCheckBox(int k) {
        chBoxs.get(k).click();
        return this;
    }

    public boolean checkBoxSelected(int k) {
        return chBoxs.get(k).isSelected();
    }

    public ServiceElementsPage clickRadio(int k) {
        radioBtn.get(k).click();
        return this;
    }

    public boolean radioSelected(int k) {
        return radioBtn.get(k).isSelected();
    }

    public ServiceElementsPage selectFromDropDown(String color) {
        new Select(dropDowhList).selectByVisibleText(color);
        return this;
    }

    public String dropDownSelected() {
        return new Select(dropDowhList).getFirstSelectedOption().getText();
    }

    public List<WebElement> getLogs() {
        return logs;
    }

    public ServiceElementsPage waitLoadPage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfAllElements(chBoxs));
        return this;
    }

}
