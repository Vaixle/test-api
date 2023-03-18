package com.vaixle.testapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class OrderItem extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    Product product;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    Order order;

    @Column(nullable = false)
    long quantity;

    @JsonProperty("total_price")
    double totalPrice;

    @PrePersist
    void calcTotalPrice(){
        totalPrice = product.getPrice() * quantity;
    }
}
