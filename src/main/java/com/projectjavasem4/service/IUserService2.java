package com.projectjavasem4.service;

import java.util.List;

import com.projectjavasem4.entities.UserEntity;
import com.projectjavasem4.dto.UsertDTO2;


public interface IUserService2 {
	List<UsertDTO2> getAll();
	int getTotalItem();
	UsertDTO2 findById(long id);
	boolean save(UserEntity e);
	void delete(long[] ids);
	void deleteById(long id);
	
	
}
