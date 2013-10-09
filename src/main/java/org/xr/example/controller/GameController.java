package org.xr.example.controller;

import org.xr.example.model.Answer;
import org.xr.example.service.AnswerValidator;
import org.xr.example.model.Game;
import org.xr.example.view.GameView;

public class GameController {
    private final Game game;
    private final GameView gameView;
    private final int numOfRounds;
    private int numOfPlay;

    public GameController(Game game, GameView gameView, int numOfRounds) {
        this.game = game;
        this.gameView = gameView;
        this.numOfRounds = numOfRounds;
        numOfPlay = 0;
    }

    public void play() {
        while (numOfPlay < numOfRounds) {
            try {
                Answer inputAnswer = new Answer(parseInputToIntArray(gameView.getInput()));
                if (AnswerValidator.isValid(inputAnswer)) {
                    if (playWithGuessedAnswer(inputAnswer)) {
                        break;
                    }
                } else {
                    gameView.displayInputErr();
                }
            } catch (NumberFormatException e) {
                gameView.displayInputErr();
            }
            numOfPlay++;
        }
        gameView.displayAnswer(game.getAnswer());
        gameView.displayGuessResults(game.getGuessResults());
    }

    private boolean playWithGuessedAnswer(Answer inputAnswer) {
        String guessResult = game.guessResult(inputAnswer);
        gameView.displayResult(guessResult);
        if (guessResult.equals("4A0B")) {
            gameView.displayCongrats();
            return true;
        }
        return false;
    }

    private int[] parseInputToIntArray(String playerInput) throws NumberFormatException {
        String[] tokenizedInput = playerInput.split(" ");
        int[] inputIntegers = new int[tokenizedInput.length];
        for (int i = 0; i < tokenizedInput.length; i++) {
            inputIntegers[i] = Integer.parseInt(tokenizedInput[i]);
        }
        return inputIntegers;
    }
}
