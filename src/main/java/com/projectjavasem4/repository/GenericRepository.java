package com.projectjavasem4.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.projectjavasem4.entities.BaseEntity;

//@NoRepositoryBean

public interface GenericRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
	
	
	
}
