package com.projectjavasem4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projectjavasem4.entities.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
	
	
	
	@Query(nativeQuery = true, value = "select last_insert_id()") 
	Long getLastInsertId();
	
	@Query(nativeQuery = true, value = "SELECT * FROM  orders order by createddate DESC  limit 1") 
	OrderEntity  getLastInsertId2();
}
