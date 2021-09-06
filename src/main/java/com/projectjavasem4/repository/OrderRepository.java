package com.projectjavasem4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectjavasem4.entities.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
	
}
