package com.projectjavasem4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.projectjavasem4.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	UserEntity findOneByUsernameAndStt(String username, int activeStatus);
	UserEntity findOneByEmail(String email);
	UserEntity findOneByUsername(String name);
	
	@Modifying 
	@Transactional 
	@Query(nativeQuery = true, value = "UPDATE users SET codeCheckPass = :code WHERE id = :id") 
	void updateCodeCheckPass(@Param("code")String code,@Param("id")Long id);
	
	@Query(nativeQuery = true, value = "SELECT * FROM users where codeCheckPass= :code and email= :email")
	UserEntity checkCodeResetPass(@Param("code")String code,@Param("email")String email);
	
}
