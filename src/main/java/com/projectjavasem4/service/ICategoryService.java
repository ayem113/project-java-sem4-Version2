package com.projectjavasem4.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.projectjavasem4.dto.CategoryDTO;
public interface ICategoryService   {
	List<CategoryDTO> findAll(Pageable pageable);
	List<CategoryDTO> getAll();
	int getTotalItem();
	CategoryDTO findById(long id);
	CategoryDTO save(CategoryDTO dto);
	void delete(long[] ids);
	void deleteById(long id);
	
	Map<String, String> findAll();
}
