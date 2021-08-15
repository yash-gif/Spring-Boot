package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.User;

public interface UserRepository extends CrudRepository<User,Integer>{
	
	//public void first(); // abstract method
	public Iterable<User> deleteByUsername(String username);
	public User findByUsername(String username);

}
