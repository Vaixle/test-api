package com.vaixle.testapi.exception;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NotEnoughException extends RuntimeException {

    public NotEnoughException(String message) {
        super(message);
    }

    public NotEnoughException(String message, long count) {
        super(String.format(message, count));
    }
}
