package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class AdditionalMultTest extends AbstractCalculatorTest
{
    @DataProvider
    public Object[][]multAdditDataSet(){
        return new Object[][]{
                {2.25, 10.3333,23.249925}
        };
    }

    @Test(enabled = true, description = "check mult method by accuracy", dataProvider = "multAdditDataSet")
    public void multAdditionalTest(double a, double b, double expected){
        SoftAssert softAssert=new SoftAssert();
        double delt=100;
            for (int i=1;i<=7;i++) {
                delt=delt/10.0;
                double actual = calculator.mult(a, b);
                softAssert.assertEquals(actual,expected,delt);
            }
        softAssert.assertAll();
    }

}
