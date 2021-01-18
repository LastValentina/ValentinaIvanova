package hw6_jdi;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import hw6_jdi.entities.MetalsColorsJ;
import hw6_jdi.entities.User;
import hw6_jdi.enums.Menuitem;
import hw6_jdi.forms.MetalsColorsForm;
import hw6_jdi.jdiPages.HeaderSection;
import hw6_jdi.jdiPages.LeftMenuSection;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Arrays;

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
        jdiHomePage.userName.is().text(User.ROMAN.getFullName());           //Assert.assertEquals(getUserName(), User.ROMAN.getFullName());
        HeaderSection.headerMenu.select(Menuitem.MetalsColors);
        jdiMetalsColorsPage.checkOpened();                                  //Assert.assertEquals(getTitle(), "Metal and Colors");
        jdiMetalsColorsPage.metalsColorsForm.fillForm(dataSet);
        jdiMetalsColorsPage.metalsColorsForm.submit();

        metalsAndColorsFormAssertionStep(dataSet);                          //Assertion block for selected elements in Metals & Colors Form
        Assert.assertEquals(jdiMetalsColorsPage.checkResultBlock(dataSet),
                dataSet.convertToResult());
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
        LeftMenuSection.leftMenu.select(Menuitem.MetalsColors);
        jdiMetalsColorsPage.checkOpened();
    }

    @Test(enabled = false)
    public void headerMenuSectionTest() {
        open();
        jdiHomePage.login(User.ROMAN);
        HeaderSection.headerMenu.select(Menuitem.MetalsColors);
        jdiMetalsColorsPage.checkOpened();
    }

    public void metalsAndColorsFormAssertionStep(MetalsColorsJ entity) {
        Assert.assertEquals(jdiMetalsColorsPage.metalsColorsForm.radio_odd.getValue(), entity.getRadio_odd());
        Assert.assertEquals(jdiMetalsColorsPage.metalsColorsForm.radio_even.getValue(), entity.getRadio_even());
        MetalsColorsForm.metals.is().selected(entity.getMetals());
        MetalsColorsForm.color.is().selected(entity.getColor());
        Assert.assertEquals(jdiMetalsColorsPage.metalsColorsForm.elements_f.checked(), Arrays.asList(entity.getElements()));
        Assert.assertEquals(jdiMetalsColorsPage.metalsColorsForm.vegetables_f.selected(), entity.getVegetables_f());
    }
}

