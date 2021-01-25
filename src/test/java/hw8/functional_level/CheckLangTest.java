package hw8.functional_level;

import hw8.TextDataProvider;
import hw8.service.CheckTextAssertions;
import hw8.service.CheckTextService;
import hw8.service.ResponseParser;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static hw8.dto.Const.*;

public class CheckLangTest {
    CheckTextService cts = new CheckTextService();
    ResponseParser rp = new ResponseParser();
    CheckTextAssertions ta;
    Map<String, Object> params;

    @Test(description = "language test",
            dataProviderClass = TextDataProvider.class, dataProvider = "textAndErrorsAndLangData")
    public void checkTextTest(String textId, String value, String langData, int errorQty, String[] error) {
        // for en - language
        String usedLang = lang_en;
        params = new HashMap<>();
        params.put(parametr_text, value);
        params.put(parametr_lang, usedLang);
        if (usedLang.contains(langData)) {
            ta = new CheckTextAssertions(rp.getDataFromResponse(cts.getWithParams(params))).verifyQtyErrors(errorQty);
        } else {
            ta = new CheckTextAssertions(rp.getDataFromResponse(cts.getWithParams(params))).verifyQtyErrors(0);
        }

        // for ru - language
        usedLang = lang_ru;
        params = new HashMap<>();
        params.put(parametr_text, value);
        params.put(parametr_lang, usedLang);
        if (usedLang.contains(langData)) {
            ta = new CheckTextAssertions(rp.getDataFromResponse(cts.getWithParams(params))).verifyQtyErrors(errorQty);
        } else {
            ta = new CheckTextAssertions(rp.getDataFromResponse(cts.getWithParams(params))).verifyQtyErrors(0);
        }
    }

}






