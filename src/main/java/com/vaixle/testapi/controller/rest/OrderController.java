package com.vaixle.testapi.controller.rest;

import com.vaixle.testapi.payload.request.CreateOrderRequest;
import com.vaixle.testapi.payload.response.CreateOrderResponse;
import com.vaixle.testapi.payload.response.OrderResponse;
import com.vaixle.testapi.payload.response.OrdersResponse;
import com.vaixle.testapi.service.OrderService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/api/orders")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderController {

    OrderService orderService;

    @GetMapping
//    @ApiOperation(value = "Получить заказы", notes = "Получить список заказов", response = OrdersResponse.class)
    public OrdersResponse getOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
//    @ApiOperation(value = "Получить заказ", notes = "Получить заказ по id", response = OrdersResponse.class)
    public OrderResponse getOrderById(
//            @ApiParam(name = "id", value = "Id заказа", example = "1", required = true)
            @Pattern(regexp = "\\d+", message = "Некорректный id")
            @PathVariable String id) {
        return orderService.getOrderById(Long.parseLong(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
//    @ApiOperation(value = "Создать заказ", notes = "Создание заказа и покупателя", response = CreateOrderResponse.class)
    public CreateOrderResponse createOrder(@Valid  @RequestBody CreateOrderRequest createOrderRequest) {
        return orderService.createOrder(createOrderRequest);
    }
}
