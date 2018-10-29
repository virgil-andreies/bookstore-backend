package com.bookstore.service.BookService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.Book;
import com.bookstore.repositories.IBookRepository;

@Service
public class BookService implements IBookService{
	
	@Autowired
	private IBookRepository bookRepository;

	@Override
	public List<Book> findAll() {
		List<Book> bookList = (List<Book>) bookRepository.findAll();
		
		List<Book> activeBookList = new ArrayList<>();
		
		for(Book book : bookList) {
			if(book.isActive()) {
				activeBookList.add(book);
			}
		}
		
		return activeBookList;
	}

	@Override
	public Book getById(Long id) {
		return bookRepository.findOne(id);
	}

	@Override
	public Book save(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public List<Book> blurrySsearch(String keyword) {
		List<Book> bookList = bookRepository.findByTitleContaining(keyword);
		
		List<Book> activeBookList = new ArrayList<>();
		
		for(Book book : bookList) {
			if(book.isActive()) {
				activeBookList.add(book);
			}
		}
		
		return activeBookList;
	}

	@Override
	public void remove(Long id) {
		bookRepository.delete(id);
	}
}
