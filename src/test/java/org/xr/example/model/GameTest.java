package org.xr.example.model;

import org.junit.Before;
import org.junit.Test;
import org.xr.example.service.NumberGenerator;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {

    private Answer actualAnswer;
    private Game game;

    @Before
    public void setUp() throws Exception {
        actualAnswer = new Answer(new int[]{1, 2, 3, 4});
        NumberGenerator numberGenerator = mock(NumberGenerator.class);
        when(numberGenerator.generate()).thenReturn(actualAnswer);
        game = new Game(numberGenerator);
    }

    @Test
    public void should_return_0A0B_when_no_number_guessed_correctly() throws Exception {
        Answer guessedAnswer = new Answer(new int[]{5, 6, 7, 8});
        assertThat(game.guessResult(guessedAnswer), is("0A0B"));
    }

    @Test
    public void should_return_1A0B_when_one_number_position_guessed_correctly() throws Exception {
        Answer guessedAnswer = new Answer(new int[]{5, 2, 7, 8});
        assertThat(game.guessResult(guessedAnswer), is("1A0B"));
    }

    @Test
    public void should_return_0A1B_when_one_number_value_guessed_correctly() throws Exception {
        Answer guessedAnswer = new Answer(new int[]{2, 6, 7, 8});
        assertThat(game.guessResult(guessedAnswer), is("0A1B"));
    }

    @Test
    public void should_return_1A1B_when_one_number_position_and_one_value_guessed_correctly() throws Exception {
        Answer guessedAnswer = new Answer(new int[]{1, 5, 6, 3});
        assertThat(game.guessResult(guessedAnswer), is("1A1B"));
    }

    @Test
    public void should_record_all_guess_results() throws Exception {
        //given
        Answer firstGuess = new Answer(new int[]{1, 2, 3, 4});
        game.guessResult(firstGuess);
        Answer secondGuess = new Answer(new int[]{2, 3, 4, 5});
        game.guessResult(secondGuess);
        Answer thirdGuess = new Answer(new int[]{3, 4, 5, 6});
        game.guessResult(thirdGuess);
        
        //when
        List<Answer> guessedAnswers = game.getGuessResults();
        
        //then
        assertThat(guessedAnswers.size(), is(3));
        assertThat(guessedAnswers.get(0), is(firstGuess));
        assertThat(guessedAnswers.get(1), is(secondGuess));
        assertThat(guessedAnswers.get(2), is(thirdGuess));
    }
}