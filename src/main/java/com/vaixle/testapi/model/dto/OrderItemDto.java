package com.vaixle.testapi.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderItemDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    long id;

    @JsonProperty("product_id")
    long productId;

    long quantity;

    @JsonProperty("total_price")
    double totalPrice;
}
