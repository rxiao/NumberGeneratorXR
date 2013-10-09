package org.xr.example.model;

import org.xr.example.service.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final Answer answer;
    private final List<Answer> guessedAnswers;

    public Game(NumberGenerator numberGenerator) {
        answer = numberGenerator.generate();
        guessedAnswers = new ArrayList<Answer>();
    }

    public String guessResult(Answer guessedAnswer) {
        int positionCount = answer.countCorrectPositions(guessedAnswer);
        int valueCount = answer.countCorrectValuesButWrongPositions(guessedAnswer);
        guessedAnswers.add(guessedAnswer);
        return (String.format("%dA%dB", positionCount, valueCount));
    }

    public List<Answer> getGuessResults() {
        return guessedAnswers;
    }

    public Answer getAnswer() {
        return answer;
    }
}
