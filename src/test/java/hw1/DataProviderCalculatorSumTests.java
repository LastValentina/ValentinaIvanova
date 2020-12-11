package hw1;

import org.testng.annotations.DataProvider;

public class DataProviderCalculatorSumTests {

    @DataProvider
    public Object[][] sumDataSet() {
        return new Object[][]{
                {2.2, 0, 2.2},
                {-2.2, -10, -12.2},
                {222222.2, 100, 222322.2}
        };
    }

    @DataProvider
    public Object[][] sumDataSetL() {
        return new Object[][]{
                {2, 0, 2},
                {-222, -10, -232},
                {222222, 100, 222322}
        };
    }
}
