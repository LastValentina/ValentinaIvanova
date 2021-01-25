package hw8.functional_level;

import hw8.TextDataProvider;
import hw8.service.CheckTextAssertions;
import hw8.service.CheckTextService;
import hw8.service.ResponseParser;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static hw8.dto.Const.parametr_text;

public class CheckTextMethodTest {

    CheckTextService checkTextService = new CheckTextService();
    ResponseParser responseParser = new ResponseParser();
    CheckTextAssertions textAssertions;
    Map<String, Object> params;

    @Test(description = "check incorrect words and number of errors",
            dataProviderClass = TextDataProvider.class, dataProvider = "textAndErrorsData")
    public void checkTextTest(String textId, String value, int errorQty, String[] error) {
        params = new HashMap<>();
        params.put(parametr_text, value);
        if (errorQty == 0) {
            textAssertions = new CheckTextAssertions(responseParser.getDataFromResponse(checkTextService.getWithParams(params))).verifyQtyErrors(errorQty);
        } else {
            textAssertions = new CheckTextAssertions(responseParser.getDataFromResponse(checkTextService.getWithParams(params)))
                    .verifyWords(error);
        }
    }

    @Test(enabled = false, dataProviderClass = hw8.TextDataProvider.class, dataProvider = "wrongWordData")
    public void checkTextWithErrorTest(String id, String value) {
        params = new HashMap<>();
        params.put(parametr_text, value);
        textAssertions = new CheckTextAssertions(responseParser.getDataFromResponse(checkTextService.getWithParams(params)))
                .verifyWords(value);
    }

}

