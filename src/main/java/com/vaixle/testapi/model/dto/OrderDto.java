package com.vaixle.testapi.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonPropertyOrder({ "id", "customerId", "orderItems" })
public class OrderDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    long id;

    @JsonProperty("customer_id")
    long customerId;

    @JsonProperty("order_details")
    List<OrderItemDto> orderItems;
}
