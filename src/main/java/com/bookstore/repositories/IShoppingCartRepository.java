package com.bookstore.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bookstore.domain.ShoppingCart;

public interface IShoppingCartRepository extends CrudRepository<ShoppingCart, Long>{

}
