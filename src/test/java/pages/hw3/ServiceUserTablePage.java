package pages.hw3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ServiceUserTablePage extends AbstractPage {
    private HeaderMenu headerMenu;
    @FindBy(id = "user-table")
    private WebElement userTable;
    @FindBy(css = "table[id='user-table'] tbody tr td select")
    //(xpath = "//table[@id='user-table']/tbody/tr/td/select")
    private List<WebElement> listDropdownsIntoTable;
    @FindBy(css = "table[id='user-table'] tbody tr td a")
    private List<WebElement> listUsersIntoTable;
    @FindBy(css = "table[id='user-table'] tbody tr td span")
    //(xpath = "//table[@id='user-table']//tbody//tr//td//span")
    private List<WebElement> listDescriptionTextIntoTable;
    @FindBy(xpath = "//table[@id='user-table']//tbody/tr/td[4]//input[@type='checkbox']")
    private List<WebElement> listCheckboxesIntoTable;
    @FindBy(xpath = "//table[@id='user-table']//tbody/tr/td[1]")
    private List<WebElement> listNumbersIntoTable;
    @FindBy(css = "table[id='user-table'] thead tr th")
    private List<WebElement> listTableHeaders;
    @FindBy(css = "ul.panel-body-list.logs li")
    private List<WebElement> logs;

    public ServiceUserTablePage(WebDriver driver) {
        super(driver);
        headerMenu = new HeaderMenu(driver);
    }

    public ServiceUserTablePage waitLoadPage() {
        waitVisibleElement(userTable);
        return this;
    }

    public int getNumberDropdownsIntoTable() {
        return listDropdownsIntoTable.size();
    }

    public int getNumberUsersIntoTable() {
        return listUsersIntoTable.size();
    }

    public int getNumberTextDescriptionIntoTable() {
        return listDescriptionTextIntoTable.size();
    }

    public int getNumberCheckboxesIntoTable() {
        return listCheckboxesIntoTable.size();
    }

    public List<List<String>> getUserTableAsList() {
        List<List<String>> userTable = new ArrayList<>();
        String number, user, desc;
        number = listTableHeaders.get(0).getText();
        user = listTableHeaders.get(2).getText();
        desc = listTableHeaders.get(3).getText();
        userTable.add(Arrays.asList(number, user, desc));

        for (int i = 0; i < getNumberUsersIntoTable(); i++) {
            number = listNumbersIntoTable.get(i).getText();
            user = listUsersIntoTable.get(i).getText();
            desc = listDescriptionTextIntoTable.get(i).getText();
            userTable.add(Arrays.asList(number, user, desc));
        }
        return userTable;
    }

    public List<String> getDropDownListByUser(String user) {
        for (int i = 0; i < listUsersIntoTable.size(); i++) {
            if (listUsersIntoTable.get(i).getText().equals(user)) {
                List<WebElement> dropdown = listDropdownsIntoTable.get(i)
                        .findElements(By.tagName("option"));
                System.out.println("size=" + dropdown.size());
                List<String> list = new ArrayList<>();
                list.add("Dropdown Values");
                for (WebElement e : dropdown) {
                    list.add(e.getText());
                }
                return list;
            }
        }
        return null;
    }

    public void selectCheckboxByUser(String user) {
        for (int i = 0; i < listUsersIntoTable.size(); i++) {
            if (listUsersIntoTable.get(i).getText().equals(user)) {
                listCheckboxesIntoTable.get(i).click();
                break;
            }
        }
    }

    public List<String> getLogs() {
        List<String> list = new ArrayList<>();
        for (WebElement e : logs) {
            list.add(e.getText());
        }
        return list;
    }

}
