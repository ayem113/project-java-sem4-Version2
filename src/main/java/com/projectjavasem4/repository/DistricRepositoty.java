package com.projectjavasem4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.projectjavasem4.entities.DistrictEntity;

public interface DistricRepositoty extends JpaRepository<DistrictEntity, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM district as e WHERE e._province_id = :id")
	List<DistrictEntity> findAllById(@Param("id") Long id);

}
