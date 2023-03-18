package com.vaixle.testapi.mapper;

import com.vaixle.testapi.model.OrderItem;
import com.vaixle.testapi.model.dto.OrderItemDto;
import com.vaixle.testapi.model.dto.OrderItemRequestDto;
import com.vaixle.testapi.model.dto.OrderItemResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrderItemMapper {

    List<OrderItem> orderItemRequestDtosToOrderItems(List<OrderItemRequestDto> orderItemRequestDtos);
    List<OrderItemResponseDto> OrderItemsToOrderItemResponseDtos(List<OrderItem> orderItems);

    OrderItem orderItemRequestDtoToOrderItem(OrderItemRequestDto orderItemRequestDto);

    @Mapping(source = "product.name", target = "itemName")
    OrderItemResponseDto orderItemToOrderItemResponseDto(OrderItem orderItem);

    @Mapping(source = "product.id", target = "productId")
    OrderItemDto orderItemToOrderItemDto(OrderItem orderItem);

    List<OrderItemDto> orderItemsToOrderItemDtos(List<OrderItem> orderItems);


}
