package com.vaixle.testapi.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vaixle.testapi.model.dto.OrderDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderResponse extends Response implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("data")
    OrderDto order;
}
