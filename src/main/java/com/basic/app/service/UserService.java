package com.basic.app.service;

import org.springframework.stereotype.Service;

import com.basic.app.model.UserProfile;

@Service
public class UserService {
	
	public UserProfile loadUserByUsernamePasswordAndSystemName(String userName, String password, String systemName) {
		
		UserProfile user = new UserProfile();
		user.setName("test");
		user.getPermission().add("PERM_1");
		user.getPermission().add("PERM_2");
		user.getPermission().add("PERM_3");
		
		return user;
		
	}

}
