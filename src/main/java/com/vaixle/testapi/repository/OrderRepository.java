package com.vaixle.testapi.repository;

import com.vaixle.testapi.model.Order;
import com.vaixle.testapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {


}
