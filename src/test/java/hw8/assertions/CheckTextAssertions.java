package hw8.assertions;

import hw8.dto.CheckTextDto;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CheckTextAssertions {
    private CheckTextDto[] list;

    public CheckTextAssertions(CheckTextDto[] response) {
        this.list = response;
    }

    public CheckTextAssertions checkReturnedWordsIntoResponse(List<String> words) {
        List<String> actualWord = new ArrayList<>();
        Assert.assertEquals(list.length, words.size(), Messages.MES_WRONG_SIZE);
        for (CheckTextDto l : list) {
            actualWord.add(l.getWord());
        }
        Assert.assertEquals(actualWord, words, Messages.MES_WRONG_WORD);
        return this;
    }

    public CheckTextAssertions checkReturnedWordsIntoResponse(String word) {
        Assert.assertEquals(list.length, 1, Messages.MES_WRONG_SIZE);
        Assert.assertEquals(list[0].getWord(), word, Messages.MES_WRONG_WORD);
        return this;
    }

    public CheckTextAssertions checkReturnedWordsIntoResponse() {
        Assert.assertEquals(list.length, 0, Messages.MES_WRONG_SIZE);
        return this;
    }

    public CheckTextAssertions checkNumberOfErrors(int qty) {
        Assert.assertEquals(list.length, qty, Messages.MES_WRONG_SIZE);
        return this;
    }

    public CheckTextAssertions checkErrorCode(int code) {
        Assert.assertEquals(list.length, 1, Messages.MES_WRONG_SIZE);
        if (list.length > 0) {
            Assert.assertEquals(list[0].getCode(), code, Messages.MES_WRONG_CODE);
        }
        return this;
    }

}
