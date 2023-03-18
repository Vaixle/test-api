package com.vaixle.testapi.exception;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductNotFoundException extends RuntimeException {

    static String DEFAULT_MESSAGE = "Продукт не найден";

    static String MESSAGE_WITH_ID = "Продукт с id %s не найден!";


    public ProductNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public ProductNotFoundException(String id) {
        super(String.format(MESSAGE_WITH_ID, id));
    }
}
