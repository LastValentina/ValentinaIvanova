package hw1;

import org.testng.annotations.DataProvider;

public class DataProviderAdditionalMultTests {
    @DataProvider
    public Object[][] multAdditDataSet() {
        return new Object[][]{
                {2.25, 10.3333, 23.249925}
        };
    }


}
