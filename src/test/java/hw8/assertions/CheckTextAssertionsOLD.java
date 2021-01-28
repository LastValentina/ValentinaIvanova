package hw8.assertions;

import hw8.dto.CheckTextDto;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CheckTextAssertionsOLD {
    private List<CheckTextDto> list;

    public CheckTextAssertionsOLD(List<CheckTextDto> response) {
        this.list = response;
    }

    public CheckTextAssertionsOLD verifyWords(List<String> words) {
        List<String> actualWord = new ArrayList<>();
        Assert.assertEquals(list.size(), words.size(), Messages.MES_WRONG_SIZE);
        for (CheckTextDto l : list) {
            actualWord.add(l.getWord());
        }
        Assert.assertEquals(actualWord, words, Messages.MES_WRONG_WORD);
        return this;
    }

    public CheckTextAssertionsOLD verifyWords(String word) {
        Assert.assertEquals(list.size(), 1, Messages.MES_WRONG_SIZE);
        Assert.assertEquals(list.get(0).getWord(), word, Messages.MES_WRONG_WORD);
        return this;
    }

    public CheckTextAssertionsOLD verifyWords() {
        Assert.assertEquals(list.size(), 0, Messages.MES_WRONG_SIZE);
        return this;
    }

    public CheckTextAssertionsOLD verifyQtyErrors(int qty) {
        Assert.assertEquals(list.size(), qty, Messages.MES_WRONG_SIZE);
        return this;
    }

    public CheckTextAssertionsOLD verifyErrorCode(int code) {
        Assert.assertEquals(list.size(), 1, Messages.MES_WRONG_SIZE);
        if (list.size() > 0) {
            Assert.assertEquals(list.get(0).getCode(), code, Messages.MES_WRONG_CODE);
        }
        return this;
    }


}
