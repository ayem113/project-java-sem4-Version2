package com.projectjavasem4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectjavasem4.entities.PermissionEntity;

public interface PermissionRepository extends JpaRepository<PermissionEntity, Long> {
	
}
