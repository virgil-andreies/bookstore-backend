package com.bookstore.service.BookService;

import java.util.List;

import com.bookstore.domain.Book;

public interface IBookService {
	List<Book> findAll();
	
	Book getById(long id);
	
	Book save(Book book);
	
	List<Book> blurrySsearch(String title);
	
	void remove(Long id);
}
