package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorDivTest extends AbstractCalculatorTest {

    @Test(description = "check div method for double format", dataProviderClass = DataProviderCalculatorDivTests.class, dataProvider = "divDataSet")
    public void divDoubleTest(double a, double b, double expected) {
        double actual = calculator.div(a, b);
        assertEquals(actual, expected, 0.000001);
    }

    @Test(description = "check div method for long format", dataProviderClass = DataProviderCalculatorDivTests.class, dataProvider = "divDataSetL")
    public void divLongTest(long a, long b, long expected) {
        double actual = calculator.div(a, b);
        assertEquals(actual, expected);
    }

    @Test(description = "div by zero_double", dataProviderClass = DataProviderCalculatorDivTests.class, dataProvider = "divZeroDataSet", expectedExceptions = {NumberFormatException.class, ArithmeticException.class})
    public void divZeroTest(double a) {
        double actual = calculator.div(a, 0.0);
    }

    @Test(description = "div by zero_long", dataProviderClass = DataProviderCalculatorDivTests.class, dataProvider = "divZeroDataSetL", expectedExceptions = {NumberFormatException.class, ArithmeticException.class})
    public void divZeroLongTest(long a) {
        long actual = calculator.div(a, 0);
    }

}
