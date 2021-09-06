package com.projectjavasem4.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectjavasem4.repository.AbtracsRepository;
import com.projectjavasem4.service.IUserService3;
@Service
public class UserService3  implements IUserService3{

	@Autowired
	private AbtracsRepository AbRep;
	
	@Override
	public int getAll() {
		// TODO Auto-generated method stub
		return AbRep.compareTo(4);
	}
 
}
