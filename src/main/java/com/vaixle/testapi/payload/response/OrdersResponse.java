package com.vaixle.testapi.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vaixle.testapi.model.dto.OrderDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
//@ApiModel("Список заказов")
public class OrdersResponse extends Response implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("data")
//    @ApiModelProperty("Заказ")
    List<OrderDto> order;
}
