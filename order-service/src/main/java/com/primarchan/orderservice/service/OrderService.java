package com.primarchan.orderservice.service;

import com.primarchan.orderservice.dto.OrderDto;
import com.primarchan.orderservice.jpa.OrderEntity;

public interface OrderService {

    OrderDto createOrder(OrderDto orderDto);

    OrderDto getOrderByOrderId(String orderId);

    Iterable<OrderEntity> getOrdersByUserId(String userId);

}
