package com.vaixle.testapi.controller.rest;

import com.vaixle.testapi.payload.request.CreateOrderRequest;
import com.vaixle.testapi.payload.response.CreateOrderResponse;
import com.vaixle.testapi.service.OrderService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/api/orders2")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderWithErrorController {

    OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
//    @ApiOperation(value = "Создать заказ", notes = "Создание заказа и покупателя", response = CreateOrderResponse.class)
    public CreateOrderResponse createOrder(@RequestBody CreateOrderRequest createOrderRequest) {
        return orderService.createOrder(createOrderRequest);
    }
}
