package hw1;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSubTest extends AbstractCalculatorTest {

    @Test(description = "check sub method for double format",
            dataProviderClass = DataProviderCalculatorSubTests.class, dataProvider = "subDataSet")
    public void subDoubleTest(double a, double b, double expected) {
        double actual = calculator.sub(a, b);
        assertEquals(actual, expected, 0.000001);
    }

    @Test(description = "check sub method for long format",
            dataProviderClass = DataProviderCalculatorSubTests.class, dataProvider = "subDataSetL")
    public void subLongTest(long a, long b, long expected) {
        double actual = calculator.sub(a, b);
        assertEquals(actual, expected);
    }

}
