package hw8.service;

import hw8.dto.CheckTextDto;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CheckTextAssertions {
    private List<CheckTextDto> list;

    public CheckTextAssertions(List<CheckTextDto> response) {
        this.list = response;
    }

    public CheckTextAssertions verifyWords(String[] words) {
        List<String> actualWord = new ArrayList<>();
        List<String> expectedWord = new ArrayList<>();
        Assert.assertEquals(list.size(), words.length, "Incorrect size for list of words ");
        for (int i = 0; i < list.size(); i++) {
            actualWord.add(list.get(i).getWord());
            expectedWord.add(words[i]);
        }
        Assert.assertEquals(actualWord, expectedWord, "Incorrect word name");
        return this;
    }

    public CheckTextAssertions verifyWords(String word) {
        Assert.assertEquals(list.size(), 1, "Incorrect size for list of words");
        Assert.assertEquals(list.get(0).getWord(), word, "Incorrect word name");
        return this;
    }

    public CheckTextAssertions verifyWords() {
        Assert.assertEquals(list.size(), 0, "Incorrect size for list of words");
        return this;
    }

    public CheckTextAssertions verifyQtyErrors(int qty) {
        Assert.assertEquals(list.size(), qty, "Incorrect size of words' List");
        return this;
    }

    public CheckTextAssertions verifyErrorCode(int code) {
        Assert.assertEquals(list.size(), 1, "Incorrect size of words' List");
        if (list.size() > 0) {
            Assert.assertEquals(list.get(0).getCode(), code, "Incorrect error code");
        }
        return this;
    }


}
