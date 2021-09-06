package com.projectjavasem4.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.projectjavasem4.dto.CategoryDTO;
import com.projectjavasem4.entities.CategoryEntity;
import com.projectjavasem4.entities.UserEntity;
import com.projectjavasem4.repository.CategoryRepository;
import com.projectjavasem4.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryRepository CatRep;

	@Autowired
	private JpaRepository<CategoryEntity, Long> AbRep;

	@Override
	public List<CategoryDTO> findAll(Pageable pageable) {
		return null;

	}

	@Override
	public int getTotalItem() {
		return (int) CatRep.count();
	}

	@Override
	public CategoryDTO findById(long id) {

		CategoryEntity pro = CatRep.findOne(id);

		return new ModelMapper().map(pro, CategoryDTO.class);

		// proRep.getOne(id);
	}

	@Override
	public CategoryDTO save(CategoryDTO dto) {
		return null;
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			CatRep.delete(id);
		}
	}

	@Override
	public List<CategoryDTO> getAll() {
		List<CategoryDTO> models = new ArrayList<>();
		List<CategoryEntity> entities = AbRep.findAll();
		for (CategoryEntity item : entities) {
			CategoryDTO p = new ModelMapper().map(item, CategoryDTO.class);

			models.add(p);
		}
		return models;
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<String, String> findAll() {
		Map<String, String> result = new HashMap<>();
		List<CategoryEntity> entities = CatRep.findAll();
		for (CategoryEntity item: entities) {
			result.put(item.getCode(), item.getName());
		}
		return result;
	}

}
