package com.globallogic.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.bookstore.entity.Book;
import com.globallogic.bookstore.entity.User;
import com.globallogic.bookstore.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	final String adminEmail="admin@admin.com";
	final String adminPass="admin";
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public List<User> getAllUser(String email, String password, boolean asAdmin) throws Exception {
		if(!asAdmin)
			throw new Exception("Login as admin");
		authenticateAdmin(email, password);
		return userRepo.findAll();
	}
	
	@Override
	public User registration(String email, String password, User user) {
		
		//Setting the email and password from parameters to the user body
		user.setEmail(email);
		user.setPassword(password);
		
		//Saving the user in repository
		return userRepo.save(user);
	}
	
	//Get order of a user from email and password
	@Override
	public List<Book> getOrders(String email, String password) throws Exception {
		
		//Getting user from repository if credentials are valid
		User user = autheticateUser(email,password);
		
		//Returning the user's order
		return user.getOrder();
	}
	

	//Getting user by email from the repository
	@Override
	public User getUserByEmail(String email) throws Exception {
		
		//Fetching user by email from repository
		User user = userRepo.findUserByEmail(email);
		
		//If the user is null
		if(user==null)
			throw new Exception("No user exists with this email");
		
		//If user is not null
		return user;
	}

	//Checking the admin's credentials
	private void authenticateAdmin(String email, String password) throws Exception {
		
		//If the email matches the admin's email and password
		if(!email.equalsIgnoreCase(adminEmail) || !email.equalsIgnoreCase(adminPass))
			throw new Exception("Wrong Credentials !!!!!!");
	}
	
	private User autheticateUser(String email, String password) throws Exception {
		
		//Fetching user by email from repository
		User user = getUserByEmail(email);
		
		//Checking if the password
		if(!password.equals(user.getPassword()))
			throw new Exception("Invalid password !!!!");
		
		//If the password is correct
		return user;
	}

	
}
