package org.xr.example.service;

import org.xr.example.model.Answer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberGenerator {
    public static final int ANSWER_NUMBER_COUNT = 4;

    public Answer generate() {
        Random random = new Random();
        int[] numbers = new int[ANSWER_NUMBER_COUNT];
        List<Integer> numberList = new ArrayList<Integer>();
        int count = 0;
        while (count < ANSWER_NUMBER_COUNT) {
            int number = random.nextInt(10);
            if (!numberList.contains(number)) {
                numberList.add(number);
                numbers[count] = number;
                count ++;
            }
        }
        return new Answer(numbers);
    }
}
