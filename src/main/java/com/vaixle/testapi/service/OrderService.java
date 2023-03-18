package com.vaixle.testapi.service;

import com.vaixle.testapi.payload.request.CreateOrderRequest;
import com.vaixle.testapi.payload.response.CreateOrderResponse;
import com.vaixle.testapi.payload.response.OrderResponse;
import com.vaixle.testapi.payload.response.OrdersResponse;

public interface OrderService {

    CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest);
    OrdersResponse getAllOrders();

    OrderResponse getOrderById(long id);
}
