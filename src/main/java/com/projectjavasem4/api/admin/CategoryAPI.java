package com.projectjavasem4.api.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projectjavasem4.dto.CategoryDTO;
import com.projectjavasem4.service.ICategoryService;

@RestController(value = "CategoryAPIOfAdmin")
public class CategoryAPI {

	@Autowired
	private ICategoryService CatService;

	
	@GetMapping("/api/category")
	public List<CategoryDTO> getAll() {
		return CatService.getAll();
	}
	
	
	

	@DeleteMapping("/api/category")
	public void deleteNew(@RequestBody long[] ids) {
		CatService.delete(ids);
	}

}
