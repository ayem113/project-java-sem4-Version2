package com.projectjavasem4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projectjavasem4.entities.WardEntity;

public interface WardRepository  extends JpaRepository<WardEntity, Integer>{

	@Query(nativeQuery = true, value = "SELECT * FROM ward as e WHERE e._district_id = :id")
	List<WardEntity> findAllById(@Param("id") Long id);
	
	
	
}
