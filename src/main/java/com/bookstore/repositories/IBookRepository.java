package com.bookstore.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.domain.Book;


public interface IBookRepository extends CrudRepository<Book, Long> {
	List<Book> findByTitleContaining(String keyword);
}
