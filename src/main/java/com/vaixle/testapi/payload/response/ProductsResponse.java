package com.vaixle.testapi.payload.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vaixle.testapi.model.Product;
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
public class ProductsResponse extends Response implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @JsonProperty("data")
    List<Product> products;
}
