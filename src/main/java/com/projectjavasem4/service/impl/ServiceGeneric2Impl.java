package com.projectjavasem4.service.impl;
import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectjavasem4.dto.AbstractDTO;
import com.projectjavasem4.entities.BaseEntity;
import com.projectjavasem4.repository.GenericRepository;
import com.projectjavasem4.service.ServiceGeneric;
@Service
public class ServiceGeneric2Impl <T extends BaseEntity, D extends AbstractDTO<T>> implements ServiceGeneric<T, D> {
	
	@Autowired protected GenericRepository<T> genericRepository;

	@Override
	public List<D> getAll() {
		List<T> entities = genericRepository.findAll();
		Type listType = new TypeToken<List<D>>() {}.getType();
		List<D> resultDtos = new ModelMapper().map(entities, listType);
		return resultDtos;
	}

	@Override
	public D findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
