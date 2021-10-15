package com.projectjavasem4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projectjavasem4.entities.ProvinceEntity;

public interface ProvinceRepository extends JpaRepository<ProvinceEntity, Long> {
	
	@Query(nativeQuery = true, value = "SELECT * FROM province as e WHERE e._name = :names") // 3. Spring JPA In cause
	// using native query
	List<ProvinceEntity> findByNames(@Param("names") String names);
	
	@Query(nativeQuery = true, value = "SELECT * FROM province") // 3. Spring JPA In cause
	// using native query
	List<ProvinceEntity> findBAll();

}
