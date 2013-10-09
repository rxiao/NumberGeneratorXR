package org.xr.example.model;

import java.util.ArrayList;
import java.util.List;

public class Answer {
    private List<Integer> numbers;

    public Answer(int[] input) {
        this.numbers = new ArrayList<Integer>();
        for (int anInput : input) {
            this.numbers.add(anInput);
        }
    }

    public int countCorrectPositions(Answer secondAnswer) {
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i).equals(secondAnswer.numbers.get(i))) {
                count++;
            }
        }
        return count;
    }

    public int countCorrectValuesButWrongPositions(Answer secondAnswer) {
        return countCorrectValues(secondAnswer) - countCorrectPositions(secondAnswer);
    }

    private int countCorrectValues(Answer secondAnswer) {
        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.contains(secondAnswer.numbers.get(i))) {
                count++;
            }
        }
        return count;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer = (Answer) o;

        return !(numbers != null ? !numbers.equals(answer.numbers) : answer.numbers != null);

    }

    @Override
    public int hashCode() {
        return numbers != null ? numbers.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "numbers {" + numbers + '}';
    }
}
