package hw1;

import org.testng.annotations.DataProvider;

public class DataProviderCalculatorMultTests {
    @DataProvider
    public Object[][] multDataSet() {
        return new Object[][]{
                {-15.2, 0, 0},
                {-2.25, 10, -22.5},
                {-22222.2, -10.7, 237777.54}
        };
    }

    @DataProvider
    public Object[][] multDataSetL() {
        return new Object[][]{
                {-2, 0, 0},
                {-222, -15, 3330},
                {222222, -100, -22222200}
        };
    }

}
