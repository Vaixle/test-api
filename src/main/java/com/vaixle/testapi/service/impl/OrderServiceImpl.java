package com.vaixle.testapi.service.impl;

import com.vaixle.testapi.configuration.ExceptionConfig;
import com.vaixle.testapi.exception.NotEnoughException;
import com.vaixle.testapi.exception.NotFoundException;
import com.vaixle.testapi.exception.ProductNotFoundException;
import com.vaixle.testapi.mapper.OrderMapper;
import com.vaixle.testapi.model.Customer;
import com.vaixle.testapi.model.Order;
import com.vaixle.testapi.model.OrderItem;
import com.vaixle.testapi.model.Product;
import com.vaixle.testapi.model.dto.OrderItemRequestDto;
import com.vaixle.testapi.payload.request.CreateOrderRequest;
import com.vaixle.testapi.payload.response.CreateOrderResponse;
import com.vaixle.testapi.payload.response.OrderResponse;
import com.vaixle.testapi.payload.response.OrdersResponse;
import com.vaixle.testapi.repository.CustomerRepository;
import com.vaixle.testapi.repository.OrderRepository;
import com.vaixle.testapi.repository.ProductRepository;
import com.vaixle.testapi.service.OrderService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderServiceImpl implements OrderService {

    OrderMapper orderMapper;
    ProductRepository productRepository;
    OrderRepository orderRepository;
    CustomerRepository customerRepository;

    ExceptionConfig exceptionConfig;

    @Override
    @Transactional
    public CreateOrderResponse createOrder(CreateOrderRequest createOrderRequest) {
        List<OrderItemRequestDto> orderItems = createOrderRequest.getOrderItems();
        List<OrderItem> items = new ArrayList<>();
        for (OrderItemRequestDto orderItem : orderItems) {
            Product product = productRepository.findByName(orderItem.getItemName()).orElseThrow(ProductNotFoundException::new);
            long quantity = orderItem.getQuantity();

            if (product.getQuantity() < quantity) {
                throw new NotEnoughException(exceptionConfig.getNotEnoughMessageWithCount(), product.getQuantity());
            }

            product.setQuantity(product.getQuantity() - quantity);
            productRepository.save(product);
            OrderItem item = new OrderItem();
            item.setProduct(product);
            item.setQuantity(orderItem.getQuantity());
            items.add(item);
        }
        Order order = orderMapper.createOrderRequestToOrder(createOrderRequest);
        items.forEach(i -> i.setOrder(order));
        order.setOrderItems(items);
        Customer customer = customerRepository.save(order.getCustomer());
        order.setCustomer(customer);
        return orderMapper.OrderToCreateOrderResponse(orderRepository.save(order));
    }

    @Override
    @Transactional
    public OrdersResponse getAllOrders() {
        return new OrdersResponse(orderMapper.OrdersToOrderDtos(orderRepository.findAll()));
    }

    @Override
    @Transactional
    public OrderResponse getOrderById(long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(exceptionConfig.getOrderNotFoundMessageWithId(), id));
        return new OrderResponse(orderMapper.OrderToOrderDto(order));
    }
}
