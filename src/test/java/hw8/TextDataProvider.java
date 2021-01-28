package hw8;

import org.testng.annotations.DataProvider;

import static hw8.dto.Const.*;
import static org.apache.http.HttpStatus.SC_METHOD_NOT_ALLOWED;
import static org.apache.http.HttpStatus.SC_OK;

public class TextDataProvider {

    @org.testng.annotations.DataProvider
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
                {"t_7", "There are too many questaons", LANG_EN, 1, "questaons"},
                {"t_8", "There is not one solution", LANG_EN, 0, null},
                {"t_9", "по полю гуляет коттт и поет", LANG_RU, 1, "коттт"},
                {"t_10", "Ther is so muuch confusion", LANG_EN, 2, "Ther", "muuch"},
        };
    }

    @DataProvider
    public Object[][] textAndErrorCodeData() {
        return new Object[][]{
                {"t_11", "There are too many questaons", LANG_EN, CODE_UNKNOWN, 1, "questaons"},
                {"t_12", "There is not one soLUTion", LANG_EN, CODE_CASE, 1, "soLUTion"},
                {"t_13", "по полю гуляет кот кот и поет", LANG_RU, CODE_UNKNOWN, 1, "кот"},
                {"t_14", "по полю гуляет коттт и поет", LANG_RU, CODE_UNKNOWN, 1, "коттт"},
                {"t_15", "There is so much much much confusion", LANG_EN, CODE_REPEAT, 1, "much"},
                {"t_16", "бывает все на свете свете хорошо", LANG_RU, CODE_REPEAT, 1, "свете"},
        };
    }

    @DataProvider
    public Object[][] httpMethodsData() {
        return new Object[][]{
                {HTTP_GET, SC_OK, "questaons"},
                {HTTP_POST, SC_OK, "questaons"},
                {HTTP_PUT, SC_METHOD_NOT_ALLOWED, "questaons"},
                {HTTP_DELETE, SC_METHOD_NOT_ALLOWED, "questaons"},
                {HTTP_PATCH, SC_METHOD_NOT_ALLOWED, "questaons"},
        };
    }


}

