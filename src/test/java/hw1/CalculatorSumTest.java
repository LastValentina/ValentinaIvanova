package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSumTest extends AbstractCalculatorTest {

    @Test(description = "check sum method for double format",
            dataProviderClass = DataProviderCalculatorSumTests.class,
            dataProvider = "sumDataSet")
    public void sumDoubleTest(double a, double b, double expected) {
        double actual = calculator.sum(a, b);
        assertEquals(actual, expected, 0.000001);
    }

    @Test(description = "check sum method for long format",
            dataProviderClass = DataProviderCalculatorSumTests.class,
            dataProvider = "sumDataSetL")
    public void sumLongTest(long a, long b, long expected) {
        double actual = calculator.sum(a, b);
        assertEquals(actual, expected);
    }

}
