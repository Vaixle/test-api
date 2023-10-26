package com.vaixle.testapi.controller.rest;

import com.vaixle.testapi.payload.request.CreateOrderRequest;
import com.vaixle.testapi.payload.response.CreateOrderResponse;
import com.vaixle.testapi.payload.response.OrderResponse;
import com.vaixle.testapi.payload.response.OrdersResponse;
import com.vaixle.testapi.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Заказы", description = "Операции над заказами")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderController {

    OrderService orderService;

    @GetMapping
    @Operation(summary = "Получить заказы",
            description = "Возвращает список заказов с детальной информацией",
            operationId = "getOrders")
    public OrdersResponse getOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получить заказ по ID",
            description = "Возвращает заказ по ID с детальной информацией",
            operationId = "getOrderById",
            parameters = {
                    @Parameter(name = "id", description = "ID заказа для извлечения", required = true, example = "123")
            })
    public OrderResponse getOrderById(
            @Pattern(regexp = "\\d+", message = "Некорректный id")
            @PathVariable String id) {
        return orderService.getOrderById(Long.parseLong(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/{id}")
    @Operation(summary = "Создать заказ",
            description = "Создание заказа продуктов",
            operationId = "createOrder")
    public CreateOrderResponse createOrder(@Valid  @RequestBody CreateOrderRequest createOrderRequest) {
        return orderService.createOrder(createOrderRequest);
    }

}
