package com.projectjavasem4.api.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.projectjavasem4.dto.AbstractDTO;
import com.projectjavasem4.entities.BaseEntity;
import com.projectjavasem4.service.ServiceGeneric;



//@RestController(value = "BaseAPIOfAdmin")

//@Component
public class BaseApi<T extends  BaseEntity, D extends AbstractDTO<T>> {

	
	@Autowired
	//@Lazy
	private ServiceGeneric<T ,D > x;

	
	@GetMapping("")
	public List<D> getAll() {
		return x.getAll();
	}
	@GetMapping("/{id}")
	public D getBId(@PathVariable long id) {
		return x.findById(id);
	}
	
	
	/*
	 * @PostMapping("") public D inserOrUpdate(@RequestBody T pro) { return
	 * x.save(pro); }
	 */

	
	
	
}
