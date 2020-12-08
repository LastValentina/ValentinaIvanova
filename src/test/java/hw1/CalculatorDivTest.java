package hw1;
//import java.lang.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorDivTest extends AbstractCalculatorTest
{
    @DataProvider
    public Object[][]divDataSet(){
        return new Object[][]{
                {-15.25,1,-15.25},
                {-2.25, 0.0010,-2250},
                {-22222.2,-10.7,2076.8411215}
        };
    }

    @Test(description = "check div method for double format", dataProvider = "divDataSet")
    public void divDoubleTest(double a, double b, double expected){
        double actual=calculator.div(a,b);
        assertEquals(actual, expected,0.000001);
    }

    @DataProvider
    public Object[][]divDataSetL(){
        return new Object[][]{
                {-2,2,-1},
                {-222,-15,14},
                {22,-100000,0}
        };
    }

    @Test(description = "check div method for long format", dataProvider = "divDataSetL")
    public void divLongTest(long a, long b, long expected){
        double actual=calculator.div(a,b);
        assertEquals(actual, expected);
    }

    @DataProvider
    public Object[][]divZeroDataSet(){
        return new Object[][]{
                {-2000000.87}
        };
    }

    @Test(enabled = false, description = "div by zero_double", dataProvider = "divZeroDataSet",expectedExceptions = {NumberFormatException.class, ArithmeticException.class})
    public void divZeroTest(double a){
            double actual=calculator.div(a,0.0);
        }

    @DataProvider
    public Object[][]divZeroDataSetL(){
        return new Object[][]{
                {-2000000}
        };
    }

    @Test(enabled = false, description = "div by zero_long", dataProvider = "divZeroDataSetL",expectedExceptions = {NumberFormatException.class, ArithmeticException.class})
    public void divZeroLongTest(long a){
        long actual=calculator.div(a,0);
    }

}
