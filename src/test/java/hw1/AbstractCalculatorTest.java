package hw1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractCalculatorTest {
 //   protected Calculator calculator;
    @BeforeMethod
    public void setUp() {
 //       calculator = new Calculator();
    }

    @AfterMethod
    public void tearDown() {
 //       calculator = null;
    }

}