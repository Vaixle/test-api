package com.vaixle.testapi.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serial;
import java.io.Serializable;

/**
 * A DTO for the {@link com.vaixle.testapi.model.Product} entity
 */

@Getter
@Setter
@ToString
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    Long id;
    String name;
    String description;
    double price;
    long quantity;
    double total;
}