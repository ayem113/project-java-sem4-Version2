package com.projectjavasem4.service;
import java.util.List;
import com.projectjavasem4.entities.UserEntity;
import com.projectjavasem4.dto.UserDTO;
public interface IUserService {
	List<UserDTO> getAll();
	int getTotalItem();
	UserDTO findById(long id);
	boolean save(UserEntity e);
	void delete(long[] ids);
	void deleteById(long id);
	void clearOTP(UserEntity u); 
}
