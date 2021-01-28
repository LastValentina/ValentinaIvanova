package hw8.functional_level;

import hw8.TextDataProvider;
import hw8.assertions.CheckTextAssertions;
import hw8.dto.CheckTextDto;
import hw8.service.CheckTextService;
import org.testng.annotations.Test;

import static hw8.dto.Const.LANG_EN;
import static hw8.dto.Const.LANG_RU;

public class CheckLangTest {
    CheckTextService cts = new CheckTextService();
    CheckTextAssertions ta;
    CheckTextDto[] result;

    @Test(description = "language test",
            dataProviderClass = TextDataProvider.class, dataProvider = "textAndErrorsAndLangData")
    public void checkTextTest(String textId, String value, String langData, int errorQty, String[] error) {
        // for en - language (LANG_EN)
        result = cts.getCheckTextWithLang(value, LANG_EN);
        if (LANG_EN.contains(langData)) {
            ta = new CheckTextAssertions(result).checkNumberOfErrors(errorQty);
        } else {
            ta = new CheckTextAssertions(result).checkNumberOfErrors(0);
        }

        // for ru - language (LANG_RU)
        result = cts.getCheckTextWithLang(value, LANG_RU);
        if (LANG_RU.contains(langData)) {
            ta = new CheckTextAssertions(result).checkNumberOfErrors(errorQty);
        } else {
            ta = new CheckTextAssertions(result).checkNumberOfErrors(0);
        }
    }









}






