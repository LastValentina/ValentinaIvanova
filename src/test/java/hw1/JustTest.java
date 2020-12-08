package hw1;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class JustTest {

    @Test
    public void justTest() {
        double actual=2+2;
        assertEquals(actual,4);
    }


}
