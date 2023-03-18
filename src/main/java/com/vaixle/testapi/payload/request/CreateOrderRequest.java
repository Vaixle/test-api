package com.vaixle.testapi.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.vaixle.testapi.model.dto.CustomerDto;
import com.vaixle.testapi.model.dto.OrderItemRequestDto;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateOrderRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonUnwrapped
    @NotNull(message = "Поле данные покупателя не может быть пустым")
    CustomerDto customer;

    @JsonProperty("order_details")
    @NotNull(message = "Поле заказанные продукты не может быть пустым")
    List<OrderItemRequestDto> orderItems;
}
