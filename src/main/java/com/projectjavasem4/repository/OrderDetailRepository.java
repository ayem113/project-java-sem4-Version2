package com.projectjavasem4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projectjavasem4.entities.OrderDetailEntity;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Long> {


	@Query(nativeQuery = true, value = "SELECT * FROM orderdetail where id_order = :id") 
	List<OrderDetailEntity> findByIdOder(@Param("id") Long id);
}
