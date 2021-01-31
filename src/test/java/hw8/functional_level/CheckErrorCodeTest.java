package hw8.functional_level;

import hw8.TextDataProvider;
import hw8.assertions.CheckTextAssertions;
import hw8.service.CheckTextService;
import org.testng.annotations.Test;

import static hw8.dto.Const.FIND_REPEAT_WORDS;

public class CheckErrorCodeTest {

    @Test(description = "error code test",
            dataProviderClass = TextDataProvider.class, dataProvider = "textAndErrorCodeData")
    public void checkTextTest(String textId, String value, String langData, int errorCode, int errorQty, String[] error) {

        new CheckTextAssertions(new CheckTextService().getCheckTextWithLangOptions(value, langData, Integer.toString(FIND_REPEAT_WORDS)))
                .checkErrorCode(errorCode);
    }

}






