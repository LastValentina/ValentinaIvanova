package hw8.functional_level;

import hw8.TextDataProvider;
import hw8.assertions.CheckTextAssertions;
import hw8.service.CheckTextService;
import org.testng.annotations.Test;

import java.util.Arrays;

public class CheckTextMethodTest {

    @Test(description = "check number of errors into text",
            dataProviderClass = TextDataProvider.class, dataProvider = "textAndErrorsData")
    public void checkNumberOfErrorsIntoTextTest(String textId, String value, int errorQty, String[] error) {
        new CheckTextAssertions(new CheckTextService().getCheckText(value))
                .checkNumberOfErrors(errorQty);
    }

    @Test(description = "check incorrect words into text (Nodes 'word')",
            dataProviderClass = TextDataProvider.class, dataProvider = "textErrorsData")
    public void checkTextTest(String textId, String value, int errorQty, String[] error) {

        new CheckTextAssertions(new CheckTextService().getCheckText(value))
                .checkReturnedWordsIntoResponse(Arrays.asList(error));
    }

    @Test(enabled = false, dataProviderClass = hw8.TextDataProvider.class, dataProvider = "wrongWordData")
    public void checkTextWithErrorTest(String id, String value) {
        new CheckTextAssertions(new CheckTextService().getCheckText(value))
                .checkReturnedWordsIntoResponse(value);
    }
}

