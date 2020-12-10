package hw1;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AdditionalMultTest extends AbstractCalculatorTest {

    @Test(description = "check mult method by accuracy",
            dataProviderClass = DataProviderAdditionalMultTests.class, dataProvider = "multAdditDataSet")
    public void multAdditionalTest(double a, double b, double expected) {
        SoftAssert softAssert = new SoftAssert();
        double delt = 100;
        for (int i = 1; i <= 7; i++) {
            delt = delt / 10.0;
            double actual = calculator.mult(a, b);
            softAssert.assertEquals(actual, expected, delt);
        }
        softAssert.assertAll();
    }

}
