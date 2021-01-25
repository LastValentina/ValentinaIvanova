package hw8.functional_level;

import hw8.TextDataProvider;
import hw8.service.CheckTextAssertions;
import hw8.service.CheckTextService;
import hw8.service.ResponseParser;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static hw8.dto.Const.*;

public class CheckErrorCodeTest {
    CheckTextService cts = new CheckTextService();
    ResponseParser rp = new ResponseParser();
    CheckTextAssertions ta;
    Map<String, Object> params;

    @Test(description = "error code test",
            dataProviderClass = TextDataProvider.class, dataProvider = "textAndErrorCodeData")
    public void checkTextTest(String textId, String value, String langData, int errorCode, int errorQty, String[] error) {
        params = new HashMap<>();
        params.put(parametr_text, value);
        params.put(parametr_lang, lang_en_ru);
        params.put(parametr_options, FIND_REPEAT_WORDS);
        ta = new CheckTextAssertions(rp.getDataFromResponse(cts.getWithParams(params))).verifyErrorCode(errorCode);
    }

}






