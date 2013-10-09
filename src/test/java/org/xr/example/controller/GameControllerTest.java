package org.xr.example.controller;

import org.junit.Before;
import org.junit.Test;
import org.xr.example.model.Answer;
import org.xr.example.model.Game;
import org.xr.example.service.NumberGenerator;
import org.xr.example.view.GameView;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class GameControllerTest {
    private GameController gameController;
    private NumberGenerator numberGenerator;
    private GameView gameView;

    @Before
    public void setUp() throws Exception {
        //given
        numberGenerator = mock(NumberGenerator.class);
        Answer actualAnswer = new Answer(new int[]{1, 2, 3, 4});
        when(numberGenerator.generate()).thenReturn(actualAnswer);
        gameView = mock(GameView.class);
    }

    @Test
    public void should_allow_a_game_to_play_2_rounds() throws Exception {
        //given
        when(gameView.getInput()).thenReturn("2 3 4 5");
        Game game = new Game(numberGenerator);
        gameController = new GameController(game, gameView, 2);

        //when
        gameController.play();

        //then
        verify(gameView, times(2)).getInput();
        verify(gameView, times(2)).displayResult(anyString());
        assertEquals(game.getGuessResults().size(), 2);
        assertEquals(game.getGuessResults().get(0), new Answer(new int[]{2, 3, 4, 5}));
    }

    @Test
    public void should_reject_invalid_input() throws Exception {
        //given
        when(gameView.getInput()).thenReturn("1 1 2 3");
        Game game = new Game(numberGenerator);
        gameController = new GameController(game, gameView, 1);

        //when
        gameController.play();

        //then
        verify(gameView, times(1)).getInput();
        verify(gameView, times(1)).displayInputErr();
        assertEquals(game.getGuessResults().size(), 0);
    }

    @Test
    public void should_end_game_once_correct_answer_reached() throws Exception {
        //given
        when(gameView.getInput()).thenReturn("1 2 3 4");
        Game game = new Game(numberGenerator);
        gameController = new GameController(game, gameView, 2);

        //when
        gameController.play();

        //then
        verify(gameView, times(1)).getInput();
        verify(gameView, times(1)).displayCongrats();
        assertEquals(game.getGuessResults().size(), 1);
    }
}
