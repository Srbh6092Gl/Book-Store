package com.globallogic.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.bookstore.entity.Book;
import com.globallogic.bookstore.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookRepository bookRepo;

	@Override
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}

	@Override
	public Book getBookById(int id) throws Exception {
		Optional<Book> response = bookRepo.findById(id);
		if(response.isEmpty())
			throw new Exception("Book not found");
		return response.get();
	}

	@Override
	public Book addBook(Book book) {
		return bookRepo.save(book);
	}

	@Override
	public String deleteBookById(int id) {
		bookRepo.deleteById(id);
		return "Delete ID="+id+": SUCCESS";
	}

	@Override
	public Book updateBook(Book book) {
		return bookRepo.save(book);
	}

	@Override
	public Book updateBookById(Book changes, int id) throws Exception {
		Book Book = getBookById(id);
		return bookRepo.save(Book);
	}

}