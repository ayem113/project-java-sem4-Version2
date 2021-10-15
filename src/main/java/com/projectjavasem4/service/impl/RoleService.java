package com.projectjavasem4.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectjavasem4.entities.RoleEntity;
import com.projectjavasem4.repository.RoleRepository;
import com.projectjavasem4.service.IRoleService;
@Service
public class RoleService  implements IRoleService{

	@Autowired private RoleRepository proRep;

	@Override
	public RoleEntity getByName(String name) {
		RoleEntity pro = proRep.findByName(name);
		return pro;
	}
}
