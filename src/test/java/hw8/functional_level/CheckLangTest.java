package hw8.functional_level;

import hw8.TextDataProvider;
import hw8.assertions.CheckTextAssertions;
import hw8.service.CheckTextService;
import org.testng.annotations.Test;

import static hw8.dto.Const.LANG_EN;
import static hw8.dto.Const.LANG_RU;

public class CheckLangTest {

    @Test(description = "test for option lang='En' with text on English",
            dataProviderClass = TextDataProvider.class, dataProvider = "textAndErrorsAndLangData")
    public void checkEnTextTest(String textId, String value, String langData, int errorQty, String[] error) {

        new CheckTextAssertions(new CheckTextService().getCheckTextWithLang(value, LANG_EN))
                .checkNumberOfErrors(errorQty);
    }

    @Test(description = "test for option='Ru' with text on English",
            dataProviderClass = TextDataProvider.class, dataProvider = "textAndErrorsAndLangData")
    public void checkRuTextTest(String textId, String value, String langData, int errorQty, String[] error) {

        new CheckTextAssertions(new CheckTextService().getCheckTextWithLang(value, LANG_RU))
                .checkNumberOfErrors(0);
    }

}
















