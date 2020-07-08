package com.myapp.sm.MyApp.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.sm.MyApp.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);

}
