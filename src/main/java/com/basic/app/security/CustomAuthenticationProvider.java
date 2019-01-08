package com.basic.app.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.basic.app.model.UserProfile;
import com.basic.app.service.UserService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserService userService;
	
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		// TODO Auto-generated method stub
		if(!auth.isAuthenticated()) {
		
			String name = auth.getName();
	        String password = auth.getCredentials().toString();
	        
	        UserProfile user = userService.loadUserByUsernamePasswordAndSystemName(name, password, "DEPO");
	        List<Authorities> gant = new ArrayList<Authorities>();
			for (String authorities : user.getPermission()) {
				Authorities ga = new Authorities(authorities);
				gant.add(ga);
			}
	             // use the credentials
	             // and authenticate against the third-party system
			Authentication authenticated = new UsernamePasswordAuthenticationToken(user, name, gant);
	         return  authenticated;
		} else {
			return null;
		}
       
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}