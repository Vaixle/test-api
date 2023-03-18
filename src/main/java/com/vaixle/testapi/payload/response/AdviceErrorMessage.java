package com.vaixle.testapi.payload.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AdviceErrorMessage extends Response implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    String error;

    {
        success = false;
    }
}
