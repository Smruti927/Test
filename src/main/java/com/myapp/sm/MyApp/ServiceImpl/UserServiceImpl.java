package com.myapp.sm.MyApp.ServiceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.sm.MyApp.Model.User;
import com.myapp.sm.MyApp.Repo.UserRepository;
import com.myapp.sm.MyApp.Service.UserSrevice;

@Service  
@Transactional  
public class UserServiceImpl implements UserSrevice {

	
	@Autowired
	private UserRepository repo;
			
	
	@Override
	public String save(User user) {
		repo.save(user);
		return "SUCCESS";
	}
	

}
