package com.bookstore.service.OrderService;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.BillingAddress;
import com.bookstore.domain.Book;
import com.bookstore.domain.CartItem;
import com.bookstore.domain.Order;
import com.bookstore.domain.Payment;
import com.bookstore.domain.ShippingAddress;
import com.bookstore.domain.ShoppingCart;
import com.bookstore.domain.User;
import com.bookstore.repositories.IBillingAddressRepository;
import com.bookstore.repositories.IOrderRepository;
import com.bookstore.repositories.IPaymentRepository;
import com.bookstore.repositories.IShippingAddressRepository;
import com.bookstore.service.BookService.IBookService;
import com.bookstore.service.CartItemService.ICartItemService;
import com.bookstore.utility.MailConstructor;

@Service
public class OrderService implements IOrderService {
	
	@Autowired
	private IOrderRepository orderRepository;
	
	@Autowired
	private IBillingAddressRepository billingAddressRepository;
	
	@Autowired
	private IShippingAddressRepository shippingAddressRepository;
	
	@Autowired
	private IPaymentRepository paymentRepository;
	
	@Autowired
	private ICartItemService cartItemService;
	
	@Autowired
	private IBookService bookService;
	
	@Autowired
	private MailConstructor mailConstructor;
	
	@Override
	public synchronized Order createOrder(ShoppingCart shoppingCart, ShippingAddress shippingAddress, BillingAddress billingAddress,
			Payment payment, String shippingMethod, User user) {
		
		Order order = new Order();
		order.setBillingAddress(billingAddress);
		order.setOrderStatus("created");
		order.setPayment(payment);
		order.setShippingAddress(shippingAddress);
		order.setShippingMethod(shippingMethod);
		
		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
		
		for (CartItem cartItem : cartItemList) {
			Book book = cartItem.getBook();
			cartItem.setOrder(order);
			book.setInStockNumber(book.getInStockNumber() - cartItem.getQty());
		}
		
		order.setCartItemList(cartItemList);
		order.setOrderDate(Calendar.getInstance().getTime());
		order.setOrderTotal(shoppingCart.getGrandTotal());
		shippingAddress.setOrder(order);
		billingAddress.setOrder(order);
		payment.setOrder(order);
		order.setUser(user);
		order = orderRepository.save(order);
		
		return order;
	}

	@Override
	public Order findOne(Long id) {
		return orderRepository.findOne(id);
	}

}
