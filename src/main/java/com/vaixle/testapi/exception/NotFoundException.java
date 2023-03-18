package com.vaixle.testapi.exception;


public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, long id) {
        super(String.format(message, id));
    }
}
