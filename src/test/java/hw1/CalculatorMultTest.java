package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorMultTest extends AbstractCalculatorTest {

    @Test(description = "check mult method for double format",
            dataProviderClass = DataProviderCalculatorMultTests.class,
            dataProvider = "multDataSet")
    public void multDoubleTest(double a, double b, double expected) {
        double actual = calculator.mult(a, b);
        assertEquals(actual, expected, 0.000001);
    }

    @Test(description = "check mult method for long format",
            dataProviderClass = DataProviderCalculatorMultTests.class,
            dataProvider = "multDataSetL")
    public void multLongTest(long a, long b, long expected) {
        double actual = calculator.mult(a, b);
        assertEquals(actual, expected);
    }

}
