package org.xr.example.view;

import org.xr.example.model.Answer;

import java.util.List;

public interface GameView {
    String getInput();

    void displayResult(String guessResult);

    void displayInputErr();

    void displayAnswer(Answer answer);

    void displayGuessResults(List<Answer> guessResults);

    void displayCongrats();
}
