package org.xr.example.service;

import org.junit.Test;
import org.xr.example.model.Answer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class NumberGeneratorTest {
    @Test
    public void should_generate_4_numbers_between_0_and_9() throws Exception {
        Answer answer = new NumberGenerator().generate();
        assertThat(AnswerValidator.isValid(answer), is(true));
    }
}
