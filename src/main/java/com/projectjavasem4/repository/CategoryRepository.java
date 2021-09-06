package com.projectjavasem4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectjavasem4.entities.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

	CategoryEntity findByCode(String code);
}
