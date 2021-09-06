package com.projectjavasem4.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.projectjavasem4.dto.AbstractDTO;
import com.projectjavasem4.entities.BaseEntity;
import com.projectjavasem4.service.ServiceGeneric;

public class ControllerGenericImpl<T extends BaseEntity,D extends AbstractDTO<T>> implements ControllerGeneric<T> {

	
	@Autowired
	private ServiceGeneric<T,D> genericService;
	@Override
	public ResponseEntity<Object> save(T entity) {
		// TODO Auto-generated method stub
		return new ResponseEntity(genericService.getAll(), HttpStatus.OK);
	}

	@Override
	@GetMapping
	public ResponseEntity<T> findAll() {
		return new ResponseEntity(genericService.getAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
