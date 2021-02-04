package hw8.functional_level;

import hw8.TextDataProvider;
import hw8.assertions.CheckTextsAssertions;
import hw8.service.CheckTextService;
import org.testng.annotations.Test;

public class CheckTextsMethodTest {

    @Test
            (description = "check number of errors into response",
                    dataProviderClass = TextDataProvider.class, dataProvider = "textsData")
    public void checkTextsTest(String textId, int errorQty, String[] value) {
        new CheckTextsAssertions(new CheckTextService().getCheckTexts(value))
                .checkNumberOfErrors(errorQty);
    }
}

