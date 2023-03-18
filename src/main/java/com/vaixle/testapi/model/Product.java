package com.vaixle.testapi.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(unique = true)
    String name;

    @Column(nullable = false)
    String description;

    @Column(nullable = false)
    double price;

    @Column(nullable = false)
    long quantity;
}
