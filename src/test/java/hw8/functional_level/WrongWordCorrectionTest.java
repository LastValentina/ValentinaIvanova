package hw8.functional_level;

import hw8.TextDataProvider;
import hw8.service.CheckTextAssertions;
import hw8.service.CheckTextService;
import hw8.service.ResponseParser;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static hw8.dto.Const.*;

public class WrongWordCorrectionTest {
    CheckTextService cts = new CheckTextService();
    ResponseParser rp = new ResponseParser();
    CheckTextAssertions ta;
    Map<String, Object> params;

    @Test(description = "check if provided words don't contain errors",
            dataProviderClass = TextDataProvider.class, dataProvider = "textAndErrorsAndLangData")
    public void checkTextTest(String textId, String value, String langData, int errorQty, String[] error) {
        params = new HashMap<>();
        params.put(parametr_text, value);
        params.put(parametr_lang, lang_en_ru);
        if (errorQty > 0) {
            String providedWord = rp.getProvidedWords(cts.getWithParams(params)).get(0);
            System.out.println(providedWord);
            params.clear();
            params.put(parametr_text, providedWord);
            ta = new CheckTextAssertions(rp.getDataFromResponse(cts.getWithParams(params))).verifyQtyErrors(0);
        }
    }
}






