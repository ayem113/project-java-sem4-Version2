package com.projectjavasem4.service.impl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.projectjavasem4.constant.SystemConstant;
import com.projectjavasem4.dto.MyUser;
import com.projectjavasem4.entities.PermissionDetailEntity;
import com.projectjavasem4.entities.UserEntity;
import com.projectjavasem4.repository.UserRepository;
@Service
public class CustomUserDetailsService implements UserDetailsService {  // xử lý Authentication (xác thực)

	@Autowired private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {	
		UserEntity userEntity = userRepository.findOneByUsernameAndStt(username, SystemConstant.ACTIVE_STATUS);
		if (userEntity == null) { throw new UsernameNotFoundException("User not found");}
		//get role user
		List<GrantedAuthority> lstRole = new ArrayList<>(); 
		lstRole.add(new SimpleGrantedAuthority(userEntity.getRole().getName()));
		//get all permission user
		List<GrantedAuthority> lstPer = new ArrayList<>();
		for (PermissionDetailEntity perDetail : userEntity.getRole().getPermissionDetails()) {
			lstPer.add(new SimpleGrantedAuthority(perDetail.getPermission().getCode()));
		}

		// lưu tt người dùng khi đăng nhập
		//vì class user defaul của springcore chỉ có lưu  user vs pass nên ta phải custom lại class user để luuw nhiều tt hơn
		// suy ra tạo dto myuser exten user của springcore và thêm các trường cần thiết
		
		MyUser myUser = new MyUser(userEntity.getUsername(), userEntity.getPassword(), true, true, true, true,lstPer);
		myUser.setFullName(userEntity.getFullname());
		myUser.setRole(userEntity.getRole().getName());
		myUser.setAddress((userEntity.getAddress()));
		myUser.setSdt(userEntity.getSdt());
		myUser.setId(userEntity.getId());
		return myUser;
	}

}
