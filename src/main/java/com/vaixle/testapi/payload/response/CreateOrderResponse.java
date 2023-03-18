package com.vaixle.testapi.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.vaixle.testapi.model.dto.CustomerDto;
import com.vaixle.testapi.model.dto.OrderItemResponseDto;
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
public class CreateOrderResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("order_id")
    long id;

    @JsonUnwrapped
    CustomerDto customer;

    @JsonProperty("order_details")
    List<OrderItemResponseDto> orderItems;

    @JsonProperty("order_status")
    String orderStatus;
}
