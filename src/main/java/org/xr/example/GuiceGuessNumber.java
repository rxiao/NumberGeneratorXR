package org.xr.example;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.xr.example.controller.GuiceGameController;
import org.xr.example.model.GuiceGuessNumberModule;

public class GuiceGuessNumber {

    public static void main(String arg[]) {
        Injector injector = Guice.createInjector(new GuiceGuessNumberModule());
        GuiceGameController gameController = injector.getInstance(GuiceGameController.class);
        gameController.play();
    }
}
