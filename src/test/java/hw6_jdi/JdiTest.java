package hw6_jdi;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import hw6_jdi.entities.MetalsColors;
import hw6_jdi.entities.MetalsColorsJ;
import hw6_jdi.entities.User;
import hw6_jdi.forms.MetalsColorsForm;
import hw6_jdi.jdiPages.LeftMenuSection;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static hw6_jdi.JdiSite.*;

public class JdiTest {

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        PageFactory.initElements(JdiSite.class);
    }

    @Test(dataProviderClass = JdiDataProvider.class, dataProvider = "provideDataSetForMetalColortest")
    public void MetalsAndColorsPageTest(MetalsColorsJ dataSet) {
        open();
        jdiHomePage.login(User.ROMAN);
        jdiHomePage.userName.is().text(User.ROMAN.getFullName());  //Assert.assertEquals(getUserName(), User.ROMAN.getFullName());
        jdiHomePage.headerSection.clickMetalsColorsMenu();
        jdiMetalsColorsPage.checkOpened();                          //Assert.assertEquals(getTitle(), "Metal and Colors");

        jdiMetalsColorsPage.metalsColorsForm.fillForm(new MetalsColors(dataSet.getRadio1(), dataSet.getRadio2(),
                dataSet.getElementsAsString(), dataSet.getColor(), dataSet.getMetals(), dataSet.getVegetablesAsString()));

        //Assertion block for selected elements in Metals & Colors Form
        Assert.assertEquals(jdiMetalsColorsPage.metalsColorsForm.radio_odd.getValue(), dataSet.getRadio1());
        Assert.assertEquals(jdiMetalsColorsPage.metalsColorsForm.radio_even.getValue(), dataSet.getRadio2());
        MetalsColorsForm.metal.is().selected(dataSet.getMetals());
        MetalsColorsForm.color.is().selected(dataSet.getColor());
        List<String> list = Arrays.asList(dataSet.getElements());
        Assert.assertEquals(jdiMetalsColorsPage.metalsColorsForm.elements.checked(), list);
        Assert.assertEquals(jdiMetalsColorsPage.metalsColorsForm.vegetables.selected(), dataSet.getVegetablesAsString());

        jdiMetalsColorsPage.metalsColorsForm.submit();
        Assert.assertEquals(jdiMetalsColorsPage.convertResultBlockToClass(),
                dataSet.convertToResultClass());
        jdiMetalsColorsPage.headerSection.logout();
    }

    @AfterSuite
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

    @Test(enabled = false)
    public void benefitIconsTest() {
        open();
        int actualBenefitCount = jdiHomePage.getBenefitsCount();
        int expectedBenefitCount = 4;
        jdiHomePage.benefits.is().size(expectedBenefitCount);
        Assert.assertEquals(actualBenefitCount, expectedBenefitCount,
                String.format("EPAM should have %s but has %s", expectedBenefitCount, actualBenefitCount));
    }

    @Test(enabled = false)
    public void negativeLoginTest() {
        open();
        jdiHomePage.login(User.NEGATIVE);
        jdiHomePage.userName.is().hidden();
    }

    @Test(enabled = false)
    public void positiveLoginTest() {
        open();
        jdiHomePage.login(User.ROMAN);
        jdiHomePage.userName.is().text(User.ROMAN.getFullName());
        LeftMenuSection.leftMenu.select("Metals & Colors");
        jdiMetalsColorsPage.checkOpened();
        jdiMetalsColorsPage.headerSection.logout();
    }

    @Test(enabled = false)
    public void leftMenuSectionTest() {
        open();
        jdiHomePage.login(User.ROMAN);
        LeftMenuSection.leftMenu.select("Metals & Colors");
        jdiMetalsColorsPage.checkOpened();
    }

}

