package hw5.steps;

import io.cucumber.java.en.When;

public class WhenStepDef extends AbstractStepDef {

    @When("I click on {string} button in Header")
    public void iClickButtonOnHeader(String button) {
        homePage.getHeaderMenu().clickButtonByName(button);
    }

    @When("I click on {string} button in Service dropdown")
    public void iClickButtonInServiceOnHeader(String button) {
        homePage.getHeaderMenu().clickButtonByNameInMenuService(button);
    }

    @When("I select {string} checkboxes")
    public void iSelectCheckBoxOnElementsPage(String box) {
        serviceElementsPage.clickCheckBoxByName(box);
    }

    @When("I select {string} radio")
    public void iSelectRadioOnElementPage(String name) {
        serviceElementsPage.clickRadioByName(name);
    }

    @When("I select {string} from dropDown")
    public void iSelectItemFromDropDownOnElementPage(String name) {
        serviceElementsPage.selectFromDropDown(name);
    }

    @When("I select 'vip' checkbox for {string}")
    public void iSelectVipCheckboxFor(String user) {
        serviceUserTablePage.selectCheckboxByUser(user);
    }
}
