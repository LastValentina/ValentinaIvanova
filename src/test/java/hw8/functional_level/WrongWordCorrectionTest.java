package hw8.functional_level;

import hw8.TextDataProvider;
import hw8.assertions.CheckTextAssertions;
import hw8.dto.CheckTextDto;
import hw8.service.CheckTextService;
import org.testng.annotations.Test;

public class WrongWordCorrectionTest {
    CheckTextService cts = new CheckTextService();
    CheckTextAssertions ta;
    CheckTextDto[] correctedResult;

    @Test(description = "check if provided words don't contain errors",
            dataProviderClass = TextDataProvider.class, dataProvider = "textAndErrorsAndLangData")
    public void checkTextTest(String textId, String value, String langData, int errorQty, String[] error) {
        if (errorQty > 0) {
            String providedWord = cts.getCheckText(value)[0].getS().get(0);
            //then check the first returned variant from node "S"
            correctedResult = cts.getCheckText(providedWord);
            ta = new CheckTextAssertions(correctedResult).checkNumberOfErrors(0);
        }
    }
}






