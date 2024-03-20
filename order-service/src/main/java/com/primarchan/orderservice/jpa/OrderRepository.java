package com.primarchan.orderservice.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    Optional<OrderEntity> findByOrderId(String orderId);

    Iterable<OrderEntity> findByUserId(String userId);

}
