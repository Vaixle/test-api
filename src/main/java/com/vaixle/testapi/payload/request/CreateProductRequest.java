package com.vaixle.testapi.payload.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serial;
import java.io.Serializable;

/**
 * A DTO for the {@link com.vaixle.testapi.model.Product} entity
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateProductRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Поле имя не может быть пустым")
    String name;

    @NotBlank(message = "Поле описание не может быть пустым")
    String description;

    @Min(value = 1, message = "Вы не можете указать цену меньше еденицы")
    double price;

    @Min(value = 1L, message = "Вы не можете указать количество меньше единицы")
    long quantity;
}