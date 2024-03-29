package org.example.exception;

public class IllegalValueException extends Exception {
    private final String message;

    public IllegalValueException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
