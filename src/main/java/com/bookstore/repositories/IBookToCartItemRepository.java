package com.bookstore.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.domain.BookToCartItem;
import com.bookstore.domain.CartItem;

public interface IBookToCartItemRepository extends CrudRepository<BookToCartItem, Long>{
	void deleteByCartItem(CartItem cartItem);
}
