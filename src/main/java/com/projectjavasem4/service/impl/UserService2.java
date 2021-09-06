package com.projectjavasem4.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.projectjavasem4.dto.UsertDTO2;
import com.projectjavasem4.entities.ProductEntity;
import com.projectjavasem4.entities.UserEntity;
import com.projectjavasem4.repository.AbtracsRepository2;
import com.projectjavasem4.repository.CategoryRepository;
import com.projectjavasem4.repository.GenericRepository;
import com.projectjavasem4.repository.UserRepository;
import com.projectjavasem4.service.IUserService2;

@Service
public class UserService2 implements IUserService2 {

	/*
	 * @Autowired private UserRepository Rep;
	 */
	
	@Autowired
	
	private UserRepository AbRep;
	
	@Autowired
	private GenericRepository<ProductEntity> proRep;
	@Autowired
	private CategoryRepository CatRep;
	//private JpaRepository<UserEntity, Long> AbRep;
	
	 //private AbtracsRepository2<UserEntity> AbRep2;
	 
	
	/*
	 * @Autowired private AbtracsRepository2<UserEntity> AbRep2;
	 */
	
	/*
	 * @Override public List<UsertDTO2> getAll() { List<UsertDTO2> models = new
	 * ArrayList<>(); List<UserEntity> entities = Rep.findAll(); for (UserEntity
	 * item : entities) { UsertDTO2 p = new ModelMapper().map(item,
	 * UsertDTO2.class);
	 * 
	 * models.add(p); } return models; }
	 */
	
	@Override
	public List<UsertDTO2> getAll() {
		List<UsertDTO2> models = new ArrayList<>();
		List<UserEntity> entities =  AbRep.findAll();
		for (UserEntity item : entities) {
			UsertDTO2 p = new ModelMapper().map(item, UsertDTO2.class);
			
			models.add(p);
		}
		return models;
	}

	@Override
	public boolean save(UserEntity e) {
		try {
			AbRep.save(e);
			return true;
			
		} catch (Exception e2) {
			return false;
		}
		
		
	}
	
	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UsertDTO2 findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public void delete(long[] ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
	}

	

}
