package com.bookstore.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.domain.CartItem;
import com.bookstore.domain.ShoppingCart;

public interface ICartItemRepository extends CrudRepository<CartItem, Long>{
	
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	
	// List<CartItem> findByOrder(Order order);
}
