package com.globallogic.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.bookstore.entity.Book;
import com.globallogic.bookstore.entity.User;
import com.globallogic.bookstore.service.UserService;

@RestController
@RequestMapping
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping
	public List<User> getAllUsers(@RequestParam("email") String email,
							@RequestParam("password") String password,
							@RequestParam("asAdmin") boolean asAdmin) throws Exception {
		return userService.getAllUser(email,password,asAdmin);
	}
	
	@GetMapping("/getorder")
	public List<Book> getOrder(@RequestParam("email") String email,
							@RequestParam("password") String password) throws Exception{
		return userService.getOrders(email,password);
	}
	
	@GetMapping("/email/{email}")
	public User getUserbyEmail(@PathVariable("email") String email) throws Exception {
		return userService.getUserByEmail(email);
	}
	
	
	//POST mapping to register a new user
	//Email, password as request parameters
	//User as request body
	@PostMapping("/register")
	public User register(@RequestParam("email") String email,
						@RequestParam("password") String password,
						@RequestBody User user) {
		return userService.registration(email, password, user);
	}
	
	
}