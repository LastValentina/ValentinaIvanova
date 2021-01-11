package hw5.hooks;


import hw5.WebDriverSingletone;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {

    @Before
    public void setUp() {
        WebDriverSingletone.getDriver();
    }

    @After
    public void tearDown() {
        WebDriverSingletone.closeDriver();
    }

}
