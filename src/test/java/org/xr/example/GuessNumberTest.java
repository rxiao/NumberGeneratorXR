package org.xr.example;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.xr.example.controller.GameControllerTest;
import org.xr.example.model.GameTest;
import org.xr.example.service.AnswerValidatorTest;
import org.xr.example.service.NumberGeneratorTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        GameTest.class,
        AnswerValidatorTest.class,
        NumberGeneratorTest.class,
        GameControllerTest.class
})
public class GuessNumberTest {
}
