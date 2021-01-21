package hw5.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ThenStepDef extends AbstractStepDef {

    @Then("{string} page should be opened")
    public void loadServiceUserTablePage(String page) {
        Assert.assertEquals(homePage.getTitleText(), page);
    }

    @Then("User name in the left-top side of screen should be {string}")
    public void userNameShouldBeEqual(String user) {
        Assert.assertEquals(homePage.getUserName(), user);
    }

    @Then("^Log rows are displayed with relevant history$")
    public void logRowsAreDisplayedWithRelevantHistoryOnDifferentElementsPage(DataTable dt) {
        List<WebElement> listLog = serviceElementsPage.getLogs();
        SoftAssert softAssert = new SoftAssert();
        List<List<String>> table = dt.asLists(String.class);
        softAssert.assertEquals(listLog.size(), table.size());   //check number of items in Log
        for (int i = 0; i < table.size(); i++) {
            int counterLog = listLog.size() - i - 1;
            boolean actualContElement = listLog.get(counterLog).getText().contains(table.get(i).get(0));
            boolean actualContent;
            if (table.get(i).get(1).equals("cbox")) {
                actualContent = listLog.get(counterLog).getText().contains("condition changed to true");
            } else {
                actualContent = listLog.get(counterLog).getText().contains("value changed to");
            }
            softAssert.assertTrue(actualContElement && actualContent, "Log for defined element doesn't relevanl");
        }
        softAssert.assertAll();
    }

    @And("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void numberTypeDropdownsShouldBeDisplayedOnUsersTableOnUserTablePage(int n) {
        Assert.assertEquals(serviceUserTablePage.getNumberDropdownsIntoTable(), n);
    }

    @And("{int} Usernames should be displayed on Users Table on User Table Page")
    public void usernamesShouldBeDisplayedOnUsersTableOnUserTablePage(int n) {
        Assert.assertEquals(serviceUserTablePage.getNumberUsersIntoTable(), n);
    }

    @And("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void descriptionTextsUnderImagesShouldBeDisplayedOnUsersTableOnUserTablePage(int n) {
        Assert.assertEquals(serviceUserTablePage.getNumberTextDescriptionIntoTable(), n);
    }

    @And("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxesShouldBeDisplayedOnUsersTableOnUserTablePage(int n) {
        Assert.assertEquals(serviceUserTablePage.getNumberCheckboxesIntoTable(), n);
    }

    @And("User table should contain following values:")
    public void userTableShouldContainFollowingValues(DataTable dt) {
        List<List<String>> expectedTable = dt.asLists(String.class);
        List<List<String>> actualTable = serviceUserTablePage.getUserTableAsList();
        Assert.assertEquals(actualTable, expectedTable);
    }

    @And("droplist should contain values in column Type for user {string}")
    public void droplistShouldContainValuesInColumnTypeForUser(String user, List<String> expectedList) {
        Assert.assertEquals(serviceUserTablePage.getDropDownListByUser(user), expectedList);
    }

    @Then("{int} log row has {string} text in log section")
    public void logRowHasTextInLogSection(int n, String expectedLog) {
        Assert.assertEquals(serviceUserTablePage.getLogs().size(), n, "Log doesn't contain " + n + " records");
        Assert.assertTrue(serviceUserTablePage.getLogs().get(0).contains(expectedLog), "Actual log doesn't contain " + expectedLog);
    }
}
