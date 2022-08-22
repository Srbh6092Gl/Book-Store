package com.globallogic.bookstore.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.globallogic.bookstore.entity.Book;

@Repository
public interface BookService {
	
	public List<Book> getAllBooks();
	public Book getBookById(int id) throws Exception;
	public Book addBook(Book book);
	public String deleteBookById(int id);
	public Book updateBook(Book book);
	public Book updateBookById(Book changes,int id) throws Exception;
	
}