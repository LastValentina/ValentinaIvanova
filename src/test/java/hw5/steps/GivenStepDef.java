package hw5.steps;

import io.cucumber.java.en.Given;

public class GivenStepDef extends AbstractStepDef {

    @Given("I open JDI GitHub site")
    public void iOpenJdiSite() {
        homePage.openPage();
    }

    @Given("I login as user {string} with password {string}")
    public void iLoginAsUser(String name, String password) {
        homePage.clickUserIcon();
        homePage.login(name, password);
        homePage.waitElementUserName();
    }

}
