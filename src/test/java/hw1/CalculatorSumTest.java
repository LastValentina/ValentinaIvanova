package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

public class CalculatorSumTest extends AbstractCalculatorTest
{
    @DataProvider
    public Object[][]sumDataSet(){
        return new Object[][]{
                {2.2,0,2.2},
                {-2.2,-10,-12.2},
                {222222.2,100,222322.2}
        };
    }

    @Test(description = "check sum method for double format", dataProvider = "sumDataSet")
    public void sumDoubleTest(double a, double b, double expected){
        double actual=calculator.sum(a,b);
        assertEquals(actual, expected,0.000001);
    }

    @DataProvider
    public Object[][]sumDataSetL(){
        return new Object[][]{
                {2,0,2},
                {-222,-10,-232},
                {222222,100,222322}
        };
    }

    @Test(description = "check sum method for long format", dataProvider = "sumDataSetL")
    public void sumLongTest(long a, long b, long expected){
        double actual=calculator.sum(a,b);
        assertEquals(actual, expected);
    }

}
