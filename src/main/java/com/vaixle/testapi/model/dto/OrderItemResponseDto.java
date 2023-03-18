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
public class OrderItemResponseDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("item_name")
    String itemName;
    long quantity;
    @JsonProperty("total_price")
    double totalPrice;
}
