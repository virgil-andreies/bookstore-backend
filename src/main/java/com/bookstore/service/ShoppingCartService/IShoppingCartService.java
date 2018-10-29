package com.bookstore.service.ShoppingCartService;

import com.bookstore.domain.ShoppingCart;

public interface IShoppingCartService {
	ShoppingCart updateShoppingCart(ShoppingCart shoppingCart);
	void clearShoppingCart(ShoppingCart shoppingCart);
}
