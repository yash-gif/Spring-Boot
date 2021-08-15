package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public UserService() {}

	public UserService(UserRepository repo) {
		super();
		this.repo = repo;
	}
	
	public void saveMyUser(User user) {
		repo.save(user);
	}
	
	public Iterable<User> showAllUsers(){
		return repo.findAll();
	}
	
	public Iterable<User> deleteByUsername(String username){
		repo.deleteByUsername(username);
		return repo.findAll();
	}
	
	public User findByUsername(String username) {
		return repo.findByUsername(username);
		
	}
	
	

}
