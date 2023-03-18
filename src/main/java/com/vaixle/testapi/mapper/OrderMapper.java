package com.vaixle.testapi.mapper;

import com.vaixle.testapi.model.Order;
import com.vaixle.testapi.model.dto.OrderDto;
import com.vaixle.testapi.payload.request.CreateOrderRequest;
import com.vaixle.testapi.payload.response.CreateOrderResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy =
        ReportingPolicy.IGNORE,
        uses = {OrderItemMapper.class, CustomerMapper.class},
        componentModel = "spring")
public interface OrderMapper {
    Order createOrderRequestToOrder(CreateOrderRequest createOrderRequest);
    CreateOrderResponse OrderToCreateOrderResponse(Order order);

    @Mapping(source = "customer.id", target = "customerId")
    OrderDto OrderToOrderDto(Order order);

    List<OrderDto> OrdersToOrderDtos(List<Order> order);
}
