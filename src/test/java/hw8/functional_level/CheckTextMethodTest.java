package hw8.functional_level;

import hw8.TextDataProvider;
import hw8.assertions.CheckTextAssertions;
import hw8.dto.CheckTextDto;
import hw8.service.CheckTextService;
import org.testng.annotations.Test;

import java.util.Arrays;

public class CheckTextMethodTest {

    CheckTextService checkTextService = new CheckTextService();
    CheckTextAssertions textAssertions;
    CheckTextDto[] result;

    @Test(description = "check incorrect words and number of errors",
            dataProviderClass = TextDataProvider.class, dataProvider = "textAndErrorsData")
    public void checkTextTest(String textId, String value, int errorQty, String[] error) {

        result = checkTextService.getCheckText(value);
        if (errorQty == 0) {
            textAssertions = new CheckTextAssertions(result).checkNumberOfErrors(errorQty);
        } else {
            textAssertions = new CheckTextAssertions(result)
                    .checkReturnedWordsIntoResponse(Arrays.asList(error));
        }
    }

    @Test(enabled = false, dataProviderClass = hw8.TextDataProvider.class, dataProvider = "wrongWordData")
    public void checkTextWithErrorTest(String id, String value) {
        textAssertions = new CheckTextAssertions(checkTextService.getCheckText(value))
                .checkReturnedWordsIntoResponse(value);
    }

}

