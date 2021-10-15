package com.projectjavasem4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectjavasem4.entities.CommentEntity;


@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
	
}
