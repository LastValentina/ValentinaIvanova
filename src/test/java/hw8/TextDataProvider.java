package hw8;


import org.testng.annotations.DataProvider;

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
                {"t_7", "There are too many questaons", "en", 1, "questaons"},
                {"t_8", "There is not one solution", "en", 0, null},
                {"t_9", "по полю гуляет коттт и поет", "ru", 1, "коттт"},
                {"t_10", "Ther is so muuch confusion", "en", 2, "Ther", "muuch"},
        };
    }

    @DataProvider
    public Object[][] textAndErrorCodeData() {
        return new Object[][]{
                {"t_11", "There are too many questaons", "en", 1, 1, "questaons"},
                {"t_12", "There is not one soLUTion", "en", 3, 1, "soLUTion"},
                {"t_13", "по полю гуляет кот кот и поет", "ru", 1, 1, "кот"},
                {"t_14", "по полю гуляет коттт и поет", "ru", 1, 1, "коттт"},
                {"t_15", "There is so much much much confusion", "en", 2, 1, "much"},
                {"t_16", "бывает все на свете свете хорошо", "ru", 2, 1, "свете"},
        };
    }


}

