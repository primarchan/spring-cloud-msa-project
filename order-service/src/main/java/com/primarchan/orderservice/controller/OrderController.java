package com.primarchan.orderservice.controller;

import com.primarchan.orderservice.dto.OrderDto;
import com.primarchan.orderservice.dto.RequestOrder;
import com.primarchan.orderservice.dto.ResponseOrder;
import com.primarchan.orderservice.jpa.OrderEntity;
import com.primarchan.orderservice.messagequeue.KafkaProducer;
import com.primarchan.orderservice.messagequeue.OrderProducer;
import com.primarchan.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/order-service")
@RequiredArgsConstructor
public class OrderController {

    private final Environment env;
    private final OrderService orderService;
    private final KafkaProducer kafkaProducer;
    private final OrderProducer orderProducer;

    @GetMapping("/health_check")
    public String status() {
        return String.format("It's working in ORDER SERVICE on PORT %s", env.getProperty("local.server.port"));
    }

    @PostMapping("/{userId}/orders")
    public ResponseEntity<ResponseOrder> createOrder(
            @PathVariable("userId") String userId,
            @RequestBody RequestOrder orderDetails
    ) {
        log.info("Before add orders data");
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        OrderDto orderDto = mapper.map(orderDetails, OrderDto.class);
        orderDto.setUserId(userId);

        /* JPA */
        OrderDto createdOrderDto = orderService.createOrder(orderDto);
        ResponseOrder responseOrder = mapper.map(createdOrderDto, ResponseOrder.class);

        /* Kafka */
        // orderDto.setOrderId(UUID.randomUUID().toString());
        // orderDto.setTotalPrice(orderDetails.getQty() * orderDetails.getUnitPrice());

        /* Send this order to the kafka */
        // kafkaProducer.send("example-catalog-topic", orderDto);
        // orderProducer.send("orders", orderDto);

        // ResponseOrder responseOrder = mapper.map(orderDto, ResponseOrder.class);

        log.info("After added orders data");

        return ResponseEntity.status(HttpStatus.CREATED).body(responseOrder);
    }

    @GetMapping("/{userId}/orders")
    public ResponseEntity<List<ResponseOrder>> getOrders(@PathVariable("userId") String userId) {
        log.info("Before retrieve orders data");
        Iterable<OrderEntity> orders = orderService.getOrdersByUserId(userId);

        List<ResponseOrder> responseOrders = new ArrayList<>();
        orders.forEach(entity -> {
            responseOrders.add(new ModelMapper().map(entity, ResponseOrder.class));
        });
        log.info("After retrieved orders data");

        return ResponseEntity.status(HttpStatus.OK).body(responseOrders);
    }



}
