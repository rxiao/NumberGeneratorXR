package org.xr.example.service;

import org.xr.example.model.Answer;
import org.xr.example.model.InvalidAnswerException;

import java.util.List;

public class AnswerValidator {

    private static final int NUMBER_COUNTER = 4;

    public static Boolean isValid(Answer answer) {
        List<Integer> numbers = answer.getNumbers();
        try {
            checkSizeOfAnswer(numbers);
            checkRangeOfNumbers(numbers);
            checkDuplicationOfNumbers(numbers);
        } catch (InvalidAnswerException e) {
            //TODO: log error message
            return false;
        }
        return true;
    }

    private static void checkDuplicationOfNumbers(List<Integer> numbers) throws InvalidAnswerException {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.indexOf(numbers.get(i)) != numbers.lastIndexOf(numbers.get(i))) {
                throw new InvalidAnswerException("input contain duplicated numbers");
            }
        }
    }

    private static void checkRangeOfNumbers(List<Integer> numbers) throws InvalidAnswerException {
        for (Integer number : numbers) {
            if (number < 0 || number > 9) {
                throw new InvalidAnswerException("input contain number out of range [0...9]");
            }
        }
    }

    private static void checkSizeOfAnswer(List<Integer> numbers) throws InvalidAnswerException {
        int size = numbers.size();
        if (size != NUMBER_COUNTER) {
            throw new InvalidAnswerException("input number of numbers is not " + NUMBER_COUNTER);
        }
    }

}
