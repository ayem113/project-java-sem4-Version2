package com.projectjavasem4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectjavasem4.entities.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
	RoleEntity findByName(String name);
}
