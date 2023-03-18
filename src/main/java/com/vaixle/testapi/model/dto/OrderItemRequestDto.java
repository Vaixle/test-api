package com.vaixle.testapi.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderItemRequestDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("item_name")
    @NotBlank(message = "Поле название продукта не может быть пустым")
    String itemName;

    @Min(value = 1L, message = "Вы не можете указать количество меньше единицы")
    long quantity;
}
