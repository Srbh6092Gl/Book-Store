package com.globallogic.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.globallogic.bookstore.entity.Book;
import com.globallogic.bookstore.entity.User;

@Repository
public interface UserService {
	public List<User> getAllUser(String email, String password, boolean asAdmin) throws Exception;
	public User registration(String email, String password, User user);
	public List<Book> getOrders(String email, String password) throws Exception;
	public User getUserByEmail(String email) throws Exception;
}
