package com.vaixle.testapi.payload.request;

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
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateProductRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Поле имя не может быть пустым")
    String name;

    @NotBlank(message = "Поле описание не может быть пустым")
    String description;
}