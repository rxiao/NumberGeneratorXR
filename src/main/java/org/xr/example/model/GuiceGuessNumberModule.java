package org.xr.example.model;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import org.xr.example.service.NumberGenerator;
import org.xr.example.view.ConsoleGameView;
import org.xr.example.view.GameView;

public class GuiceGuessNumberModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(GameView.class).to(ConsoleGameView.class);
        bind(Game.class).toInstance(new Game(new NumberGenerator()));
        bind(Integer.class).annotatedWith(Names.named("number of rounds")).toInstance(4);
    }
}
