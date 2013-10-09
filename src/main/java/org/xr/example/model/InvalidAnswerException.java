package org.xr.example.model;

public class InvalidAnswerException extends Exception {
    public InvalidAnswerException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return this.getMessage();
    }
}
