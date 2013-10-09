package org.xr.example;

import org.xr.example.controller.GameController;
import org.xr.example.model.Game;
import org.xr.example.service.NumberGenerator;
import org.xr.example.view.ConsoleGameView;
import org.xr.example.view.GameView;

public class GuessNumber {

    public static final int NUM_OF_ROUNDS = 4;

    public static void main(String arg[]) {
        GameView gameView = new ConsoleGameView();
        Game game = new Game(new NumberGenerator());
        GameController gameController = new GameController(game, gameView, NUM_OF_ROUNDS);
        gameController.play();
    }
}
