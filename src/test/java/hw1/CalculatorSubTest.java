package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSubTest extends AbstractCalculatorTest
{
    @DataProvider
    public Object[][]subDataSet(){
        return new Object[][]{
                {2.2,-2.2,4.4},
                {-2.2,-10,7.8},
                {222222.2,100,222122.2}
        };
    }

    @Test(description = "check sub method for double format", dataProvider = "subDataSet")
    public void subDoubleTest(double a, double b, double expected){
        double actual=calculator.sub(a,b);
        assertEquals(actual, expected,0.000001);
    }

    @DataProvider
    public Object[][]subDataSetL(){
        return new Object[][]{
                {0,-2,2},
                {-222,-10,-212},
                {222222,100,222122}
        };
    }

    @Test(description = "check sub method for long format", dataProvider = "subDataSetL")
    public void subLongTest(long a, long b, long expected){
        double actual=calculator.sub(a,b);
        assertEquals(actual, expected);
    }

}
