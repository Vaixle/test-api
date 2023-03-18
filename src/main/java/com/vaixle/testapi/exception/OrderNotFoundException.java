package com.vaixle.testapi.exception;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderNotFoundException extends RuntimeException {

    static String DEFAULT_MESSAGE = "Заказ не найден";

    static String MESSAGE_WITH_ID = "Заказ с id %s не найден!";


    public OrderNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public OrderNotFoundException(String id) {
        super(String.format(MESSAGE_WITH_ID, id));
    }
}

