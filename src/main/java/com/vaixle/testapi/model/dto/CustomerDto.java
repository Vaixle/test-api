package com.vaixle.testapi.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serial;
import java.io.Serializable;

/**
 * A DTO for the {@link com.vaixle.testapi.model.Customer} entity
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("customer_name")
    @NotBlank(message = "Поле имя не может быть пустым")
    String name;


    @JsonProperty("customer_email")
    @Email(message = "Неправильный формат email")
    @NotBlank(message = "Поле email не может быть пустым")
    String email;

    @JsonProperty("customer_address")
    @NotBlank(message = "Поле адрес не может быть пустым")
    String address;
}