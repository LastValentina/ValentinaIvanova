package hw1;

import org.testng.annotations.DataProvider;

public class DataProviderCalculatorSubTests {
    @DataProvider
    public Object[][] subDataSet() {
        return new Object[][]{
                {2.2, -2.2, 4.4},
                {-2.2, -10, 7.8},
                {222222.2, 100, 222122.2}
        };
    }

    @DataProvider
    public Object[][] subDataSetL() {
        return new Object[][]{
                {0, -2, 2},
                {-222, -10, -212},
                {222222, 100, 222122}
        };
    }

}
