package com.projectjavasem4.controller.admin;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.projectjavasem4.entities.BaseEntity;

public interface  ControllerGeneric<T extends BaseEntity> {
	ResponseEntity<Object> save(@RequestBody T entity);
	
	ResponseEntity<T> findAll();
	
	ResponseEntity<String> delete(@PathVariable Long id);
}
