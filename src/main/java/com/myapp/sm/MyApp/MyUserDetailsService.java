package com.myapp.sm.MyApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myapp.sm.MyApp.Model.User;
import com.myapp.sm.MyApp.Repo.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository repo;
			
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user=repo.findByUsername(username);
    if(user==null) 
    	throw new UsernameNotFoundException("404");
    
		return new UserPrincipal(user);
	}

}
