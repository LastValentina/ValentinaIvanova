package hw8.functional_level;

import hw8.TextDataProvider;
import hw8.assertions.CheckTextAssertions;
import hw8.service.CheckTextService;
import org.testng.annotations.Test;

public class WrongWordCorrectionTest {

    @Test(description = "check if provided words don't contain errors",
            dataProviderClass = TextDataProvider.class, dataProvider = "wrongWordData")
    public void checkTextTest(String textId, String value) {

        String providedWord = new CheckTextService().getCheckText(value)[0].getS().get(0);
        //then check the first returned variant from node "S"
        new CheckTextAssertions(new CheckTextService().getCheckText(providedWord))
                .checkNumberOfErrors(0);
    }
}






