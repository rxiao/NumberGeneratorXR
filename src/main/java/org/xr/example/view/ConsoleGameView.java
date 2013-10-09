package org.xr.example.view;

import org.xr.example.model.Answer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static java.lang.System.out;

public class ConsoleGameView implements GameView {

    private BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String getInput() {
        out.println("Please guess 4 numbers separated with space:");
        String input = null;
        try {
            input = consoleReader.readLine();
        } catch (IOException e) {
            out.println("System error!");
        }
        return input;
    }

    @Override
    public void displayResult(String guessResult) {
        out.println(guessResult);
    }

    @Override
    public void displayInputErr() {
        out.println("Wrong input format");
    }

    @Override
    public void displayAnswer(Answer answer) {
        out.println("The actual answer is: ");
        out.println(answer.toString());
    }

    @Override
    public void displayGuessResults(List<Answer> guessResults) {
        out.println("You have guessed: ");
        for (Answer guessResult : guessResults) {
            out.println(guessResult.toString());
        }
    }

    @Override
    public void displayCongrats() {
        out.println("Congratulations! You are the winner!");
    }

}
