package org.xr.example.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.xr.example.model.Answer;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AnswerValidatorTest {

    private int[] input;
    private boolean result;

    public AnswerValidatorTest(int[] input, boolean result) {
        this.input = input.clone();
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 3, 4}, true},
                {new int[]{1, 2, 3, 4, 5}, false},
                {new int[]{1, 2, 3, 40}, false},
                {new int[]{1, 2, 3, 3}, false},
        });
    }

    @Test
    public void should_validate_answers() {
        Assert.assertEquals(AnswerValidator.isValid(new Answer(input)), result);
    }


}
