package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorMultTest extends AbstractCalculatorTest
{
    @DataProvider
    public Object[][]multDataSet(){
        return new Object[][]{
                {-15.2,0,0},
                {-2.25, 10,-22.5},
                {-22222.2,-10.7,237777.54}
        };
    }

    @Test(enabled = true, description = "check mult method for double format", dataProvider = "multDataSet")
    public void multDoubleTest(double a, double b, double expected){
        double actual=calculator.mult(a,b);
        assertEquals(actual, expected,0.000001);
    }

    @DataProvider
    public Object[][]multDataSetL(){
        return new Object[][]{
                {-2,0,0},
                {-222,-15,3330},
                {222222,-100,-22222200}
        };
    }

    @Test(description = "check mult method for long format", dataProvider = "multDataSetL")
    public void multLongTest(long a, long b, long expected){
        double actual=calculator.mult(a,b);
        assertEquals(actual, expected);
    }

}
