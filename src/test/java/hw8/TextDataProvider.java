package hw8;

import org.testng.annotations.DataProvider;

import static hw8.dto.Const.*;

public class TextDataProvider {

    @DataProvider
    public Object[][] textAndErrorsData() {
        return new Object[][]{
                {"t_1", "There are too many questaons", 1, "questaons"},
                {"t_2", "There is not one solution", 0, null},
                {"t_3", "There is no resurrection", 0, null},
                {"t_4", "Ther is so muuch confusion", 2, "Ther", "muuch"},
        };
    }

    @DataProvider
    public Object[][] wrongWordData() {
        return new Object[][]{
                {"t_5", "revoluti"},
                {"t_6", "коттт"},
        };
    }

    @DataProvider
    public Object[][] textAndErrorsAndLangData() {
        return new Object[][]{
                {"t_7", "There are too many questaons", LANG_EN, 1},
                {"t_8", "Ther is so muuch confusion", LANG_EN, 2},
        };
    }

    @DataProvider
    public Object[][] textAndErrorCodeData() {
        return new Object[][]{
                {"t_11", "There are too many questaons", LANG_EN, CODE_UNKNOWN},
                {"t_12", "There is not one soLUTion", LANG_EN, CODE_CASE},
                {"t_13", "по полю гуляет кот кот и поет", LANG_RU, CODE_UNKNOWN},
                {"t_14", "по полю гуляет коттт и поет", LANG_RU, CODE_UNKNOWN},
                {"t_15", "There is so much much much confusion", LANG_EN, CODE_REPEAT},
                {"t_16", "бывает все на свете свете хорошо", LANG_RU, CODE_REPEAT},
        };
    }

    @DataProvider
    public Object[][] textsData() {
        return new Object[][]{
                {"t_17", 2, "too many questaons", "There is not one soluti"},
                {"t_18", 0, "There is no resurrection", "There is so much confusion"},
        };
    }

    @DataProvider
    public Object[][] textErrorsData() {
        return new Object[][]{
                {"t_19", "There are too many questaons", 1, "questaons"},
                {"t_20", "Ther is so muuch confusion", 2, "Ther", "muuch"},
        };
    }
}

