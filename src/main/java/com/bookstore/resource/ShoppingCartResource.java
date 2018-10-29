package com.bookstore.resource;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.domain.Book;
import com.bookstore.domain.CartItem;
import com.bookstore.domain.ShoppingCart;
import com.bookstore.domain.User;
import com.bookstore.service.BookService.IBookService;
import com.bookstore.service.CartItemService.ICartItemService;
import com.bookstore.service.ShoppingCartService.IShoppingCartService;
import com.bookstore.service.UserService.IUserService;


@RestController
@RequestMapping("/cart")
public class ShoppingCartResource {
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IBookService bookService;
	
	@Autowired
	private ICartItemService cartItemService;
	
	@Autowired 
	private IShoppingCartService shoppingCartService;
	
	@RequestMapping("/add")
	public ResponseEntity addItem (	@RequestBody HashMap<String, String> mapper,
									Principal principal ) {
		String	bookId = mapper.get("bookId");
		String 	qty = mapper.get("qty");
		
		User user = userService.findByUsername(principal.getName());
		Book book = bookService.getById(Long.parseLong(bookId));
		
		if (Integer.parseInt(qty) > book.getInStockNumber()) {
			return new ResponseEntity("Not Enough Stock!", HttpStatus.BAD_REQUEST);
		}
		
		CartItem cartItem = cartItemService.addBookCartItem(book, user, Integer.parseInt(qty));
		
		return new ResponseEntity("Book Added Successfully", HttpStatus.OK);
	}
	
	@RequestMapping("/getCartItemList")
	public List<CartItem> getCartItemList(Principal principal) {
		User user = userService.findByUsername(principal.getName());
		ShoppingCart shoppingCart = user.getShoppingCart();
		
		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
		
		shoppingCartService.updateShoppingCart(shoppingCart);
		
		return cartItemList;
	}
	
	@RequestMapping("/getShoppingCart")
	public ShoppingCart getShoppingCart(Principal principal) {
		User user = userService.findByUsername(principal.getName());
		ShoppingCart shoppingCart = user.getShoppingCart();
		
		shoppingCartService.updateShoppingCart(shoppingCart);
		
		return shoppingCart;
	}
	
	@RequestMapping("/removeItem")
	public ResponseEntity removeItem(@RequestBody String id) {
		cartItemService.removeCartItem(cartItemService.findById(Long.parseLong(id)));
		
		return new ResponseEntity("Cart Item Removed Successfully", HttpStatus.OK);
	}
	
	@RequestMapping("/updateCartItem")
	public ResponseEntity updateCartItem(	@RequestBody HashMap<String, String> mapper) {
		String cartItemId = mapper.get("cartItemId");
		String qty = mapper.get("qty");
		
		CartItem cartItem = cartItemService.findById(Long.parseLong(cartItemId));
		cartItem.setQty(Integer.parseInt(qty));
		
		cartItemService.updateCartItem(cartItem);
		
		return new ResponseEntity("Cart Item Updated Successfully", HttpStatus.OK);
	}
}
