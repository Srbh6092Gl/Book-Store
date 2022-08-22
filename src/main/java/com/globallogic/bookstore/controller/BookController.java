package com.globallogic.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.bookstore.entity.Book;
import com.globallogic.bookstore.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService bookService;
	
	//GET requests
	
	//GET request for fetching all Book
	@GetMapping
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	//GET request for fetching a Book by ID
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable int id) throws Exception {
		return bookService.getBookById(id);
	}
	
	
	//POST requests
	
	//POST request to add a Book
	@PostMapping
	public Book addBook( @RequestBody Book book) {
		return bookService.addBook(book);
	}
	
	
	//DELETE requests
	
	//DELETE request to delete a Book by id
	@DeleteMapping("/{id}")
	public String deleteBookById(@PathVariable int id) {
		return bookService.deleteBookById(id);
	}
	
	//PUT requests
	
	//PUT request to update a Book
	//If any field is missing, it will take default value for the respective field
	@PutMapping
	public Book updateBook(@RequestBody Book book) {
		return bookService.updateBook(book);
	}
	
	//PUT request to update a Book by id
	//If any field is missing, it will take default value for the respective field
	@PutMapping("/{id}")
	public Book updateBookById(@RequestBody Book changes,@PathVariable int id) throws Exception {
		return bookService.updateBookById(changes,id);
	}
}