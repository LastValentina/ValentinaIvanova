package hw1;

import org.testng.annotations.DataProvider;

public class DataProviderCalculatorDivTests {
    @DataProvider
    public Object[][] divDataSet() {
        return new Object[][]{
                {-15.25, 1, -15.25},
                {-2.25, 0.0010, -2250},
                {-22222.2, -10.7, 2076.8411215}
        };
    }

    @DataProvider
    public Object[][] divDataSetL() {
        return new Object[][]{
                {-2, 2, -1},
                {-222, -15, 14},
                {22, -100000, 0}
        };
    }

    @DataProvider
    public Object[][] divZeroDataSet() {
        return new Object[][]{
                {-2000000.87}
        };
    }

    @DataProvider
    public Object[][] divZeroDataSetL() {
        return new Object[][]{
                {-2000000}
        };
    }

}
