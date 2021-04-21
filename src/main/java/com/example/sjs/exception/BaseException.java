package com.example.sjs.exception;

public abstract class BaseException extends RuntimeException {

    private static final long serialVersionUID = -6005953296550348089L;

    private final String[] messages;

    public BaseException(String... message) {
        super(String.join(", ", message));
        this.messages = message;
    }

    public String[] getMessages() {
        return this.messages;
    }
}
