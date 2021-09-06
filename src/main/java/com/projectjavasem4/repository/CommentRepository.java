package com.projectjavasem4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectjavasem4.entities.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
	
}
