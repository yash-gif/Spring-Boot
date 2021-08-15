package com.example.demo.Controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Service.UserService;
import com.example.demo.model.User;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/save-user")
	@Transactional
	@CrossOrigin
	public String registerUser(@RequestBody User user) {
		service.saveMyUser(user);
		return "Hello "+user.getFirstname()+" your registration is successful!";
	}
	
	@GetMapping("/all-users")
	@CrossOrigin
	public Iterable<User> showAllUsers(){
		return service.showAllUsers();
	}
	
	@GetMapping("/delete/{username}")
	@Transactional
	@CrossOrigin
	public Iterable<User> deleteUser(@PathVariable String username){
		return service.deleteByUsername(username); 
	}
	
	@GetMapping("/search/{username}")
	@CrossOrigin
	public User searchUser(@PathVariable String username) {
		return service.findByUsername(username);
	}

}
