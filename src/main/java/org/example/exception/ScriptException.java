package org.example.exception;

public class ScriptException extends Exception {
    private final String message;

    public ScriptException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "Error during script execution: " + message;
    }
}
