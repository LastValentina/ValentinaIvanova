package hw8.assertions;

import hw8.dto.CheckTextDto;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CheckTextsAssertions {
    private CheckTextDto[][] array;

    public CheckTextsAssertions(CheckTextDto[][] response) {
        this.array = response;
    }

    public CheckTextsAssertions checkReturnedWordsIntoResponse(List<String> words) {
        List<String> actualWord = new ArrayList<>();
        for (CheckTextDto[] l : array) {
            for (CheckTextDto dto : l) {
                actualWord.add(dto.getWord());
            }
        }
        Assert.assertEquals(actualWord, words, Messages.MES_WRONG_WORD);
        return this;
    }

    public CheckTextsAssertions checkNumberOfErrors(int qty) {
        List<String> word = new ArrayList<>();
        for (CheckTextDto[] l : array) {
            for (CheckTextDto dto : l) {
                word.add(dto.getWord());
            }
        }
        Assert.assertEquals(word.size(), qty, Messages.MES_WRONG_SIZE);
        return this;
    }
}
